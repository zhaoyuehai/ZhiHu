package com.zhihu.mvp_simple.contract;

import com.zhihu.mvp_simple.presenter.IbasePresenter;

/**
 * Created by 月海 on 2016/9/14.
 * <p>
 * 契约类
 */

public class UserInfoContract {
    /**
     * View 中更新UI的方法
     */
    public interface IView extends IBaseView {

        void showLoading();//显示加载框

        void dismissLoading();//取消加载框

        void showUserInfo();//将网络请求得到的数据回调

    }

    /**
     * Fragment 中用于更新UI的方法
     */
    public interface IFragment extends IBaseFragment {
        void showData();
    }

    /**
     * Activity逻辑层需要使用的方法
     */
    public interface IActivityPresenter extends IbasePresenter {
        void loadUserInfo();
    }

    /**
     * Fragment逻辑层需要使用的方法
     */
    public interface IFragmentPresenter extends IbasePresenter {
        void loadData();
    }

    /**
     * Activity UI层生命周期
     */
    public interface ILifeCycle extends IBaseLifeCycle {
        void onRestart();
    }
}
