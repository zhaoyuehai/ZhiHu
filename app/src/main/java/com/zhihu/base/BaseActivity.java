package com.zhihu.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zhihu.AppContext;
import com.zhihu.AppManager;
import com.zhihu.R;
import com.zhihu.interf.BaseViewInterface;
import com.zhihu.ui.dialog.DialogControl;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements DialogControl, BaseViewInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (AppContext.getNightModeSwitch()) {
            setTheme(R.style.AppTheme_Night);
        } else {
            setTheme(R.style.AppTheme_Light);
        }
        AppManager.getInstance().addActivity(this);
        onBeforeSetContentLayout();
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        init(savedInstanceState);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    protected int getLayoutId() {
        return 0;
    }

    protected void onBeforeSetContentLayout() {
    }

    protected void init(Bundle savedInstanceState) {
    }

    @Override
    public void hideWaitDialog() {

    }

    @Override
    public ProgressDialog showWaitDialog() {
        return showWaitDialog(R.string.loading);
    }

    @Override
    public ProgressDialog showWaitDialog(int resId) {
        return showWaitDialog(getString(resId));
    }

    @Override
    public ProgressDialog showWaitDialog(String str) {
        //TODO
        return null;
    }
}
