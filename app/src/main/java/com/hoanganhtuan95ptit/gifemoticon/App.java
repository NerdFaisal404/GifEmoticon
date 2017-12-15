package com.hoanganhtuan95ptit.gifemoticon;

import android.app.Application;

import com.hoanganhtuan95ptit.gifemoticon.utils.GifEmoticonProvider;

/**
 * Created by Hoang Anh Tuan on 12/15/2017.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        GifEmoticonProvider.create();
    }
}
