package com.zhihu.util;

import android.content.Context;
import android.content.Intent;

import com.zhihu.bean.SimplePage;
import com.zhihu.ui.SimpleActivity;

/**
 * Created by 月海 on 2016/7/6.
 */
public class UIHelper {
    public static void goSimpleActivity(Context context,SimplePage simplePage){
        Intent intent = new Intent(context, SimpleActivity.class);
        intent.putExtra("SIMPLEPAGE_VALUE",simplePage.getValue());
        context.startActivity(intent);
    }
}
