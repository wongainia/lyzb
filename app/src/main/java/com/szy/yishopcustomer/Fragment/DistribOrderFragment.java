package com.szy.yishopcustomer.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.*;
import android.widget.TextView;

import com.szy.common.Other.CommonEvent;
import com.szy.common.Other.CommonRequest;
import com.szy.common.View.CommonRecyclerView;
import com.szy.yishopcustomer.Activity.RootActivity;
import com.szy.yishopcustomer.Adapter.DistribOrderAdapter;
import com.szy.yishopcustomer.Constant.Api;
import com.szy.yishopcustomer.Constant.EventWhat;
import com.lyzb.jbx.R;
import com.szy.yishopcustomer.ResponseModel.Distrib.DistribOrderModel;
import com.szy.yishopcustomer.Util.HttpResultManager;
import com.szy.yishopcustomer.Util.Utils;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import me.zongren.pullablelayout.Constant.Side;

public class DistribOrderFragment extends YSCBaseFragment {

    private static final int HTTP_WHAT_DISTRIB_ORDER = 1;

    @BindView(R.id.dis_all_textView)
    TextView mAll;
    @BindView(R.id.dis_unalready_textView)
    TextView mDisUnalready;
    @BindView(R.id.dis_already_textView)
    TextView mDisAlready;
    @BindView(R.id.dis_cancel_textView)
    TextView mDisCancel;

    @BindView(R.id.fragment_distrib_order_recyclerView)
    CommonRecyclerView mRecyclerView;


    private DistribOrderAdapter mAdapter;
    private DistribOrderModel data;

    //默认加载第一页
    private int cur_page = 1;
    private int page_size = 10;

    private int temp = 1;

    private String type = "dis_all";//默认展示全部

/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/



    public void loadMore() {
        if (data.data != null && cur_page > data.data.page.page_count) {
            //设置footer
            View footer = LayoutInflater.from(getContext()).inflate(R.layout
                    .fragment_goods_list_item_empty, null);
            mAdapter.setFooterView(footer);
            upDataSuccess = false;
        } else {
            refresh();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLayoutId = R.layout.fragment_distrib_order;
        mAdapter = new DistribOrderAdapter();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        mAll.setOnClickListener(this);
        mDisUnalready.setOnClickListener(this);
        mDisAlready.setOnClickListener(this);
        mDisCancel.setOnClickListener(this);

        mRecyclerView.addOnScrollListener(mOnScrollListener);
        mRecyclerView.setAdapter(mAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setEmptyViewClickListener(this);

        refresh();
        switchButton(mAll);
        return view;
    }

    @Override
    public void onEmptyViewClicked() {
        goIndex();
    }

    @Override
    public void onClick(View view) {
        if (Utils.isDoubleClick()) {
            return;
        }

        switch (view.getId()) {
            case R.id.dis_all_textView:
                cur_page = 1;
                type = "dis_all";
                switchButton(mAll);
                refresh();
                break;
            case R.id.dis_unalready_textView:
                cur_page = 1;
                type = "dis_unalready";
                switchButton(mDisUnalready);
                refresh();
                break;
            case R.id.dis_already_textView:
                cur_page = 1;
                type = "dis_already";
                switchButton(mDisAlready);
                refresh();
                break;
            case R.id.dis_cancel_textView:
                cur_page = 1;
                type = "dis_cancel";
                switchButton(mDisCancel);
                refresh();
                break;
            case R.id.empty_view_button:
                EventBus.getDefault().post(new CommonEvent(EventWhat.EVENT_OPEN_INDEX.getValue()));
                startActivity(new Intent().setClass(getActivity(), RootActivity.class));
                finish();
                break;
            default:
                super.onClick(view);
                break;
        }
    }


    public void refresh() {
        CommonRequest request = new CommonRequest(Api.API_DISTRIB_ORDER, HTTP_WHAT_DISTRIB_ORDER);
        request.add("page[cur_page]", cur_page);
        request.add("page[page_size]", page_size);
        request.add("dis_status", type);
        addRequest(request);
    }

    //接口成功回调
    @Override
    protected void onRequestSucceed(int what, String response) {
        switch (what) {
            case HTTP_WHAT_DISTRIB_ORDER:
                refreshSucceed(response);
                break;
            default:
                super.onRequestSucceed(what, response);
                break;
        }
    }

    //设置数据
    private void refreshSucceed(String response) {
        HttpResultManager.resolve(response, DistribOrderModel.class, new HttpResultManager
                .HttpResultCallBack<DistribOrderModel>() {
            @Override
            public void onSuccess(DistribOrderModel back) {
                data = back;

                if(temp == 1) {
                    mAll.setText("全部(" + back.data.order_counts.dis_all + ")");
                    mDisUnalready.setText("待分成(" + back.data.order_counts.dis_unalready + ")");
                    mDisAlready.setText("已分成(" + back.data.order_counts.dis_already + ")");
                    mDisCancel.setText("取消分成(" + back.data.order_counts.dis_cancel + ")");
                    temp++;
                }

                if (cur_page == 1) {
                    mAdapter.data.clear();
                    mAdapter.setFooterView(null);
                }

                if (back.data.list.size() > 0) {
                    upDataSuccess = true;
                    mRecyclerView.hideEmptyView();
                    mAdapter.data.addAll(back.data.list);
                } else {
                    mRecyclerView.showEmptyView();
                }
                mAdapter.notifyDataSetChanged();
            }
        });
    }


    private boolean upDataSuccess = true;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                if (mRecyclerView.reachEdgeOfSide(Side.BOTTOM)) {
                    if (upDataSuccess) {
                        if (data != null) {
                            cur_page = data.data.page.cur_page + 1;
                            loadMore();
                        }
                    }
                }
            }
        }
    };

    void switchButton(View w) {

        mAll.setSelected(false);
        mDisUnalready.setSelected(false);
        mDisAlready.setSelected(false);
        mDisCancel.setSelected(false);

        w.setSelected(true);
    }

    public void goIndex() {
        startActivity(new Intent().setClass(getActivity(), RootActivity.class));
        EventBus.getDefault().post(new CommonEvent(EventWhat.EVENT_OPEN_INDEX.getValue()));
        this.finish();
    }
}
