package com.hoanganhtuan95ptit.emoticon.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;

/**
 * Created by HOANG ANH TUAN on 7/9/2017.
 */

class EmoticonDrawable extends AnimationDrawable {

    private Context context;
    private String assetUrl;
    private int textSize;

    private int mCurrentIndex = 0;

    EmoticonDrawable(Context context, String assetUrl, int textSize) {
        this.context = context;
        this.assetUrl = assetUrl;
        this.textSize = textSize;
        init();
    }

    private void init() {
        EmoticonDecoder emoticonDecoder = new EmoticonDecoder(context, assetUrl);
        for (int i = 0; i < emoticonDecoder.frameNum(); i++) {
            Bitmap bitmap = EmoticonCache.getBitmap(assetUrl, i);
            BitmapDrawable drawable = new BitmapDrawable(context.getResources(), bitmap);
            int height = textSize;
            int width = (height * drawable.getIntrinsicWidth()) / drawable.getIntrinsicHeight();
            drawable.setBounds(0, 0, width, height);
            addFrame(drawable, emoticonDecoder.getDelay());
            if (i == 0) {
                setBounds(0, 0, width, height);
            }
        }
    }

    void animation() {
        final Handler mHandler = new Handler();
        mHandler.post(new Runnable() {
            public void run() {
                mCurrentIndex++;
                if (mCurrentIndex >= getNumberOfFrames()) mCurrentIndex = 0;
                mHandler.postDelayed(this, getDuration(mCurrentIndex));
            }
        });
    }

    int getDuration() {
        return getDuration(mCurrentIndex);
    }

    Drawable getDrawable() {
        return getFrame(mCurrentIndex);

    }

}
