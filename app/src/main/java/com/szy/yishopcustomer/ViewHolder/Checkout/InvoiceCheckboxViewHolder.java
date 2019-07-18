package com.szy.yishopcustomer.ViewHolder.Checkout;

import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lyzb.jbx.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 宗仁 on 16/7/22.
 * All Rights Reserved By 秦皇岛商之翼网络科技有限公司.
 */
public class InvoiceCheckboxViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.image_checkbox)
    public ImageView imageView;
    @BindView(R.id.fragment_invoice_info_checkbox_textView)
    public TextView textView;
    @BindView(R.id.fragment_invoice_info_checkbox_wrapperRelativelayout)
    public RelativeLayout wrapperRelativeLayout;

    public InvoiceCheckboxViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
