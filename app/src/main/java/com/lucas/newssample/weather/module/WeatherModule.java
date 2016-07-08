package com.lucas.newssample.weather.module;

import com.lucas.newssample.weather.ui.WeatherFragment;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：lucas on 2016/7/6 14:52
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
@Module
public class WeatherModule {
    private WeatherFragment mFragment;

    public WeatherModule(WeatherFragment fragment) {
        mFragment = fragment;
    }

    @Provides
    WeatherFragment provideWeatherFragment(){
        return mFragment;
    }
}
