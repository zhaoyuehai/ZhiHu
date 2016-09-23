package com.zhihu.base;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhihu.R;
import com.zhihu.adapter.ViewPagerFragmentAdapter;

/**
 * Created by 月海 on 2016/7/1.
 */
public abstract class BaseViewPagerFragment extends BaseFragment {
    protected View mRoot;
    protected ViewPager mViewpager;
    protected ViewPagerFragmentAdapter mFragmentAdapter;

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        if (mRoot == null) {
//            mRoot = inflater.inflate(R.layout.base_viewpage_fragment, null);
//            mViewpager = (ViewPager) mRoot.findViewById(R.id.viewpager);
//            mFragmentAdapter = new ViewPagerFragmentAdapter(getChildFragmentManager(), mViewpager);
//            setupTabAdapter(mFragmentAdapter);
//        }
//        return mRoot;
//    }
    protected abstract void setupTabAdapter(ViewPagerFragmentAdapter adapter);
}
