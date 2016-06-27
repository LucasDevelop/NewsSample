package com.lucas.newssample.news.presenter;

import com.lucas.newssample.App;
import com.lucas.newssample.base.presenter.BasePresenter;
import com.lucas.newssample.base.view.MvpView;
import com.lucas.newssample.beans.News;
import com.lucas.newssample.news.ui.NewsListFragment;

import javax.inject.Inject;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * 作者：lucas on 2016/6/27 14:58
 * 邮箱：lucas_developer@163.com
 * 说明：新闻列表p层
 */
public class NewsListPresenter extends BasePresenter<MvpView> {
    private NewsListFragment mFragment;

    @Inject
    public NewsListPresenter(NewsListFragment fragment) {
        mFragment = fragment;
    }

    public void loadData(){
        App.getApp().getAppComponent().getApiService().getNewsList(new Callback<News>() {
            @Override
            public void success(News news, Response response) {
                mFragment.refreshData(news.T1348647909107);
            }

            @Override
            public void failure(RetrofitError error) {
                mFragment.loadFailed(error);
            }
        });
    }
}
