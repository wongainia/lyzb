package com.szy.yishopcustomer.Activity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.szy.yishopcustomer.Fragment.ShopCloseFragment;
import com.lyzb.jbx.R;

/**
 * Created by liwei on 17/2/10.
 * All Rights Reserved By 秦皇岛商之翼网络科技有限公司.
 */

public class ShopCloseActivity extends YSCBaseActivity {

    @Override
    public ShopCloseFragment createFragment() {
        return new ShopCloseFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mLayoutId = R.layout.activity_common_no_toolbar;
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.pop_enter_anim, R.anim.pop_exit_anim);
        Window win = this.getWindow();
        WindowManager.LayoutParams lp = win.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        win.setAttributes(lp);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.pop_enter_anim, R.anim.pop_exit_anim);
    }
}