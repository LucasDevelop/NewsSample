package com.lucas.newssample.images.model;

import com.lucas.newssample.App;
import com.lucas.newssample.able.OnLoadDataListener;
import com.lucas.newssample.beans.Images;
import com.lucas.newssample.utils.Constant;
import com.lucas.newssample.utils.ParseJson;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：lucas on 2016/7/4 17:17
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
public class ImagesModel {

    private final OkHttpClient mClient;

    @Inject
    public ImagesModel() {
        mClient = new OkHttpClient();
    }

    public void loadData(OnLoadDataListener listener){
        Observable.just(Constant.IMAGES_URL)
                .map(s -> {
                    ResponseBody imageList = null;
                    try {
                        imageList = App.getAppComponent().getApiService().getImageList().execute().body();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    List<Images> images = null;
                    try {
                        images =  ParseJson.parseImages(imageList);
                    } catch (Exception e) {
                        e.printStackTrace();
                        listener.onError(e.toString(), 0);
                    }
                    return images;
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(i->listener.onSuccess(i),t->listener.onError(t.toString(),0));
    }
}
