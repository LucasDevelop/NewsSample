package com.lucas.newssample.news.view;

import com.lucas.newssample.base.view.MvpView;
import com.lucas.newssample.beans.News;

import java.util.List;

import retrofit.RetrofitError;

/**
 * 作者：lucas on 2016/6/27 16:14
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
public interface NewsListView extends MvpView {

    void refreshData(List<News> data);
    void loadFailed(RetrofitError error);
    void loadMore(List<News> data);
}
