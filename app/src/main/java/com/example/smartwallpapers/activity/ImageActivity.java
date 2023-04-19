package com.example.smartwallpapers.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.smartwallpapers.R;
import com.example.smartwallpapers.db.DatabaseHelper;
import com.example.smartwallpapers.tools.ImageDownloader;
import com.example.smartwallpapers.tools.WallpaperUtils;

public class ImageActivity extends Activity {

    private ImageView iv_show;
    private String url;
    private TextView tv_name;
    private ImageView iv_copy;
    private ImageView iv_download;
    private ImageDownloader imageDownloader;
    private ImageView iv_set_phone_bg;
    private WallpaperUtils wallpaperUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        initView();
        initData();
        Glide.with(this).load(url).into(iv_show);

        queryNameByUrl();

        iv_copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                copyUrl(url);
                Toast.makeText(ImageActivity.this, "The content has been copied to the clipboard.", Toast.LENGTH_SHORT).show();
            }
        });

        iv_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageDownloader.downloadImageToGallery(ImageActivity.this,url);
            }
        });


        //ImageView.ScaleType center = ImageView.ScaleType.CENTER;
        iv_set_phone_bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wallpaperUtils.setWallpaperFromURL(url);
            }
        });

    }

    private void initData() {
        url = getIntent().getStringExtra("url");
        imageDownloader = new ImageDownloader();
        wallpaperUtils = new WallpaperUtils(this);
    }

    private void initView() {
        iv_show = (ImageView) findViewById(R.id.iv_show);
        tv_name = (TextView) findViewById(R.id.tv_name);
        iv_copy = (ImageView) findViewById(R.id.iv_copy);
        iv_download = (ImageView) findViewById(R.id.iv_download);
        iv_set_phone_bg = (ImageView) findViewById(R.id.iv_set_phone_bg);
    }

    @SuppressLint("Range")
    public void queryNameByUrl() {
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String[] columns = {"name"};
        String selection = "url=?";
        String[] selectionArgs = {url};
        Cursor cursor = db.query("picture", columns, selection, selectionArgs, null, null, null);
        String name = null;
        if (cursor.moveToFirst()) {
            name = cursor.getString(cursor.getColumnIndex("name"));
        }
        cursor.close();

        tv_name.setText(name);
    }

    public void copyUrl(String url){
        // 获取系统剪切板
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
// 创建一个剪贴数据集，包含一个简单的文本数据条目
        ClipData clip = ClipData.newPlainText("label", url);
// 将剪贴数据集放入剪贴板
        clipboard.setPrimaryClip(clip);
    }

}