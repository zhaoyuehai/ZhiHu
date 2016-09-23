package com.zhihu.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewPager;

import com.zhihu.ui.fragment.NewsFragment;

import java.util.Map;

/**
 * Created by 月海 on 2016/7/4.
 */
public class ViewPagerFragmentAdapter extends FragmentStatePagerAdapter {
    private Context mContext;
    protected ViewPager mViewPager;
    private Map<String, Fragment> mFragments = new ArrayMap<>();
    private String[] mTitles;

    public ViewPagerFragmentAdapter(FragmentManager fm, String[] titles, ViewPager viewPager) {
        super(fm);
        mViewPager = viewPager;
        mTitles = titles;
        mContext = viewPager.getContext();
    }

    @Override
    public Fragment getItem(int position) {
        ViewPagetInfo info = null;
//        switch (position) {
//            case 0:
//                info = new ViewPagetInfo("0", NewsFragment.class, mTitles[position], new Bundle());
//                break;
//            case 1:
//                info = new ViewPagetInfo("1", NewsFragment.class, mTitles[position], new Bundle());
//                break;
//            case 2:
//                info = new ViewPagetInfo("2", NewsFragment.class, mTitles[position], new Bundle());
//                break;
//            case 3:
//                info = new ViewPagetInfo("3", NewsFragment.class, mTitles[position], new Bundle());
//                break;
//            default:
//                info = new ViewPagetInfo("0", NewsFragment.class, mTitles[position], new Bundle());
//                break;
//        }
//        ViewPagetInfo info = (ViewPagetInfo) mTableLayout.getChildAt(position).getTag();
        Fragment fragment = mFragments.get(position + "");
        if (fragment == null) {
            Bundle bundle = new Bundle();
            bundle.putString("zz","zz");
            fragment = Fragment.instantiate(mContext, NewsFragment.class.getName(), bundle);
            mFragments.put(position + "", fragment);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

}
