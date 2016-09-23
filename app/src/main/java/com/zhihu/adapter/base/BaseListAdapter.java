package com.zhihu.adapter.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.zhihu.adapter.ViewHolder;

import java.util.List;

/**
 * Created by 月海 on 2016/7/4.
 */
public abstract class BaseListAdapter<T> extends BaseAdapter {
    //    protected Callback mCallback;
//
//
//    public interface Callback{
//
//    }
    protected List<T> mDatas;

    @Override
    public int getCount() {

        return mDatas != null ? mDatas.size() : 0;
    }

    @Override
    public T getItem(int position) {
        if (position >= 0 && position <= mDatas.size()) {
            return mDatas.get(position);
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        T item = getItem(position);
        int layoutId = getLayoutId(position, item);
        final ViewHolder viewHolder = ViewHolder.getViewHolder(getContext(), convertView, layoutId, position);
        convert(viewHolder, item, position);
        return viewHolder.getmConvertView();
    }

    protected abstract void convert(ViewHolder viewHolder, T item, int position);

    protected abstract int getLayoutId(int position, T item);

    protected abstract Context getContext();

    public void setmDatas(List<T> mDatas) {
        this.mDatas = mDatas;
    }
}
