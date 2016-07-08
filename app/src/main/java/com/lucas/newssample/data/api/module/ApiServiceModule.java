package com.lucas.newssample.data.api.module;

import com.google.gson.Gson;
import com.lucas.newssample.data.api.ApiService;
import com.lucas.newssample.utils.Constant;


import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：lucas on 2016/6/23 16:47
 * 邮箱：lucas_developer@163.com
 * 说明：提供apiservice实例
 */
@Module
public class ApiServiceModule {

    //配置客户端
    @Singleton
    @Provides
    OkHttpClient providerOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(Constant.CONN_TIME_OUT, TimeUnit.MILLISECONDS)
                .readTimeout(Constant.READ_TIME_OUT,TimeUnit.MILLISECONDS)
                .writeTimeout(Constant.READ_TIME_OUT,TimeUnit.MILLISECONDS)
                .build();
    }

    //配置retrofit
    @Singleton
    @Provides
    Retrofit providerRestAdapter(OkHttpClient client, Gson gson) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(Constant.HOST)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Singleton
    @Provides
    ApiService providerApiService(Retrofit restAdapter) {
        return restAdapter.create(ApiService.class);
    }

}
