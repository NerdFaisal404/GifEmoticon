package com.hoanganhtuan95ptit.emoticon.utils;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by HOANG ANH TUAN on 7/20/2017.
 */

class EmoticonCache {

    private static final int SIZE_MAX = 1024;

    private static EmoticonCache instance;

    private static EmoticonCache getInstance() {
        if (instance == null) instance = new EmoticonCache();
        return instance;
    }

    private LruCache<String, Bitmap> drawableLruCache;

    private EmoticonCache() {
        drawableLruCache = new LruCache<>(SIZE_MAX);
    }

    private LruCache<String, Bitmap> getDrawableLruCache() {
        return drawableLruCache;
    }

    static Bitmap getBitmap(String assetUrl, int position) {
        return getInstance().getDrawableLruCache().get(assetUrl + position + "");
    }

    static void saveBitmap(String assetUrl, int position, Bitmap bitmap) {
        getInstance().getDrawableLruCache().put(assetUrl + position + "", bitmap);
    }

}
