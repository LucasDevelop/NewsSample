package com.lucas.newssample.news.presenter;

import android.util.Log;

import com.lucas.newssample.able.OnLoadDataListener;
import com.lucas.newssample.base.presenter.BasePresenter;
import com.lucas.newssample.base.view.MvpView;
import com.lucas.newssample.beans.News;
import com.lucas.newssample.news.model.NewsModel;
import com.lucas.newssample.news.ui.NewsListFragment;

import java.util.List;

import javax.inject.Inject;

/**
 * 作者：lucas on 2016/6/27 14:58
 * 邮箱：lucas_developer@163.com
 * 说明：新闻列表p层
 */
public class NewsListPresenter extends BasePresenter<MvpView> {
    private NewsListFragment mFragment;
    @Inject
    NewsModel mNewsModel;

    @Inject
    public NewsListPresenter(NewsListFragment fragment) {
        mFragment = fragment;
    }

    public void loadData(int newsType, int limit) {
       mNewsModel.getNewsList(newsType, limit, new OnLoadDataListener<List<News>>() {
           @Override
           public void onSuccess(List<News> data) {
               if (limit == 0)
                   mFragment.refreshData(data);
               else
                   mFragment.loadMore(data);
               mFragment.hideLoading();
           }

           @Override
           public void onError(String msg, int errorCode) {
               Log.d("NewsListPresenter", msg);
           }
       });
    }
}
