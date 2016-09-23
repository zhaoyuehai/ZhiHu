package com.zhihu.adapter.general;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.zhihu.R;
import com.zhihu.adapter.ViewHolder;
import com.zhihu.adapter.base.BaseListAdapter;
import com.zhihu.bean.News;

/**
 * Created by 月海 on 2016/7/4.
 */
public class NewsAdapter extends BaseListAdapter<News>{
    private Context mContext;
    public NewsAdapter(Context context) {
        mContext = context;
    }

    @Override
    protected void convert(ViewHolder viewHolder, News item, int position) {
        viewHolder.setText(R.id.tv_title,item.getTitle());
        viewHolder.setText(R.id.tv_description,item.getBody());
        viewHolder.setText(R.id.tv_time,item.getPubData());
    }

    @Override
    protected int getLayoutId(int position, News item) {
        return R.layout.item_list_news;
    }

    @Override
    protected Context getContext() {
        return mContext;
    }
}
