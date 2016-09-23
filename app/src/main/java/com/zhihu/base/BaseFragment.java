package com.zhihu.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhihu.AppContext;
import com.zhihu.R;
import com.zhihu.interf.BaseFragmentInterface;
import com.zhihu.ui.dialog.DialogControl;

/**
 * Created by 月海 on 2016/7/1.
 */
public class BaseFragment extends Fragment implements BaseFragmentInterface {

    protected LayoutInflater mLayoutInflater;

    public AppContext getApplication() {
        return (AppContext) getActivity().getApplication();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.mLayoutInflater = inflater;
        View view = super.onCreateView(inflater, container, savedInstanceState);
        initView(view);
        return view;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    protected ProgressDialog showWaitDialog() {
        return showWaitDialog(R.string.loading);
    }

    protected ProgressDialog showWaitDialog(int resId) {
        FragmentActivity activity = getActivity();
        if (activity instanceof DialogControl) {
            return ((DialogControl) activity).showWaitDialog(resId);
        }
        return null;
    }

    protected ProgressDialog showWaitDialog(String str) {
        FragmentActivity activity = getActivity();
        if (activity instanceof DialogControl) {
            return ((DialogControl) activity).showWaitDialog(str);
        }
        return null;
    }

    @Override
    public void initData() {

    }
}
