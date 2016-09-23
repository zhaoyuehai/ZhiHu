package com.zhihu.mvp_simple.views;

import com.zhihu.base.BaseActivity;
import com.zhihu.mvp_simple.contract.UserInfoContract;
import com.zhihu.mvp_simple.presenter.ActivityPresenter;

/**
 * Created by 月海 on 2016/9/14.
 */

public class SimpleMvpActivity extends BaseActivity implements UserInfoContract.IView {
    private UserInfoContract.IActivityPresenter mIActivityPresenter;
    private UserInfoContract.ILifeCycle mILifeCycle;

    @Override
    public void initView() {
        new ActivityPresenter(this);
        mILifeCycle.onCreate();
    }

    @Override
    public void initData() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void showUserInfo() {

    }

    @Override
    public void setPresenter(UserInfoContract.IActivityPresenter mIActivityPresenter) {
        this.mIActivityPresenter = mIActivityPresenter;
    }

    @Override
    public void setILifeCycle(UserInfoContract.ILifeCycle mILifeCycle) {
        this.mILifeCycle = mILifeCycle;
    }

    @Override
    protected void onRestart() {
        mILifeCycle.onRestart();
        super.onRestart();
    }

    @Override
    protected void onStart() {
        mILifeCycle.onStart();
        super.onStart();
    }

    @Override
    protected void onResume() {
        mILifeCycle.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mILifeCycle.onPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        mILifeCycle.onStop();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mILifeCycle.onDestroy();
        super.onDestroy();
    }
}
