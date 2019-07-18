package com.szy.yishopcustomer.ViewHolder.Checkout;

import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;

import com.lyzb.jbx.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 宗仁 on 16/7/20.
 * All Rights Reserved By 秦皇岛商之翼网络科技有限公司.
 */
public class GoodsViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.fragment_checkout_goods_imageView)
    public ImageView imageView;
    @BindView(R.id.fragment_checkout_goods_nameTextView)
    public TextView nameTextView;
    @BindView(R.id.fragment_checkout_goods_priceTextView)
    public TextView priceTextView;
    @BindView(R.id.fragment_checkout_goods_attributeTextView)
    public TextView attributeTextView;
    @BindView(R.id.fragment_checkout_goods_numberTextView)
    public TextView numberTextView;
    @BindView(R.id.fragment_checkout_goods_giftTextView)
    public TextView giftTextView;
    @BindView(R.id.fragment_checkout_no_stock_image)
    public ImageView mNoStockImage;
    @BindView(R.id.item_order_explain)
    public TextView item_order_explain;
    @BindView(R.id.fragment_checkout_deductibleTextView)
    public TextView deductibleTextView;

    public GoodsViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
