package com.szy.yishopcustomer.ViewHolder.User;

import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lyzb.jbx.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 宗仁 on 16/7/27.
 * All Rights Reserved By 秦皇岛商之翼网络科技有限公司.
 */
public class UserGuessTitleViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.img_title)
    public ImageView img_title;

    public UserGuessTitleViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
