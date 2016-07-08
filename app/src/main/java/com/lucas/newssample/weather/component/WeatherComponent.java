package com.lucas.newssample.weather.component;

import com.lucas.newssample.AppComponent;
import com.lucas.newssample.utils.scope.FragmentScope;
import com.lucas.newssample.weather.module.WeatherModule;
import com.lucas.newssample.weather.ui.WeatherFragment;

import dagger.Component;

/**
 * 作者：lucas on 2016/7/6 14:54
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
@FragmentScope
@Component(modules = WeatherModule.class,dependencies = AppComponent.class)
public interface WeatherComponent {
    void injeect(WeatherFragment fragment);
}
