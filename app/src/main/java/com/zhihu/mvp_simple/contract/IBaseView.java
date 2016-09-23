package com.zhihu.mvp_simple.contract;

/**
 * Created by 月海 on 2016/9/14.
 */

public interface IBaseView {
    void setPresenter(UserInfoContract.IActivityPresenter mIActivityPresenter);

    void setILifeCycle(UserInfoContract.ILifeCycle mILifeCycle);
}
