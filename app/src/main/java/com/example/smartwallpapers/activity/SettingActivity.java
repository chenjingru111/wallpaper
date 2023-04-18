package com.example.smartwallpapers.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.smartwallpapers.R;
import com.example.smartwallpapers.tools.CacheUtils;

public class SettingActivity extends AppCompatActivity {

    private RelativeLayout rl_clear;
    private ImageView iv_back_setting;
    private CacheUtils cacheUtils;
    private ProgressBar progressBar;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        initView();
        initData();
        progressBar.setVisibility(View.GONE);

        iv_back_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rl_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                ObjectAnimator animator = ObjectAnimator.ofFloat(progressBar, "rotation", 0f, 360f);
                animator.setDuration(1000);
                animator.setInterpolator(new LinearInterpolator());
                animator.setRepeatCount(ValueAnimator.INFINITE);
                animator.start();
                // 延时1秒钟关闭进度条
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);
                        cacheUtils.clearCache(SettingActivity.this);
                    }
                }, 1000);
            }
        });
    }

    private void initData() {
        cacheUtils = new CacheUtils();
    }

    private void initView() {
        rl_clear = (RelativeLayout) findViewById(R.id.rl_clear);
        iv_back_setting = (ImageView) findViewById(R.id.iv_back_setting);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }
}