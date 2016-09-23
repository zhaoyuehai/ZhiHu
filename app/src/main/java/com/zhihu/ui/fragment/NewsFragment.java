package com.zhihu.ui.fragment;

import android.view.View;
import android.widget.AdapterView;

import com.zhihu.adapter.base.BaseListAdapter;
import com.zhihu.adapter.general.NewsAdapter;
import com.zhihu.bean.News;
import com.zhihu.ui.fragment.base.BaseListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 月海 on 2016/7/4.
 */
public class NewsFragment extends BaseListFragment{

    private NewsAdapter newsAdapter;

    @Override
    protected BaseListAdapter getListAdapter() {
        newsAdapter = new NewsAdapter(getContext());
        return newsAdapter;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void initData() {
        super.initData();
        List<News> list = new ArrayList<>();
        list.add(new News());
        list.add(new News());
        list.add(new News());
        list.add(new News());
        list.add(new News());
        list.add(new News());
        list.add(new News());
        list.add(new News());
        newsAdapter.setmDatas(list);
    }

    @Override
    public void onRefresh() {

    }
}
