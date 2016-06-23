package com.lucas.newssample;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.lucas.newssample.data.api.module.ApiServiceModule;

/**
 * 作者：lucas on 2016/6/23 15:59
 * 邮箱：lucas_developer@163.com
 * 说明：程序入口
 */
public class App extends Application {

    private Handler mHandler;
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mHandler = new Handler();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiServiceModule(new ApiServiceModule())
                .build();
    }

    public static App getApp(Context context){
        return (App) context.getApplicationContext();
    }

    public AppComponent getAppComponent(){
        return mAppComponent;
    }

    public Handler getUIHandler(){
        return mHandler;
    }
}
