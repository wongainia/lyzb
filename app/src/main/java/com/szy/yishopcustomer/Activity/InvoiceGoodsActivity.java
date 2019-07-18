package com.szy.yishopcustomer.Activity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.szy.yishopcustomer.Fragment.InvoiceGoodsFragment;
import com.lyzb.jbx.R;

/**
 * Created by liwei on 16/11/07.
 * All Rights Reserved By 秦皇岛商之翼网络科技有限公司.
 */
public class InvoiceGoodsActivity extends YSCBaseActivity {

    @Override
    protected InvoiceGoodsFragment createFragment() {
        return new InvoiceGoodsFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBar.hide();

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
