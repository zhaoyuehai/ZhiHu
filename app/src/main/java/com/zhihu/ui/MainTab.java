package com.zhihu.ui;

import com.zhihu.R;
import com.zhihu.ui.fragment.MyInformationFragment;
import com.zhihu.ui.viewpagerfragment.GeneralViewPagerFragment;

/**
 * Created by 月海 on 2016/7/1.
 */
public enum MainTab {


    NEWS(0, R.string.news, R.drawable.table_icon_new_selector, GeneralViewPagerFragment.class),
    TWEET(1, R.string.tweet, R.drawable.table_icon_tweet_selector, GeneralViewPagerFragment.class),
    QUICK(2, R.string.quick, R.drawable.table_icon_new_selector, GeneralViewPagerFragment.class),
    EXPLORE(3, R.string.explore, R.drawable.table_icon_explore_selector, GeneralViewPagerFragment.class),
    ME(4, R.string.me, R.drawable.table_icon_me_selector, MyInformationFragment.class);

    public int getIdx() {
        return idx;
    }

    public int getNameIdRes() {
        return nameIdRes;
    }

    public int getIcomIdRes() {
        return icomIdRes;
    }

    private int idx;
    private int nameIdRes;
    private int icomIdRes;
    private Class<?> clzz;

    MainTab(int idx, int nameIdRes, int icomIdRes, Class<?> clz) {
        this.idx = idx;
        this.nameIdRes = nameIdRes;
        this.icomIdRes = icomIdRes;
        this.clzz = clz;
    }

    public Class<?> getClzz() {
        return clzz;
    }
}
