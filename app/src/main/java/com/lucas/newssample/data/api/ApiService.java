package com.lucas.newssample.data.api;


import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * 作者：lucas on 2016/6/23 16:43
 * 邮箱：lucas_developer@163.com
 * 说明：Api
 */
public interface ApiService {
    @GET("/{endUrl}")
    Response getNewsList(@Path("endUrl") String endUrl);

    @GET("/{endUrl}")
    Response getNewsDetail(@Path("endUrl") String endUrl);
}
