package com.lucas.newssample.news.component;

import com.lucas.newssample.AppComponent;
import com.lucas.newssample.news.module.NewsListModule;
import com.lucas.newssample.news.ui.NewsListFragment;
import com.lucas.newssample.utils.scope.FragmentScope;

import dagger.Component;

/**
 * 作者：lucas on 2016/6/27 15:05
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
@FragmentScope
@Component(modules = NewsListModule.class, dependencies = AppComponent.class)
public interface NewsListComponent {
    void inject(NewsListFragment fragment);
}
