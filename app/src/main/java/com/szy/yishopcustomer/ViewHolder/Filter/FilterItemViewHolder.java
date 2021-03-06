package com.szy.yishopcustomer.ViewHolder.Filter;

import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.TextView;

import com.lyzb.jbx.R;
import com.szy.yishopcustomer.View.FilterCheckBox;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 宗仁 on 2016/8/20.
 * All Rights Reserved By 秦皇岛商之翼网络科技有限公司.
 */
public class FilterItemViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.fragment_filter_item_textView)
    public FilterCheckBox textView;

    public FilterItemViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
