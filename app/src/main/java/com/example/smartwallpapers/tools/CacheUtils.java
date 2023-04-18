package com.example.smartwallpapers.tools;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class CacheUtils {

    public  void clearCache(Context context) {
        try {
            // 清除内部缓存
            File internalCacheDir = context.getCacheDir();
            if (internalCacheDir != null && internalCacheDir.isDirectory()) {
                deleteDirectoryContents(internalCacheDir);
            }

            // 清除外部缓存（如果存在）
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir != null && externalCacheDir.isDirectory()) {
                    deleteDirectoryContents(externalCacheDir);
                }
            }

            new Handler(Looper.getMainLooper()).post(() ->
                    Toast.makeText(context, "Successfully deleted cache", Toast.LENGTH_SHORT).show()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteDirectoryContents(File directory) throws IOException {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteDirectoryContents(file);
                    } else {
                        if (!file.delete()) {
                            throw new IOException("Failed to delete file: " + file.getAbsolutePath());
                        }
                    }
                }
            }
        }
    }
}