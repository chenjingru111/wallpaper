package com.example.smartwallpapers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.smartwallpapers.db.DatabaseHelper;
import com.example.smartwallpapers.fragment.CharacterFragment;
import com.example.smartwallpapers.fragment.CosplayFragment;
import com.example.smartwallpapers.fragment.DarkwallpaperFragment;
import com.example.smartwallpapers.fragment.SceneryFragment;
import com.example.smartwallpapers.fragment.WallpaperFragment;
import android.Manifest;

public class ChooseAreaActivity extends AppCompatActivity {

    private TextView tv_scenery;
    private TextView tv_cosplay;
    private TextView tv_wallpapers;
    private TextView tv_darkwallpapers;
    private TextView tv_characters;
    private TextView tv_scenery_bottom;
    private TextView tv_cosplay_bottom;
    private TextView tv_wallpapers_bottom;
    private TextView tv_darkwallpapers_bottom;
    private TextView tv_characters_bottom;
    private FrameLayout fragment_container;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    private static final int REQUEST_CODE_PERMISSIONS = 123;
    private ImageView iv_menu;
    private int hight;
    private int wide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_area);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!hasPermissions()) {
                requestPermissions();
            }
        }


        initView();
        initData();

        tv_scenery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });
        tv_cosplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });
        tv_wallpapers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });
        tv_darkwallpapers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });
        tv_characters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });



        iv_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(ChooseAreaActivity.this).inflate(R.layout.popwindow_menu_item,null);
                final PopupWindow popWindow = new PopupWindow(view, wide,hight);//这里的长宽是取得的屏幕长宽代码见末端
                popWindow.setAnimationStyle(R.style.AnimTopRight);
                //部分机型点击空白区域无法使popowindow消失，加上这三句话
                popWindow.setBackgroundDrawable(new BitmapDrawable());
                popWindow.setFocusable(true);
                popWindow.setOutsideTouchable(true);
                popWindow.update();

                popWindow.showAtLocation(view, Gravity.LEFT | Gravity.BOTTOM, 0,0);


            }
        });
    }

    private void initData() {
        hight = phoneHight();
        wide = phoneWide_1_3();
    }


    private void onButtonClick(View view) {
        switch (view.getId()){
            case R.id.tv_scenery:
                  setVisibility(View.VISIBLE,View.GONE,View.GONE,View.GONE,View.GONE);
                getScenery(fragment_container,new SceneryFragment(),SceneryFragment.class.getName());

                break;
            case R.id.tv_cosplay:
                setVisibility(View.GONE,View.VISIBLE,View.GONE,View.GONE,View.GONE);
                getScenery(fragment_container,new CosplayFragment(),CosplayFragment.class.getName());

                break;
            case R.id.tv_wallpapers:
                setVisibility(View.GONE,View.GONE,View.VISIBLE,View.GONE,View.GONE);
                getScenery(fragment_container,new WallpaperFragment(),WallpaperFragment.class.getName());

                break;
            case R.id.tv_darkwallpapers:
                setVisibility(View.GONE,View.GONE,View.GONE,View.VISIBLE,View.GONE);
                getScenery(fragment_container,new DarkwallpaperFragment(),DarkwallpaperFragment.class.getName());

                break;
            case R.id.tv_characters:
                setVisibility(View.GONE,View.GONE,View.GONE,View.GONE,View.VISIBLE);
                getScenery(fragment_container,new CharacterFragment(),CosplayFragment.class.getName());

                break;

        }
    }

    private void initView() {
        tv_scenery = (TextView) findViewById(R.id.tv_scenery);
        tv_cosplay = (TextView) findViewById(R.id.tv_cosplay);
        tv_wallpapers = (TextView) findViewById(R.id.tv_wallpapers);
        tv_darkwallpapers = (TextView) findViewById(R.id.tv_darkwallpapers);
        tv_characters = (TextView) findViewById(R.id.tv_characters);
        tv_scenery_bottom = (TextView) findViewById(R.id.tv_scenery_bottom);
        tv_cosplay_bottom = (TextView) findViewById(R.id.tv_cosplay_bottom);
        tv_wallpapers_bottom = (TextView) findViewById(R.id.tv_wallpapers_bottom);
        tv_darkwallpapers_bottom = (TextView) findViewById(R.id.tv_darkwallpapers_bottom);
        tv_characters_bottom = (TextView) findViewById(R.id.tv_characters_bottom);
        iv_menu = (ImageView) findViewById(R.id.iv_menu);

        fragment_container = (FrameLayout) findViewById(R.id.fragment_container);
    }



    private void getScenery(FrameLayout fragmentContainer, Fragment fragment,String tag){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment currentFragment = fragmentManager.findFragmentByTag(tag);
        if (currentFragment == null) {
            fragmentTransaction.add(fragmentContainer.getId(), fragment, tag);
        }

        for (Fragment frag : fragmentManager.getFragments()) {
            if (frag.getTag().equals(tag)) {
                fragmentTransaction.show(frag);
            } else {
                fragmentTransaction.hide(frag);
            }
        }

        fragmentTransaction.commit();
        fragmentContainer.setVisibility(View.VISIBLE);

    }

    public void setVisibility(int i1,int i2,int i3,int i4,int i5) {
        tv_scenery_bottom.setVisibility(i1);
        tv_cosplay_bottom.setVisibility(i2);
        tv_wallpapers_bottom.setVisibility(i3);
        tv_darkwallpapers_bottom.setVisibility(i4);
        tv_characters_bottom.setVisibility(i5);
    }

    private boolean hasPermissions() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},
                REQUEST_CODE_PERMISSIONS);
    }


    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                // Permissions granted
            } else {
                // Permissions denied
            }
        }
    }


    private int phoneHight(){
        Display display = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int height = display.getHeight();
        return height;
    }

    private int phoneWide_1_3(){
        Display display = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int wide = display.getWidth();
        int wide_1_3 = wide / 3;
        return wide_1_3;

    }







}