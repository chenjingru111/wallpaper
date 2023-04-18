package com.example.smartwallpapers.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.smartwallpapers.R;

public class FirstActivity extends AppCompatActivity {

    private RelativeLayout rl_left;
    private RelativeLayout rl_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initView();

        rl_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this,ChooseAreaActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        rl_left = (RelativeLayout) findViewById(R.id.rl_left);
        rl_right = (RelativeLayout) findViewById(R.id.rl_right);

    }
}