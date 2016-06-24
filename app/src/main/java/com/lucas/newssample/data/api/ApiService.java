package com.lucas.newssample.data.api;

import com.lucas.newssample.beans.News;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * 作者：lucas on 2016/6/23 16:43
 * 邮箱：lucas_developer@163.com
 * 说明：Api
 */
public interface ApiService {
    @GET("nc/article/headline/T1348647909107/0-20.html")
    void getNewsList(Callback<News> callback);
}
