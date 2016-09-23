package com.zhihu;

import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zhihu.base.BaseApplication;

/**
 * Created by 月海 on 2016/6/27.
 */
public class AppContext extends BaseApplication {
    private static AppContext instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        init();
    }

    private void init() {
        Fresco.initialize(instance);
    }

    public static boolean getNightModeSwitch() {
        return getPreferences().getBoolean(AppConfig.KEY_NIGHT_MODE_SWITCH, false);
    }

    public static void setNightModeSwitch(boolean modeSwitch) {
        set(AppConfig.KEY_NIGHT_MODE_SWITCH, modeSwitch);
    }
}
