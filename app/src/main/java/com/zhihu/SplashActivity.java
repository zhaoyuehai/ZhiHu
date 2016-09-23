package com.zhihu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

import com.zhihu.base.BaseActivity;
import com.zhihu.ui.MainActivity;

/**
 * Created by 月海 on 2016/7/1.
 */
public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (AppContext.getNightModeSwitch()) {
            setTheme(R.style.splash_theme_night);
        } else {
            setTheme(R.style.splash_theme_light);
        }
        View view = View.inflate(this, R.layout.app_start, null);
        setContentView(view);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
        alphaAnimation.setDuration(800);
        alphaAnimation.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                goNext();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(alphaAnimation);
    }

    private void goNext() {
        //检查是不是覆盖安装并决定是否清理缓存
        //开启服务 上传Log 日志后删除日志log。
        //跳转主页
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
