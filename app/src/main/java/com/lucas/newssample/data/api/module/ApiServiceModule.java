package com.lucas.newssample.data.api.module;

import com.google.gson.Gson;
import com.lucas.newssample.data.api.ApiService;
import com.lucas.newssample.utils.Constant;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

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
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(Constant.CONN_TIME_OUT, TimeUnit.MILLISECONDS);
        client.setReadTimeout(Constant.READ_TIME_OUT, TimeUnit.MILLISECONDS);
        return client;
    }

    //配置retrofit
    @Singleton
    @Provides
    RestAdapter providerRestAdapter(OkHttpClient client) {
        return new RestAdapter.Builder()
                .setClient(new OkClient(client))
                .setEndpoint(Constant.HOST)
                .setConverter(new GsonConverter(new Gson()))
                .build();
    }

    @Singleton
    @Provides
    ApiService providerApiService(RestAdapter restAdapter){
        return restAdapter.create(ApiService.class);
    }
}
