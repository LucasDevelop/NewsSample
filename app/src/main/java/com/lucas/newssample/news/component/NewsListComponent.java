package com.lucas.newssample.news.component;

import com.lucas.newssample.news.module.NewsListModule;
import com.lucas.newssample.news.ui.NewsListFragment;

import dagger.Component;

/**
 * 作者：lucas on 2016/6/27 15:05
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
@Component(modules = NewsListModule.class)
public interface NewsListComponent {
    NewsListFragment getNewsListFragment();
    void inject(NewsListFragment fragment);
}
