package com.zhihu.adapter;

import android.os.Bundle;

/**
 * Created by 月海 on 2016/7/4.
 */
public class ViewPagetInfo {
    public final String tag;
    public final Class<?> clazz;
    public final String title;
    public final Bundle args;

    public ViewPagetInfo(String tag, Class<?> clazz, String title, Bundle args) {
        this.tag = tag;
        this.clazz = clazz;
        this.title = title;
        this.args = args;
    }
}
