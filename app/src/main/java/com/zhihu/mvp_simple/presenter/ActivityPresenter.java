package com.zhihu.mvp_simple.presenter;

import com.zhihu.mvp_simple.contract.UserInfoContract;

/**
 * Created by 月海 on 2016/9/14.
 */

public class ActivityPresenter implements UserInfoContract.IActivityPresenter,UserInfoContract.ILifeCycle {

    private UserInfoContract.IView mIView;

    public ActivityPresenter(UserInfoContract.IView view) {
        mIView = view;
        mIView.setPresenter(this);
        mIView.setILifeCycle(this);
    }

    @Override
    public void loadUserInfo() {

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onRestart() {

    }
}
