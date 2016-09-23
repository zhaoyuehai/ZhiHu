package com.zhihu.mvp_simple.contract;

/**
 * Created by 月海 on 2016/9/14.
 * <p>
 * Fragment 接口基类
 */

public interface IBaseFragment {
    void setPresenter(UserInfoContract.IFragmentPresenter mIFragmentPresenter);
}
