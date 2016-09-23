package com.zhihu.ui;

import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.zhihu.R;
import com.zhihu.base.BaseActivity;
import com.zhihu.bean.SimplePage;
import com.zhihu.interf.BaseViewInterface;
import com.zhihu.interf.OnTabReselectListener;
import com.zhihu.util.UIHelper;
import com.zhihu.widget.BadgeView;
import com.zhihu.widget.MyFragmentTabHost;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements BaseViewInterface, TabHost.OnTabChangeListener, View.OnTouchListener {

    @Bind(R.id.main_toolbar)
    Toolbar mainToolbar;
    @Bind(R.id.main_tabhost)
    MyFragmentTabHost mainTabhost;
    @Bind(R.id.main_center_iv)
    ImageView mainCenterIv;

    private BadgeView mBVNotice;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mainToolbar.setTitle(R.string.app_name);
        setSupportActionBar(mainToolbar);
        mainTabhost.setup(this, getSupportFragmentManager(), R.id.main_fragment);
        initTables();
        mainTabhost.setCurrentTab(0);
        mainTabhost.setOnTabChangedListener(this);
    }

    @Override
    public void initData() {

    }

    private void initTables() {
        MainTab[] mainTab = MainTab.values();
        for (int i = 0; i < mainTab.length; i++) {
            MainTab tab = mainTab[i];
            TabHost.TabSpec tabSp = mainTabhost.newTabSpec(getString(tab.getNameIdRes()));
            View view = View.inflate(this, R.layout.tab_indicator, null);
            ImageView tab_icon = (ImageView) view.findViewById(R.id.tab_icon);
            TextView tab_title = (TextView) view.findViewById(R.id.tab_title);
            tab_icon.setBackgroundResource(tab.getIcomIdRes());
//            tab_icon.setImageDrawable(getResources().getDrawable(tab.getIcomIdRes()));
            tab_title.setText(getString(tab.getNameIdRes()));
            if (i == 2) {
                view.setVisibility(View.INVISIBLE);
                mainTabhost.setNoTabChangedTag(getString(tab.getNameIdRes()));
            }
            tabSp.setIndicator(view);
            tabSp.setContent(new TabHost.TabContentFactory() {
                @Override
                public View createTabContent(String tag) {
                    return new View(MainActivity.this);
                }
            });
            mainTabhost.addTab(tabSp, tab.getClzz(), null);
            if (tab.equals(MainTab.ME)) {
                View tab_message = view.findViewById(R.id.tab_message);
                mBVNotice = new BadgeView(MainActivity.this, tab_message);
                mBVNotice.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);
                mBVNotice.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);
                mBVNotice.setGravity(Gravity.CENTER);
            }
            mainTabhost.getTabWidget().getChildAt(i).setOnTouchListener(this);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_menu_search:
                UIHelper.goSimpleActivity(this, SimplePage.SEARCH);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        super.onTouchEvent(event);
        boolean consumed = false;
        if (event.getAction() == MotionEvent.ACTION_DOWN && v.equals(mainTabhost.getCurrentTabView())) {
            Fragment currentFragment = getCurrentFragment();
            if (currentFragment != null && currentFragment instanceof OnTabReselectListener) {
                OnTabReselectListener listener = (OnTabReselectListener) currentFragment;
                listener.onTabReselect();
                consumed = true;
            }
        }
        return consumed;
    }

    private Fragment getCurrentFragment() {
        return getSupportFragmentManager().findFragmentByTag(mainTabhost.getCurrentTabTag());
    }

    @Override
    public void onTabChanged(String tabId) {
        int tabCount = mainTabhost.getTabWidget().getTabCount();
        for (int i = 0; i < tabCount; i++) {
            View v = mainTabhost.getTabWidget().getChildAt(i);
            if (i == mainTabhost.getCurrentTab()) {
                v.setSelected(true);
            } else {
                v.setSelected(false);
            }
        }
        if (tabId.equals(getString(MainTab.ME.getNameIdRes()))) {
            mBVNotice.setText("");
            mBVNotice.hide();
        }
        supportInvalidateOptionsMenu();
    }

    @OnClick(R.id.main_center_iv)
    public void onClick() {

    }
}
