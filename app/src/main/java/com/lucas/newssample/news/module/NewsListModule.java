package com.lucas.newssample.news.module;

import com.lucas.newssample.news.ui.NewsListFragment;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：lucas on 2016/6/27 15:03
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
@Module
public class NewsListModule {
    private NewsListFragment mFragment;

    public NewsListModule(NewsListFragment fragment) {
        mFragment = fragment;
    }

    @Provides
    NewsListFragment providesNewsListFragment(){
        return mFragment;
    }
}
