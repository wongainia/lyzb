/*
 * Copyright (c) 2014,KJFrameForAndroid Open Source Project,张涛.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.szy.yishopcustomer.View;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.*;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;

/**
 * Created by liuzhifeng on 16/11/17.
 * All Rights Reserved By 秦皇岛商之翼网络科技有限公司.
 * 和ios一样有上拉下拉效果
 */
public class KJScrollView extends ScrollView {

    // data
    private static final float MOVE_FACTOR = 0.5f; // 移动因子,手指移动100px,那么View就只移动50px

    private static final int ANIM_TIME = 300; // 松开手指后, 界面回到正常位置需要的动画时间
    public static ElasticScrollViewUpListener elasticScrollViewUpListener;
    // 会在手指移动时更新为当前手指的Y值
    public static ElasticScrollViewDownListener elasticScrollViewDownListener;
    public static boolean isMove = false; // 记录是否移动了布局
    private final Rect originalRect = new Rect();// 用于记录正常的布局位置
    private float startY;// 手指按下时的Y值, 用于在移动时计算移动距离,如果按下时不能上拉和下拉，
    // ui
    private View contentView; // SclrolView的唯一内容控件
    // flag
    private boolean canPullDown = false; // 是否可以继续下拉
    private boolean canPullUp = false; // 是否可以继续上拉
    private boolean isMoved = false; // 记录是否移动了布局
    private ScrollListener mListener;

    public KJScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    public KJScrollView(Context context) {
        super(context);
    }

    public KJScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void addView(View child) {
        super.addView(child);
        onFinishInflate();
    }

    @Override
    public void addView(View child, int index) {
        super.addView(child, index);
        onFinishInflate();
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        onFinishInflate();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (contentView == null) {
            return;
        }
        // ScrollView中的唯一子控件的位置信息, 这个位置信息在整个控件的生命周期中保持不变
        originalRect.set(contentView.getLeft(), contentView.getTop(), contentView.getRight(),
                contentView.getBottom());
    }

    /**
     * 在触摸事件中, 处理上拉和下拉的逻辑
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (contentView == null) {
            return super.dispatchTouchEvent(ev);
        }
        // 手指是否移动到了当前ScrollView控件之外
        boolean isTouchOutOfScrollView = ev.getY() >= this.getHeight() || ev.getY() <= 0;
        if (isTouchOutOfScrollView) { // 如果移动到了当前ScrollView控件之外
            if (isMoved) {// 如果当前contentView已经被移动, 首先把布局移到原位置
                boundBack();
            }
            return true;
        }
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                // 判断是否可以上拉和下拉
                canPullDown = isCanPullDown();
                canPullUp = isCanPullUp();
                // 记录按下时的Y值
                startY = ev.getY();

                break;
            case MotionEvent.ACTION_UP:
                boundBack();
                break;
            case MotionEvent.ACTION_MOVE:
                // 在移动的过程中， 既没有滚动到可以上拉的程度， 也没有滚动到可以下拉的程度
                if (!canPullDown && !canPullUp) {
                    startY = ev.getY();
                    canPullDown = isCanPullDown();
                    canPullUp = isCanPullUp();
                    break;
                }
                // 计算手指移动的距离
                float nowY = ev.getY();
                int deltaY = (int) (nowY - startY);

                // 是否应该移动布局
                boolean shouldMove = (canPullDown && deltaY > 0) // 可以下拉， 并且手指向下移动
                        || (canPullUp && deltaY < 0) // 可以上拉， 并且手指向上移动
                        || (canPullUp && canPullDown); //
                // 既可以上拉也可以下拉（这种情况出现在ScrollView包裹的控件比ScrollView还小）
                if (shouldMove) {
                    // 计算偏移量
                    int offset = (int) (deltaY * MOVE_FACTOR);
                    // 随着手指的移动而移动布局
                    contentView.layout(originalRect.left, originalRect.top + offset, originalRect
                            .right, originalRect.bottom + offset);
                    isMoved = true; // 记录移动了布局
                    if (offset > 180) {
                        if (canPullDown) {
                            if (elasticScrollViewDownListener != null) {
                                elasticScrollViewDownListener.DownPullListener();
                            }
                        }
                    }
                    if (offset < -180) {
                        if (canPullUp) {
                            if (elasticScrollViewUpListener != null) {
                                elasticScrollViewUpListener.UpPullListener();
                            }
                        }
                    }
                }

                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void addView(View child, int width, int height) {
        super.addView(child, width, height);
        onFinishInflate();
    }

    public void setOnElasticScrollViewListener(ElasticScrollViewUpListener ScrollViewUpListener) {
        elasticScrollViewUpListener = ScrollViewUpListener;
    }

    public void setOnElasticScrollViewListener(ElasticScrollViewDownListener
                                                       ScrollViewDownListener) {
        elasticScrollViewDownListener = ScrollViewDownListener;
    }

    public void setScrollListener(ScrollListener l) {
        this.mListener = l;
    }

    @Override
    protected void onScrollChanged(int x, int y, int oldx, int oldy) {
        // TODO Auto-generated method stub
        super.onScrollChanged(x, y, oldx, oldy);
        if (mListener != null) {
            mListener.scrollOrientation(x, y, oldx, oldy);
        }
    }

    @Override
    protected void onFinishInflate() {
        if (getChildCount() > 0) {
            contentView = getChildAt(0);
        }
    }

    /**
     * 将内容布局移动到原位置 可以在UP事件中调用, 也可以在其他需要的地方调用, 如手指移动到当前ScrollView外时
     */
    private void boundBack() {
        if (!isMoved) {
            return; // 如果没有移动布局， 则跳过执行
        }
        // 开启动画
        TranslateAnimation anim = new TranslateAnimation(0, 0, contentView.getTop(), originalRect
                .top);
        anim.setDuration(ANIM_TIME);
        contentView.startAnimation(anim);
        // 设置回到正常的布局位置
        contentView.layout(originalRect.left, originalRect.top, originalRect.right, originalRect
                .bottom);
        // 将标志位设回false
        canPullDown = false;
        canPullUp = false;
        isMoved = false;
    }

    /**
     * 判断是否滚动到顶部
     */
    private boolean isCanPullDown() {
        if (isMove) {
            return false;
        } else {
            return getScrollY() == 0 || contentView.getHeight() < getHeight() + getScrollY();
        }

    }

    /**
     * 判断是否滚动到底部
     */
    private boolean isCanPullUp() {
        return contentView.getHeight() <= getHeight() + getScrollY();
    }

    public interface ScrollListener {//声明接口，用于传递数据

        void scrollOrientation(int l, int t, int oldl, int oldt);
    }

    public interface ElasticScrollViewUpListener {
        void UpPullListener();
    }

    public interface ElasticScrollViewDownListener {
        void DownPullListener();
    }
}