package com.lucas.newssample.news.model;

import android.util.Log;

import com.lucas.newssample.App;
import com.lucas.newssample.able.OnLoadDataListener;
import com.lucas.newssample.beans.News;
import com.lucas.newssample.news.ui.NewsListFragment;
import com.lucas.newssample.utils.Constant;
import com.lucas.newssample.utils.ParseJson;

import java.util.List;

import javax.inject.Inject;

import retrofit.client.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者：lucas on 2016/7/1 10:33
 * 邮箱：lucas_developer@163.com
 * 说明：新闻列表的m层
 */
public class NewsModel {
    @Inject
    public NewsModel() {
    }

    public void getNewsList(int newsType, int limit, OnLoadDataListener listener) {
        if (listener == null)
            throw new RuntimeException("数据回调接口不能为空！");
        String endUrl = getUrl(newsType, limit);
        Log.d("NewsListPresenter", endUrl);
        Observable
                .just(endUrl)
                .map(s -> {
                    Response response = App.getApp().getAppComponent().getApiService().getNewsList(s);
                    Log.d("NewsListPresenter", response.getUrl());
                    return ParseJson.parseNews(response, getNewsId(newsType));
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(news -> {
                    listener.onSuccess(news);
                }, throwable -> {
                    listener.onError(throwable.toString(), 0);
                });
    }

    private String getUrl(int newsType, int limit) {
        StringBuilder builder = new StringBuilder();
        switch (newsType) {
            case NewsListFragment.NEWS_TYPE_TOP:
                builder.append(Constant.TOP_URL).append(Constant.TOP_ID);
                break;
            case NewsListFragment.NEWS_TYPE_CARS:
                builder.append(Constant.COMMON_URL).append(Constant.CAR_ID);
                break;
            case NewsListFragment.NEWS_TYPE_NBA:
                builder.append(Constant.COMMON_URL).append(Constant.NBA_ID);
                break;
            case NewsListFragment.NEWS_TYPE_JOKES:
                builder.append(Constant.COMMON_URL).append(Constant.JOKE_ID);
                break;
        }
        builder.append("/").append(limit).append(Constant.END_URL);
        return builder.toString();
    }

    private String getNewsId(int type) {
        String id = null;
        switch (type) {
            case NewsListFragment.NEWS_TYPE_TOP:
                id = Constant.TOP_ID;
                break;
            case NewsListFragment.NEWS_TYPE_CARS:
                id = Constant.CAR_ID;
                break;
            case NewsListFragment.NEWS_TYPE_JOKES:
                id = Constant.JOKE_ID;
                break;
            case NewsListFragment.NEWS_TYPE_NBA:
                id = Constant.NBA_ID;
                break;
        }
        return id;
    }
}
