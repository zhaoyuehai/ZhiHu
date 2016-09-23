package com.zhihu.base;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

/**
 * Created by 月海 on 2016/6/27.
 */
public class BaseApplication extends Application {
    public static String PREF_NAME = "zhihu.pref";
    static Context mContext;
    static Resources mResource;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        mResource = mContext.getResources();
    }

    public static synchronized BaseApplication getContext() {
        return (BaseApplication) mContext;
    }

    public static Resources getResource() {
        return mResource;
    }

    public static String getStringBy(int id) {
        return mResource.getString(id);
    }

    public static SharedPreferences getPreferences() {
        return getContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static void set(String key, boolean value) {
        SharedPreferences.Editor edit = getPreferences().edit();
        edit.putBoolean(key, value);
        edit.apply();
    }
}
