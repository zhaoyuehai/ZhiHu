package com.zhihu.ui.dialog;

import android.app.ProgressDialog;

/**
 * Created by 月海 on 2016/7/1.
 */
public interface DialogControl {
    void hideWaitDialog();
    ProgressDialog showWaitDialog();
    ProgressDialog showWaitDialog(int resId);
    ProgressDialog showWaitDialog(String str);
}
