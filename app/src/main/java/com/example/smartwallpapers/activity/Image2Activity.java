package com.example.smartwallpapers.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smartwallpapers.R;
import com.example.smartwallpapers.adapter.CosplayAdapter;
import com.example.smartwallpapers.db.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class Image2Activity extends AppCompatActivity {

    private ImageView iv_back2;
    private TextView tv_them;
    private RecyclerView recycler_changeitem;
    private String them;
    private List<String> imageUrlList;
    private CosplayAdapter cosplayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image2);

        initView();
        initData();
        queryDb();

        iv_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_them.setText(them);


        GridLayoutManager layoutManager = new GridLayoutManager(this,2,RecyclerView.VERTICAL,false);
        recycler_changeitem.setLayoutManager(layoutManager);
        recycler_changeitem.setPadding(0,0,15,0);
        cosplayAdapter = new CosplayAdapter(imageUrlList, this);
        recycler_changeitem.setAdapter(cosplayAdapter);
    }





    private void initData() {
        them = getIntent().getStringExtra("them");
    }

    private void initView() {
        iv_back2 = (ImageView) findViewById(R.id.iv_back2);
        tv_them = (TextView) findViewById(R.id.tv_them);
        recycler_changeitem = (RecyclerView) findViewById(R.id.recycler_changeitem);
    }

    private void queryDb() {
        imageUrlList = new ArrayList<>();
        DatabaseHelper dbHelper  = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT url FROM picture WHERE them=?", new String[]{them},null);
        if (cursor.moveToFirst()) {
            do {
                String url = cursor.getString(0);
                imageUrlList.add(url);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
    }
}