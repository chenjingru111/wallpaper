package com.example.smartwallpapers.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "picture_db";
    private static final int DATABASE_VERSION = 4;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createPictureTable = "CREATE TABLE picture (id INTEGER PRIMARY KEY AUTOINCREMENT, them TEXT, name TEXT,url TEXT);";
        db.execSQL(createPictureTable);
        String insertPictureData1 = "INSERT INTO picture (them, name,url) VALUES ('Recent','new year', 'https://w.wallhaven.cc/full/v9/wallhaven-v9v9y5.jpg');";
        db.execSQL(insertPictureData1);
        String insertPictureData2 = "INSERT INTO picture (them, name,url) VALUES ('Recent','subway', 'https://w.wallhaven.cc/full/z8/wallhaven-z82w6j.jpg');";
        db.execSQL(insertPictureData2);
        String insertPictureData3 = "INSERT INTO picture (them, name,url) VALUES ('Recent','no light', 'https://w.wallhaven.cc/full/6o/wallhaven-6omrd6.jpg');";
        db.execSQL(insertPictureData3);
        String insertPictureData4 = "INSERT INTO picture (them, name,url) VALUES ('Recent', 'piano','https://w.wallhaven.cc/full/4y/wallhaven-4y6v67.jpg');";
        db.execSQL(insertPictureData4);
        String insertPictureData5 = "INSERT INTO picture (them, name,url) VALUES ('Recent', '雷神','https://w.wallhaven.cc/full/l8/wallhaven-l8331r.jpg');";
        db.execSQL(insertPictureData5);
        String insertPictureData6 = "INSERT INTO picture (them, name,url) VALUES ('Recent', '雷神','https://w.wallhaven.cc/full/9m/wallhaven-9m1v9x.jpg');";
        db.execSQL(insertPictureData6);
        String insertPictureData7 = "INSERT INTO picture (them, name,url) VALUES ('Recent', '凝光','https://w.wallhaven.cc/full/o3/wallhaven-o3ypjp.jpg');";
        db.execSQL(insertPictureData7);
        String insertPictureData8 = "INSERT INTO picture (them, name,url) VALUES ('Recent', '甘雨&申鹤','https://w.wallhaven.cc/full/3l/wallhaven-3l388d.jpg');";
        db.execSQL(insertPictureData8);
        String insertPictureData9 = "INSERT INTO picture (them, name,url) VALUES ('Recent', 'honkai','https://w.wallhaven.cc/full/j3/wallhaven-j33315.jpg');";
        db.execSQL(insertPictureData9);
        String insertPictureData10 = "INSERT INTO picture (them, name,url) VALUES ('Recent', 'Exia','https://w.wallhaven.cc/full/k7/wallhaven-k7v6x6.jpg');";
        db.execSQL(insertPictureData10);
        String i11 = "INSERT INTO picture (them, name, url) VALUES ('Recent', 'WOO', 'https://w.wallhaven.cc/full/y8/wallhaven-y86lok.jpg');";
        db.execSQL(i11);
        String i12 = "INSERT INTO picture (them, name, url) VALUES ('Recent', 'smoke', 'https://w.wallhaven.cc/full/3l/wallhaven-3l3yx3.png');";
        db.execSQL(i12);

        String i13 = "INSERT INTO picture (them, name, url) VALUES ('Featured', '1', 'https://w.wallhaven.cc/full/8o/wallhaven-8oy1vo.png');";
        db.execSQL(i13);
        String i14 = "INSERT INTO picture (them, name, url) VALUES ('Featured', '2', 'https://w.wallhaven.cc/full/6o/wallhaven-6orp8l.jpg');";
        db.execSQL(i14);
        String i15 = "INSERT INTO picture (them, name, url) VALUES ('Featured', '3', 'https://w.wallhaven.cc/full/j3/wallhaven-j3zwlm.jpg');";
        db.execSQL(i15);
        String i16 = "INSERT INTO picture (them, name, url) VALUES ('Featured', '4', 'https://w.wallhaven.cc/full/dp/wallhaven-dp73vm.jpg');";
        db.execSQL(i16);
        String i17 = "INSERT INTO picture (them, name, url) VALUES ('Featured', '5', 'https://w.wallhaven.cc/full/wq/wallhaven-wq78kp.jpg');";
        db.execSQL(i17);
        String i18 = "INSERT INTO picture (them, name, url) VALUES ('Featured', '6', 'https://w.wallhaven.cc/full/k7/wallhaven-k7eorm.png');";
        db.execSQL(i18);
        String i19 = "INSERT INTO picture (them, name, url) VALUES ('Featured', '7', 'https://w.wallhaven.cc/full/j3/wallhaven-j3pgw5.png');";
        db.execSQL(i19);
        String i20 = "INSERT INTO picture (them, name, url) VALUES ('Featured', '8', 'https://w.wallhaven.cc/full/v9/wallhaven-v9j6j5.jpg');";
        db.execSQL(i20);
        String i21 = "INSERT INTO picture (them, name, url) VALUES ('Featured', '9', 'https://w.wallhaven.cc/full/q2/wallhaven-q2kykd.png');";
        db.execSQL(i21);
        String i22 = "INSERT INTO picture (them, name, url) VALUES ('Featured', '10', 'https://w.wallhaven.cc/full/k7/wallhaven-k75g3d.jpg');";
        db.execSQL(i22);
        String i23 = "INSERT INTO picture (them, name, url) VALUES ('Featured', '11', 'https://w.wallhaven.cc/full/28/wallhaven-28wv6g.jpg');";
        db.execSQL(i23);
        String i24 = "INSERT INTO picture (them, name, url) VALUES ('Featured', '12', 'https://w.wallhaven.cc/full/g7/wallhaven-g7x1p7.jpg');";


        db.execSQL(i24);
        String i25 = "INSERT INTO picture (them, name, url) VALUES ('Popular', '1', 'https://w.wallhaven.cc/full/ex/wallhaven-ex3l6o.jpg');";
        db.execSQL(i25);
        String i26 = "INSERT INTO picture (them, name, url) VALUES ('Popular', '2', 'https://w.wallhaven.cc/full/m3/wallhaven-m3zde8.jpg');";
        db.execSQL(i26);
        String i27 = "INSERT INTO picture (them, name, url) VALUES ('Popular', '3', 'https://w.wallhaven.cc/full/rr/wallhaven-rrq191.jpg');";
        db.execSQL(i27);
        String i28 = "INSERT INTO picture (them, name, url) VALUES ('Popular', '4', 'https://w.wallhaven.cc/full/kx/wallhaven-kx1k7d.png');";
        db.execSQL(i28);
        String i29 = "INSERT INTO picture (them, name, url) VALUES ('Popular', '5', 'https://w.wallhaven.cc/full/jx/wallhaven-jx1evw.png');";
        db.execSQL(i29);
        String i30 = "INSERT INTO picture (them, name, url) VALUES ('Popular', '6', 'https://w.wallhaven.cc/full/3l/wallhaven-3l31gv.png');";
        db.execSQL(i30);
        String i31 = "INSERT INTO picture (them, name, url) VALUES ('Popular', '7', 'https://w.wallhaven.cc/full/3l/wallhaven-3lqwv3.jpg');";
        db.execSQL(i31);
        String i32 = "INSERT INTO picture (them, name, url) VALUES ('Popular', '8', 'https://w.wallhaven.cc/full/yx/wallhaven-yxq8x7.jpg');";
        db.execSQL(i32);
        String i33 = "INSERT INTO picture (them, name, url) VALUES ('Popular', '9', 'https://w.wallhaven.cc/full/9d/wallhaven-9dm3kd.png');";
        db.execSQL(i33);
        String i34 = "INSERT INTO picture (them, name, url) VALUES ('Popular', '10', 'https://w.wallhaven.cc/full/p9/wallhaven-p9k1we.jpg');";
        db.execSQL(i34);
        String i35 = "INSERT INTO picture (them, name, url) VALUES ('Popular', '11', 'https://w.wallhaven.cc/full/qz/wallhaven-qz2qld.jpg');";
        db.execSQL(i35);
        String i36 = "INSERT INTO picture (them, name, url) VALUES ('Popular', '12', 'https://w.wallhaven.cc/full/m3/wallhaven-m39gr1.jpg');";
        db.execSQL(i36);
        String i37 = "INSERT INTO picture (them, name, url) VALUES ('Popular', '13', 'https://w.wallhaven.cc/full/qz/wallhaven-qz2m55.jpg');";
        db.execSQL(i37);
        String i38 = "INSERT INTO picture (them, name, url) VALUES ('Popular', '14', 'https://w.wallhaven.cc/full/1p/wallhaven-1pkglw.jpg');";
        db.execSQL(i38);
        String i39 = "INSERT INTO picture (them, name, url) VALUES ('Popular', '15', 'https://w.wallhaven.cc/full/p9/wallhaven-p9k3xe.jpg');";
        db.execSQL(i39);
        String i40 = "INSERT INTO picture (them, name, url) VALUES ('Popular', '16', 'https://w.wallhaven.cc/full/jx/wallhaven-jx52lq.png');";
        db.execSQL(i40);

        String i41 = "INSERT INTO picture (them, name, url) VALUES ('Random', '1', 'https://w.wallhaven.cc/full/vg/wallhaven-vgjpp5.jpg');";
        db.execSQL(i41);
        String i42 = "INSERT INTO picture (them, name, url) VALUES ('Random', '2', 'https://w.wallhaven.cc/full/xl/wallhaven-xlqgjo.png');";
        db.execSQL(i42);
        String i43 = "INSERT INTO picture (them, name, url) VALUES ('Random', '3', 'https://w.wallhaven.cc/full/96/wallhaven-96w9x1.jpg');";
        db.execSQL(i43);
        String i44 = "INSERT INTO picture (them, name, url) VALUES ('Random', '4', 'https://w.wallhaven.cc/full/3k/wallhaven-3kmd1y.jpg');";
        db.execSQL(i44);
        String i45 = "INSERT INTO picture (them, name, url) VALUES ('Random', '5', 'https://w.wallhaven.cc/full/x1/wallhaven-x1wzoz.jpg');";
        db.execSQL(i45);
        String i46 = "INSERT INTO picture (them, name, url) VALUES ('Random', '6', 'https://w.wallhaven.cc/full/r7/wallhaven-r7wgjq.jpg');";
        db.execSQL(i46);
        String i47 = "INSERT INTO picture (them, name, url) VALUES ('Random', '7', 'https://w.wallhaven.cc/full/j8/wallhaven-j8rwkq.jpg');";
        db.execSQL(i47);
        String i48 = "INSERT INTO picture (them, name, url) VALUES ('Random', '8', 'https://w.wallhaven.cc/full/lq/wallhaven-lqrzkr.jpg');";
        db.execSQL(i48);
        String i49 = "INSERT INTO picture (them, name, url) VALUES ('Random', '9', 'https://w.wallhaven.cc/full/yj/wallhaven-yjw5gk.jpg');";
        db.execSQL(i49);
        String i50 = "INSERT INTO picture (them, name, url) VALUES ('Random', '10', 'https://w.wallhaven.cc/full/k9/wallhaven-k9rzk7.jpg');";
        db.execSQL(i50);
        String i51 = "INSERT INTO picture (them, name, url) VALUES ('Random', '11', 'https://w.wallhaven.cc/full/1j/wallhaven-1jl1x3.jpg');";
        db.execSQL(i51);
        String i52 = "INSERT INTO picture (them, name, url) VALUES ('Random', '12', 'https://w.wallhaven.cc/full/2k/wallhaven-2kjz8y.jpg');";
        db.execSQL(i52);
        String i53 = "INSERT INTO picture (them, name, url) VALUES ('Random', '13', 'https://w.wallhaven.cc/full/mp/wallhaven-mpdw21.jpg');";
        db.execSQL(i53);
        String i54 = "INSERT INTO picture (them, name, url) VALUES ('Random', '14', 'https://w.wallhaven.cc/full/4v/wallhaven-4vkxml.jpg');";
        db.execSQL(i54);
        String i55 = "INSERT INTO picture (them, name, url) VALUES ('Random', '15', 'https://w.wallhaven.cc/full/4v/wallhaven-4vvp7m.jpg');";
        db.execSQL(i55);
        String i56 = "INSERT INTO picture (them, name, url) VALUES ('Random', '16', 'https://w.wallhaven.cc/full/kx/wallhaven-kx7v87.jpg');";
        db.execSQL(i56);

        String i57 = "INSERT INTO picture (them, name, url) VALUES ('dark', '莹', 'http://www.chenjingru.com/wp-content/uploads/2023/04/wallhaven-q22ypr-300x169.png');";
        db.execSQL(i57);
        String i58 = "INSERT INTO picture (them, name, url) VALUES ('dark', '优菈', 'http://www.chenjingru.com/wp-content/uploads/2023/04/wallhaven-k75wpm-300x169.png');";
        db.execSQL(i58);
        String i59 = "INSERT INTO picture (them, name, url) VALUES ('dark', '雷神', 'http://www.chenjingru.com/wp-content/uploads/2023/04/wallhaven-gp71we-300x169.png');";
        db.execSQL(i59);
        String i60 = "INSERT INTO picture (them, name, url) VALUES ('dark', '雷神', 'http://www.chenjingru.com/wp-content/uploads/2023/04/wallhaven-85eyl1-300x169.png');";
        db.execSQL(i60);
        String i61 = "INSERT INTO picture (them, name, url) VALUES ('dark', '刻晴', 'http://www.chenjingru.com/wp-content/uploads/2023/04/wallhaven-57m2v1-300x169.png');";
        db.execSQL(i61);
        String i62 = "INSERT INTO picture (them, name, url) VALUES ('dark', '宵宫', 'http://www.chenjingru.com/wp-content/uploads/2023/04/wallhaven-2y8m29-300x169.jpg');";
        db.execSQL(i62);
        String i63 = "INSERT INTO picture (them, name, url) VALUES ('dark', '莫娜', 'http://www.chenjingru.com/wp-content/uploads/2023/04/wallhaven-m9jpd8-300x169.jpg');";
        db.execSQL(i63);
        String i64 = "INSERT INTO picture (them, name, url) VALUES ('dark', '史莱姆', 'https://w.wallhaven.cc/full/q2/wallhaven-q23vo5.jpg');";
        db.execSQL(i64);
        String i65 = "INSERT INTO picture (them, name, url) VALUES ('dark', '公子', 'https://w.wallhaven.cc/full/q2/wallhaven-q2ro5q.jpg');";
        db.execSQL(i65);


        String i66 = "INSERT INTO picture (them, name, url) VALUES ('Abstarct', '1', 'https://w.wallhaven.cc/full/y8/wallhaven-y8gjqg.png');";
        db.execSQL(i66);
        String i67 = "INSERT INTO picture (them, name, url) VALUES ('Abstarct', '2', 'https://w.wallhaven.cc/full/dp/wallhaven-dprm5l.jpg');";
        db.execSQL(i67);
        String i68 = "INSERT INTO picture (them, name, url) VALUES ('Abstarct', '3', 'https://w.wallhaven.cc/full/57/wallhaven-579rg5.jpg');";
        db.execSQL(i68);
        String i69 = "INSERT INTO picture (them, name, url) VALUES ('Abstarct', '4', 'https://w.wallhaven.cc/full/zx/wallhaven-zxvvvw.png');";
        db.execSQL(i69);
        String i70 = "INSERT INTO picture (them, name, url) VALUES ('Abstarct', '5', 'https://w.wallhaven.cc/full/x1/wallhaven-x1o56z.png');";
        db.execSQL(i70);
        String i71 = "INSERT INTO picture (them, name, url) VALUES ('Abstarct', '6', 'https://w.wallhaven.cc/full/x1/wallhaven-x1rvko.jpg');";
        db.execSQL(i71);
        String i72 = "INSERT INTO picture (them, name, url) VALUES ('Abstarct', '7', 'https://w.wallhaven.cc/full/x1/wallhaven-x1kl5o.png');";
        db.execSQL(i72);
        String i73 = "INSERT INTO picture (them, name, url) VALUES ('Abstarct', '8', 'https://w.wallhaven.cc/full/ox/wallhaven-oxxw1p.png');";
        db.execSQL(i73);

        String i74 = "INSERT INTO picture (them, name, url) VALUES ('Anime', '1', 'https://w.wallhaven.cc/full/4x/wallhaven-4x7gg3.jpg');";
        db.execSQL(i74);
        String i75 = "INSERT INTO picture (them, name, url) VALUES ('Anime', '2', 'https://w.wallhaven.cc/full/zm/wallhaven-zm5kej.png');";
        db.execSQL(i75);
        String i76 = "INSERT INTO picture (them, name, url) VALUES ('Anime', '3', 'https://w.wallhaven.cc/full/q6/wallhaven-q6l7yq.png');";
        db.execSQL(i76);
        String i77 = "INSERT INTO picture (them, name, url) VALUES ('Anime', '4', 'https://w.wallhaven.cc/full/p8/wallhaven-p873dj.png');";
        db.execSQL(i77);
        String i78 = "INSERT INTO picture (them, name, url) VALUES ('Anime', '5', 'https://w.wallhaven.cc/full/3z/wallhaven-3zrv5v.png');";
        db.execSQL(i78);
        String i79 = "INSERT INTO picture (them, name, url) VALUES ('Anime', '6', 'https://w.wallhaven.cc/full/dg/wallhaven-dgwepj.png');";
        db.execSQL(i79);
        String i80 = "INSERT INTO picture (them, name, url) VALUES ('Anime', '7', 'https://w.wallhaven.cc/full/96/wallhaven-968m61.png');";
        db.execSQL(i80);
        String i81 = "INSERT INTO picture (them, name, url) VALUES ('Anime', '8', 'https://w.wallhaven.cc/full/j5/wallhaven-j5y77y.png');";
        db.execSQL(i81);

        String i82 = "INSERT INTO picture (them, name, url) VALUES ('Animal', '1', 'https://w.wallhaven.cc/full/6q/wallhaven-6qgxqx.jpg');";
        db.execSQL(i82);
        String i83 = "INSERT INTO picture (them, name, url) VALUES ('Animal', '2', 'https://w.wallhaven.cc/full/7p/wallhaven-7p16g9.jpg');";
        db.execSQL(i83);
        String i84 = "INSERT INTO picture (them, name, url) VALUES ('Animal', '3', 'https://w.wallhaven.cc/full/j8/wallhaven-j8q28p.jpg');";
        db.execSQL(i84);
        String i85 = "INSERT INTO picture (them, name, url) VALUES ('Animal', '4', 'https://w.wallhaven.cc/full/4d/wallhaven-4dykmm.jpg');";
        db.execSQL(i85);
        String i86 = "INSERT INTO picture (them, name, url) VALUES ('Animal', '5', 'https://w.wallhaven.cc/full/mp/wallhaven-mpexyy.jpg');";
        db.execSQL(i86);
        String i87 = "INSERT INTO picture (them, name, url) VALUES ('Animal', '6', 'https://w.wallhaven.cc/full/nm/wallhaven-nm8m9m.jpg');";
        db.execSQL(i87);
        String i88 = "INSERT INTO picture (them, name, url) VALUES ('Animal', '7', 'https://w.wallhaven.cc/full/d5/wallhaven-d5ylzg.jpg');";
        db.execSQL(i88);
        String i89 = "INSERT INTO picture (them, name, url) VALUES ('Animal', '8', 'https://w.wallhaven.cc/full/k9/wallhaven-k9wkw1.jpg');";
        db.execSQL(i89);

        String i90 = "INSERT INTO picture (them, name, url) VALUES ('Auto', '1', 'https://w.wallhaven.cc/full/e7/wallhaven-e7evgl.jpg');";
        db.execSQL(i90);
        String i91 = "INSERT INTO picture (them, name, url) VALUES ('Auto', '2', 'https://w.wallhaven.cc/full/1k/wallhaven-1kxov9.jpg');";
        db.execSQL(i91);
        String i92 = "INSERT INTO picture (them, name, url) VALUES ('Auto', '3', 'https://w.wallhaven.cc/full/9m/wallhaven-9mvvr1.png');";
        db.execSQL(i92);
        String i93 = "INSERT INTO picture (them, name, url) VALUES ('Auto', '4', 'https://w.wallhaven.cc/full/m9/wallhaven-m98398.png');";
        db.execSQL(i93);
        String i94 = "INSERT INTO picture (them, name, url) VALUES ('Auto', '5', 'https://w.wallhaven.cc/full/x6/wallhaven-x6677d.jpg');";
        db.execSQL(i94);
        String i95 = "INSERT INTO picture (them, name, url) VALUES ('Auto', '6', 'https://w.wallhaven.cc/full/9m/wallhaven-9modj8.jpg');";
        db.execSQL(i95);
        String i96 = "INSERT INTO picture (them, name, url) VALUES ('Auto', '7', 'https://w.wallhaven.cc/full/95/wallhaven-956oyx.png');";
        db.execSQL(i96);
        String i97 = "INSERT INTO picture (them, name, url) VALUES ('Auto', '8', 'https://w.wallhaven.cc/full/k7/wallhaven-k78xp1.jpg');";
        db.execSQL(i97);

        String i98 = "INSERT INTO picture (them, name, url) VALUES ('Comics', '1', 'https://w.wallhaven.cc/full/y8/wallhaven-y8qyvk.jpg');";
        db.execSQL(i98);
        String i99 = "INSERT INTO picture (them, name, url) VALUES ('Comics', '2', 'https://w.wallhaven.cc/full/yj/wallhaven-yj8k7k.png');";
        db.execSQL(i99);
        String i100 = "INSERT INTO picture (them, name, url) VALUES ('Comics', '3', 'https://w.wallhaven.cc/full/w8/wallhaven-w8j3vx.jpg');";
        db.execSQL(i100);
        String i101 = "INSERT INTO picture (them, name, url) VALUES ('Comics', '4', 'https://w.wallhaven.cc/full/kw/wallhaven-kw8wzq.jpg');";
        db.execSQL(i101);
        String i102 = "INSERT INTO picture (them, name, url) VALUES ('Comics', '5', 'https://w.wallhaven.cc/full/72/wallhaven-727w6e.jpg');";
        db.execSQL(i102);
        String i103 = "INSERT INTO picture (them, name, url) VALUES ('Comics', '6', 'https://w.wallhaven.cc/full/2k/wallhaven-2k86k9.png');";
        db.execSQL(i103);
        String i104 = "INSERT INTO picture (them, name, url) VALUES ('Comics', '7', 'https://w.wallhaven.cc/full/x1/wallhaven-x1zmyd.jpg');";
        db.execSQL(i104);
        String i105 = "INSERT INTO picture (them, name, url) VALUES ('Comics', '8', 'https://w.wallhaven.cc/full/8x/wallhaven-8xryjj.png');";
        db.execSQL(i105);

        String i106 = "INSERT INTO picture (them, name, url) VALUES ('dark', 'name106', 'url106');";
        db.execSQL(i106);

        String i107 = "INSERT INTO picture (them, name, url) VALUES ('dark', 'name107', 'url107');";
        db.execSQL(i107);

        String i108 = "INSERT INTO picture (them, name, url) VALUES ('dark', 'name108', 'url108');";
        db.execSQL(i108);

        String i109 = "INSERT INTO picture (them, name, url) VALUES ('dark', 'name109', 'url109');";
        db.execSQL(i109);

        String i110 = "INSERT INTO picture (them, name, url) VALUES ('dark', 'name110', 'url110');";
        db.execSQL(i110);

        String i111 = "INSERT INTO picture (them, name, url) VALUES ('dark', 'name111', 'url111');";
        db.execSQL(i111);

        String i112 = "INSERT INTO picture (them, name, url) VALUES ('dark', 'name112', 'url112');";
        db.execSQL(i112);

        String i113 = "INSERT INTO picture (them, name, url) VALUES ('dark', 'name113', 'url113');";
        db.execSQL(i113);

        String i114 = "INSERT INTO picture (them, name, url) VALUES ('dark', 'name114', 'url114');";
        db.execSQL(i114);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // database upgrade code goes here
    }
}
