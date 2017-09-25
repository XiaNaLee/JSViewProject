package com.iqyi.paopao.jsviewproject;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by LiYong on 2017/9/25.
 * Email:liyong@qiyi.com/lee131483@gmail.com
 * Version:
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
