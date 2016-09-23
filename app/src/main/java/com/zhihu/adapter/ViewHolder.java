package com.zhihu.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

/**
 * Created by 月海 on 2016/7/4.
 */
public class ViewHolder {
    private SparseArray<View> mViews;

    private View mConvertView;

    private int mLayoutId;

    private int mPosition;

    public ViewHolder(Context context, int mLayoutId, int mPosition) {
        mViews = new SparseArray<>();
        this.mLayoutId = mLayoutId;
        this.mPosition = mPosition;
        mConvertView = View.inflate(context, mLayoutId, null);
        mConvertView.setTag(this);
    }

    public static ViewHolder getViewHolder(Context context, View converView, int layoutId, int position) {
        boolean isNeedCreate = false;
        ViewHolder vh = null;
        if (converView == null) {
            isNeedCreate = true;
        } else {
            vh = (ViewHolder) converView.getTag();
        }
        if (vh != null && (vh.mLayoutId != layoutId)) {
            isNeedCreate = true;
        }
        if (isNeedCreate) {
            return new ViewHolder(context, layoutId, position);
        }
        return (ViewHolder) converView.getTag();
    }

    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public void setText(int viewId, String text) {
        if (TextUtils.isEmpty(text)) return;
        TextView v = getView(viewId);
        if (v != null)
            v.setText(text);
    }

    public View getmConvertView() {
        return mConvertView;
    }

    public int getmLayoutId() {
        return mLayoutId;
    }

    public int getmPosition() {
        return mPosition;
    }
}
