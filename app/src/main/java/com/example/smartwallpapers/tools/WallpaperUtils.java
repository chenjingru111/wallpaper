package com.example.smartwallpapers.tools;


import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class WallpaperUtils {

    private Context context;

    public WallpaperUtils(Context context) {
        this.context = context;
    }

    public void setWallpaperFromURL(String imageURL) {
        new SetWallpaperTask().execute(imageURL);
    }

    private class SetWallpaperTask extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... params) {
            String imageURL = params[0];
            Bitmap bitmap = null;
            try {
                URL url = new URL(imageURL);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            if (result != null) {
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(context);
                try {
                    wallpaperManager.setBitmap(result);
                    Toast.makeText(context, "Wallpaper set successfully！", Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}