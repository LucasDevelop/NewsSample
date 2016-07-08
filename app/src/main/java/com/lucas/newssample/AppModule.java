package com.lucas.newssample;

import android.os.Handler;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：lucas on 2016/6/23 16:13
 * 邮箱：lucas_developer@163.com
 * 说明：提供app实例
 */
@Module
public class AppModule {
    private App mApp;

    public AppModule(App app) {
        mApp = app;
    }

    //单列
    @Singleton
    @Provides
    App provideApp(){
        return mApp;
    }

    //解析器
    @Singleton
    @Provides
    Gson provideGson(){
        return new Gson();
    }

    //handler
    @Singleton
    @Provides
    Handler provideHandler(){
        return new Handler();
    }

}

