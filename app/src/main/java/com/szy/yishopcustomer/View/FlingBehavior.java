package com.szy.yishopcustomer.View;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.*;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Smart on 2017/5/27.
 * All Rights Reserved By 秦皇岛商之翼网络科技有限公司.
 */
public final class FlingBehavior extends AppBarLayout.Behavior {
    private static final int TOP_CHILD_FLING_THRESHOLD = 3;
    private boolean isPositive = true;
    private boolean isTop = true;

    public FlingBehavior() {
    }

    public FlingBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, AppBarLayout child, View directTargetChild, View target, int nestedScrollAxes) {
        super.onNestedScrollAccepted(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout parent, AppBarLayout child, View directTargetChild, View target, int nestedScrollAxes) {
        return super.onStartNestedScroll(parent, child, directTargetChild, target, nestedScrollAxes);

    }

    @Override
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout abl, View target) {
        super.onStopNestedScroll(coordinatorLayout, abl, target);
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }

    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, float velocityX, float velocityY, boolean consumed) {

        if (target instanceof RecyclerView) {
            final RecyclerView recyclerView = (RecyclerView) target;
            if (scrollListenerMap.get(recyclerView) == null) {
                RecyclerViewScrollListener recyclerViewScrollListener = new RecyclerViewScrollListener(coordinatorLayout, child, this);
                scrollListenerMap.put(recyclerView, recyclerViewScrollListener);
                recyclerView.addOnScrollListener(recyclerViewScrollListener);
            }
            scrollListenerMap.get(recyclerView).setVelocity(velocityY);
            consumed = scrollListenerMap.get(recyclerView).getScrolledY() > 0; //recyclerView only consume the fling when it's not scrolled to the top
        }


        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, int dx, int dy, int[] consumed) {

        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);

        isPositive = dy > 0;
    }



    private Map<RecyclerView, RecyclerViewScrollListener> scrollListenerMap = new HashMap<>();

    private static class RecyclerViewScrollListener extends RecyclerView.OnScrollListener {
        private int scrolledY;
        private boolean dragging;
        private float velocity;
        private WeakReference<CoordinatorLayout> coordinatorLayoutRef;
        private WeakReference<AppBarLayout> childRef;
        private WeakReference<FlingBehavior> behaviorWeakReference;

        public RecyclerViewScrollListener(CoordinatorLayout coordinatorLayout, AppBarLayout child, FlingBehavior barBehavior) {
            coordinatorLayoutRef = new WeakReference<CoordinatorLayout>(coordinatorLayout);
            childRef = new WeakReference<AppBarLayout>(child);
            behaviorWeakReference = new WeakReference<FlingBehavior>(barBehavior);
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            dragging = newState == RecyclerView.SCROLL_STATE_DRAGGING;
        }

        public void setVelocity(float velocity) {
            this.velocity = velocity;
        }

        public int getScrolledY() {
            return scrolledY;
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            scrolledY += dy;

            if (scrolledY <= 0 && !dragging && childRef.get() != null && coordinatorLayoutRef.get() != null && behaviorWeakReference.get() != null) {
                //manually trigger the fling when it's scrolled at the top
                behaviorWeakReference.get().onNestedFling(coordinatorLayoutRef.get(), childRef.get(), recyclerView, 0, velocity, false);
            }
        }
    }
}