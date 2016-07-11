package com.lucas.newssample.data.api;


import com.lucas.newssample.utils.Constant;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 作者：lucas on 2016/6/23 16:43
 * 邮箱：lucas_developer@163.com
 * 说明：Api
 */
public interface ApiService {
    @GET("{endUrl}")
    Call<ResponseBody> getNewsList(@Path("endUrl") String endUrl);

    @GET("{endUrl}")
    Call<ResponseBody> getNewsDetail(@Path("endUrl") String endUrl);

    @GET(Constant.IMAGES_URL)
    Call<ResponseBody> getImageList();

    @GET(Constant.INTERFACE_LOCATION+"{location}")
    Call<String> getCityName(@Path(("location")) String location);
}
