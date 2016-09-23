package com.zhihu.mvp_simple.contract;

/**
 * 生命周期接口基类
 */

public interface IBaseLifeCycle {
    void onCreate();

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();
}
