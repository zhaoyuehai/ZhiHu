package com.zhihu.ui.viewpagerfragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhihu.R;
import com.zhihu.adapter.ViewPagerFragmentAdapter;
import com.zhihu.base.BaseFragment;
import com.zhihu.interf.OnTabReselectListener;

/**
 * Created by 月海 on 2016/7/1.
 */
public class GeneralViewPagerFragment extends BaseFragment implements OnTabReselectListener {
    protected View mRoot;
   protected ViewPager mViewpager;
    protected TabLayout mTabLayout;
    protected ViewPagerFragmentAdapter mFragmentAdapter;
    private final static int PAGE_SIZE = 4;
    private String[] mTitles;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRoot == null) {
            mRoot = inflater.inflate(R.layout.base_viewpage_fragment, null);
            mViewpager = (ViewPager) mRoot.findViewById(R.id.viewpager);
            mTabLayout = (TabLayout) mRoot.findViewById(R.id.tablyout);
            mTitles = getResources().getStringArray(R.array.news_titles);
            addTab();
            mFragmentAdapter = new ViewPagerFragmentAdapter(getChildFragmentManager(), mTitles, mViewpager);
            mViewpager.setAdapter(mFragmentAdapter);
            mTabLayout.setupWithViewPager(mViewpager);
            mTabLayout.setTabsFromPagerAdapter(mFragmentAdapter);
        }
        return mRoot;
    }

    private void addTab() {
        for (int i = 0; i < mTitles.length; i++) {
            TabLayout.Tab tab = mTabLayout.newTab();
            tab.setText(mTitles[i]);
            mTabLayout.addTab(tab);
        }
    }

    @Override
    public void onTabReselect() {

    }
}
