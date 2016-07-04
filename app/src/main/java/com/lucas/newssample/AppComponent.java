package com.lucas.newssample;

import android.os.Handler;

import com.google.gson.Gson;
import com.lucas.newssample.data.api.ApiService;
import com.lucas.newssample.data.api.module.ApiServiceModule;

import javax.inject.Singleton;
import dagger.Component;

/**
 * 作者：lucas on 2016/6/23 16:17
 * 邮箱：lucas_developer@163.com
 * 说明：app组件
 */
@Singleton
@Component(modules = {AppModule.class, ApiServiceModule.class})
public interface AppComponent {
    App getApp();
    ApiService getApiService();
    Gson getGson();
    Handler getHandler();
}
