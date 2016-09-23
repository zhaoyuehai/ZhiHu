package com.zhihu.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import com.bumptech.glide.Glide;
import com.zhihu.AppContext;
import com.zhihu.R;
import com.zhihu.base.BaseFragment;
import com.zhihu.interf.OnTabReselectListener;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 月海 on 2016/7/4.
 */
public class MyInformationFragment extends BaseFragment implements OnTabReselectListener {
    @Bind(R.id.light_swch)
    Switch mainSwitch;
    @Bind(R.id.iv_center)
    ImageView ivCenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_information, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    @Override
    public void onTabReselect() {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    @Override
    public void initView(View view) {
        super.initView(view);
    }

    @Override
    public void initData() {
        super.initData();
        boolean nightModeSwitch = AppContext.getNightModeSwitch();
        mainSwitch.setChecked(nightModeSwitch);
        mainSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                AppContext.setNightModeSwitch(isChecked);
                MyInformationFragment.this.getActivity().recreate();
            }
        });
        Glide.with(getContext()).load("http://f.hiphotos.baidu.com/image/pic/item/b151f8198618367ac7d2a1e92b738bd4b31ce5af.jpg").into(ivCenter);
//        Uri uri = Uri.parse("http://f.hiphotos.baidu.com/image/pic/item/b151f8198618367ac7d2a1e92b738bd4b31ce5af.jpg");
//        myImageView.setImageURI(uri);
//        makeSampleModelData();
//        Picasso.with(getContext()).load("http://img4.duitang.com/uploads/item/201510/29/20151029224537_ijEKF.thumb.224_0.jpeg").into(ivCenter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
