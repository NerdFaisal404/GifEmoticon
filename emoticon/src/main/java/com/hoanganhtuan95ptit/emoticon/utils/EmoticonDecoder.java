package com.hoanganhtuan95ptit.emoticon.utils;

import android.content.Context;
import android.graphics.Bitmap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by HOANG ANH TUAN on 7/20/2017.
 */

class EmoticonDecoder {

    private int frameNum;
    private int delay;
    private long handle;

    EmoticonDecoder(Context context, String assetUrl) {
        handle = nativeInit();
        load(assetUrl, copy(context, assetUrl));
    }

    int frameNum() {
        return frameNum;
    }

    int getDelay() {
        return delay;
    }

    private void load(String assetUrl, String url) {
        if (!nativeLoad(handle, url)) {
            nativeClose(handle);
        } else {
            frameNum = nativeGetFrameCount(handle);
            for (int i = 0; i < frameNum; i++) {
                EmoticonCache.saveBitmap(assetUrl, i, nativeGetFrame(handle, i));
                delay = nativeGetDelay(handle, i);
            }
            nativeClose(handle);
        }
    }

    private String copy(Context context, String assetUrl) {
        try {
            InputStream is = context.getAssets().open(assetUrl);
            String destFile = context.getFilesDir().getAbsolutePath() + File.separator + assetUrl;

            File file = new File(destFile);
            destFile = context.getFilesDir().getAbsolutePath() + File.separator + file.getName();
            file = new File(destFile);
            if (file.exists()) return destFile;

            FileOutputStream os = new FileOutputStream(destFile);

            byte[] buffer = new byte[1024];
            int read;
            while ((read = is.read(buffer)) != -1) {
                os.write(buffer, 0, read);
            }
            is.close();
            os.flush();
            os.close();
            return destFile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    static {
        System.loadLibrary("native_lib_GifDecoder");
    }

    private native long nativeInit();

    private native void nativeClose(long var1);

    private native boolean nativeLoad(long var1, String var3);

    private native int nativeGetFrameCount(long var1);

    private native Bitmap nativeGetFrame(long var1, int var3);

    private native int nativeGetDelay(long var1, int var3);

}
