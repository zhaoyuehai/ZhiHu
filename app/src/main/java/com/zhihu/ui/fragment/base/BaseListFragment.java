package com.zhihu.ui.fragment.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.zhihu.R;
import com.zhihu.adapter.base.BaseListAdapter;

import butterknife.ButterKnife;

/**
 * Created by 月海 on 2016/7/4.
 */
public abstract class BaseListFragment<T> extends Fragment implements SwipeRefreshLayout.OnRefreshListener, AdapterView.OnItemClickListener {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ListView mListView;
    private View mFooterView;

    private View mRoot;
    private TextView mFooterTV;
    private BaseListAdapter<T> mListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRoot != null) {
            ViewGroup parent = (ViewGroup) mRoot.getParent();
            if (parent != null)
                parent.removeView(mRoot);
        } else {
            mRoot = inflater.inflate(R.layout.fragment_base_list, container, false);
            ButterKnife.bind(this, mRoot);
            initView(mRoot);
            initData();
        }
        return mRoot;
    }

    public void initView(View view) {
        mListView = (ListView) view.findViewById(R.id.base_list_fragment_LV);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.base_list_fragment_SRL);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent_Light);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mFooterView = LayoutInflater.from(getContext()).inflate(R.layout.listview_footer_loading, null);
        mFooterTV = (TextView) mFooterView.findViewById(R.id.footer_TV);
        mListView.setOnItemClickListener(this);
        if (isNeedFooter()) {
            mListView.addFooterView(mFooterView);
        }
    }

    public void initData() {
        mListAdapter = getListAdapter();
        mListView.setAdapter(mListAdapter);
    }

    protected abstract BaseListAdapter<T> getListAdapter();

    protected boolean isNeedFooter() {
        return true;
    }
}
