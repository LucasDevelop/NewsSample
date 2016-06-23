package com.lucas.newssample;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 作者：lucas on 2016/6/23 16:17
 * 邮箱：lucas_developer@163.com
 * 说明：app组件
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    App getApp();
}
