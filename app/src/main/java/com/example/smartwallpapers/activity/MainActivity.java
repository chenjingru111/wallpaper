package com.example.smartwallpapers.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

import com.example.smartwallpapers.BuildConfig;
import com.example.smartwallpapers.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadApp();

    }

    private void loadApp() {
        long startTime = SystemClock.elapsedRealtime();
        long elapsedTime = SystemClock.elapsedRealtime() - startTime;

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            //这里打开app的首页
            Intent intent = new Intent(getApplicationContext(), FirstActivity.class);
            startActivity(intent);


            if (BuildConfig.DEBUG) {
                //todo,注意
                //debug 模式下， fairbid可能会弹出test suit对话框。
                // app首次启动时，fairbid在mainActivity:onCreate时初始化，关掉splash没有问题。
                // 在非首次启动时，fairbid在splash::onCreate时初始化，然后弹出一个依附于splash的对话框，如果此处把splash关掉，app会crash
                //会导致安卓6上hideIcon时应用被杀
            } else {
                //release模式下，不会弹test suit对话框，可安全关掉splash页面
                finish();
            }
        }, Math.max(0, 3000 - elapsedTime)); //不足3秒则等待3秒
    }
}