package com.zhihu.bean;

import com.zhihu.R;

/**
 * Created by 月海 on 2016/7/6.
 */
public enum SimplePage {
    SEARCH(1, R.string.search);

    public int getValue() {
        return value;
    }

    public int getTitleResId() {
        return titleResId;
    }

    private int titleResId;
    private int value;

    SimplePage(int value, int titleResId) {
        this.value = value;
        this.titleResId = titleResId;
//        this.clzz = clz;
    }

    public static SimplePage getSelfByVaule(int value) {
        for (SimplePage s : values()) {
            if (s.getValue() == value)
                return s;
        }
        return null;
    }
}
