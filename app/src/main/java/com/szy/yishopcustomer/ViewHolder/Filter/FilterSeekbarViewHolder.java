package com.szy.yishopcustomer.ViewHolder.Filter;

import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.TextView;

import com.jaygoo.widget.RangeSeekBar;
import com.lyzb.jbx.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liwei on 17/10/11.
 * All Rights Reserved By 秦皇岛商之翼网络科技有限公司.
 */
public class FilterSeekbarViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.progressTextView)
    public TextView progressTextView;
    @BindView(R.id.seekbar)
    public RangeSeekBar rangeSeekBar;

    public FilterSeekbarViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
