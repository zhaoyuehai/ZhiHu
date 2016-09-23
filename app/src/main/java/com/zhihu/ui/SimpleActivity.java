package com.zhihu.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;
import com.zhihu.R;
import com.zhihu.base.BaseActivity;
import com.zhihu.bean.SimplePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by 月海 on 2016/7/6.
 */
public class SimpleActivity extends BaseActivity {

    @Bind(R.id.simple_page_toolbar)
    Toolbar simplePageToolbar;
    @Bind(R.id.simple_page_container)
    FrameLayout simplePageContainer;
    @Bind(R.id.test_btn)
    Button testBtn;
    @Bind(R.id.test_iv)
    ImageView testIv;
    @Bind(R.id.my_image_view)
    SimpleDraweeView myImageView;
    private int mPageValue = -1;
    private String title = "";
    private List<SampleModel> data;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_simple_fragment;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        Intent intent = getIntent();
        if (mPageValue == -1) {
            mPageValue = intent.getIntExtra("SIMPLEPAGE_VALUE", 0);
        }
        SimplePage simplePage = SimplePage.getSelfByVaule(mPageValue);
        if (simplePage != null) {
            title = getString(simplePage.getTitleResId());
        }
    }

    @Override
    public void initView() {
        simplePageToolbar.setTitle(title);
        setSupportActionBar(simplePageToolbar);

    }

    @Override
    public void initData() {
        Glide.with(SimpleActivity.this).load("http://f.hiphotos.baidu.com/image/pic/item/b151f8198618367ac7d2a1e92b738bd4b31ce5af.jpg").into(testIv);
        Uri uri = Uri.parse("http://f.hiphotos.baidu.com/image/pic/item/b151f8198618367ac7d2a1e92b738bd4b31ce5af.jpg");
        myImageView.setImageURI(uri);
        makeSampleModelData();
        Picasso.with(this).load("http://a.hiphotos.baidu.com/image/pic/item/03087bf40ad162d9f285772914dfa9ec8a13cd9f.jpg").into(testIv);
        Log.e("a", "Main Thread id =" + Thread.currentThread().getId());

    }

    @OnClick({R.id.simple_page_toolbar, R.id.simple_page_container})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.simple_page_toolbar:
                break;
            case R.id.simple_page_container:
                break;
        }
    }

    @OnClick(R.id.test_btn)
    public void onClick() {
        setImgFromData(data);
    }

    private void setImgFromData(List<SampleModel> data) {
        Observable.just(data).subscribeOn(Schedulers.newThread())
                .map(new Func1<List<SampleModel>, SampleModel>() {
                    @Override
                    public SampleModel call(List<SampleModel> list) {
                        Log.e("a", "第一个call线程的id=" + Thread.currentThread().getId());
                        Random random = new Random();
                        int i = random.nextInt(4);
                        return list.get(i);
                    }
                }).map(new Func1<SampleModel, String>() {
            @Override
            public String call(SampleModel sampleModel) {
                Log.e("a", "第二个call线程的id=" + Thread.currentThread().getId());
                return sampleModel.url;
            }

        }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.e("a", "第3个call线程的id=" + Thread.currentThread().getId());
                        Log.e("b", "url=" + s);
                        Glide.with(SimpleActivity.this).load(s).into(testIv);
//                        Uri uri = Uri.parse(s);
//                        myImageView.setImageURI(uri);
                    }
                });
    }

    private void makeSampleModelData() {
        data = new ArrayList<>();
        data.add(new SampleModel("Tiffany one", "http://hiphotos.baidu.com/zhixin/abpic/item/4651a712c8fcc3cea97dbce49045d688d53f206c.jpg"));
        data.add(new SampleModel("Tiffany two", "http://imgsrc.baidu.com/forum/w%3D580/sign=45abdcd6530fd9f9a0175561152cd42b/cb2bcdef76094b3602fce847a1cc7cd98c109db1.jpg"));
        data.add(new SampleModel("", "http://img5q.duitang.com/uploads/item/201410/22/20141022214043_5EEKH.thumb.224_0.jpeg"));
        data.add(new SampleModel("Tiffany four", "http://img5.duitang.com/uploads/item/201512/08/20151208163159_HGEM2.thumb.224_0.png"));
        data.add(new SampleModel("Tiffany five", "http://img4.duitang.com/uploads/item/201510/29/20151029224537_ijEKF.thumb.224_0.jpeg"));
    }

    class SampleModel {
        public String name;
        public String url;

        public SampleModel(String name, String url) {
            this.name = name;
            this.url = url;
        }
    }
}
