package com.example.smartwallpapers.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.smartwallpapers.R;

public class ExitActivity extends AppCompatActivity {

    private TextView tv_exit;
    private TextView tv_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);

        initView();

        tv_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
                System.exit(0);

            }
        });

        tv_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ExitActivity.this,FirstActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        tv_exit = (TextView) findViewById(R.id.tv_exit);
        tv_no = (TextView) findViewById(R.id.tv_no);
    }
}