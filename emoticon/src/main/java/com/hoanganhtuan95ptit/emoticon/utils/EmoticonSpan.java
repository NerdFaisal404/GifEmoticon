package com.hoanganhtuan95ptit.emoticon.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Hoang Anh Tuan on 12/14/2017.
 */

final class EmoticonSpan extends DynamicDrawableSpan {
    private Context context;
    private String assetUrl;
    private int textSize;

    private Drawable mDrawable;

    EmoticonSpan(Context context, String assetUrl, int textSize) {
        this.context = context;
        this.assetUrl = assetUrl;
        this.textSize = textSize;
        init();
    }

    private void init() {
        if (assetUrl.endsWith(".gif") || assetUrl.endsWith(".GIF")) getEmoticonDecoder();
    }

    private void getEmoticonDecoder() {
        Observable.just(assetUrl)
                .map(new Function<String, Drawable>() {
                    @Override
                    public Drawable apply(String assetUrl) throws Exception {
                        return new EmoticonDrawable(context, assetUrl, textSize);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Drawable>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Drawable emoticonDrawable) {
                        mDrawable = emoticonDrawable;
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                        ((EmoticonDrawable) mDrawable).animation();
                    }
                });
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public Drawable getDrawable() {
        if (mDrawable instanceof EmoticonDrawable) {
            return ((EmoticonDrawable) mDrawable).getDrawable();
        }
        if (mDrawable == null) {
            try {
                mDrawable = Drawable.createFromStream(context.getAssets().open(assetUrl), null);
                int height = textSize;
                int width = (height * mDrawable.getIntrinsicWidth()) / mDrawable.getIntrinsicHeight();
                mDrawable.setBounds(0, 0, width, height);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mDrawable;
    }

    @Override
    public int getSize(final Paint paint, final CharSequence text, final int start,
                       final int end, final Paint.FontMetricsInt fontMetrics) {
        if (fontMetrics != null) {
            final Paint.FontMetrics paintFontMetrics = paint.getFontMetrics();
            final float fontHeight = paintFontMetrics.descent - paintFontMetrics.ascent;
            final float centerY = paintFontMetrics.ascent + fontHeight / 2;

            fontMetrics.ascent = (int) (centerY - textSize / 2);
            fontMetrics.top = fontMetrics.ascent;
            fontMetrics.bottom = (int) (centerY + textSize / 2);
            fontMetrics.descent = fontMetrics.bottom;
        }

        return textSize;
    }

    @Override
    public void draw(final Canvas canvas, final CharSequence text, final int start,
                     final int end, final float x, final int top, final int y,
                     final int bottom, final Paint paint) {
        final Drawable drawable = getDrawable();
        final Paint.FontMetrics paintFontMetrics = paint.getFontMetrics();
        final float fontHeight = paintFontMetrics.descent - paintFontMetrics.ascent;
        final float centerY = y + paintFontMetrics.descent - fontHeight / 2;
        final float transitionY = centerY - textSize / 2;

        canvas.save();
        canvas.translate(x, transitionY);
        drawable.draw(canvas);
        canvas.restore();
    }
}
