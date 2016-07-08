package com.lucas.newssample.weather.presenter;

import com.lucas.newssample.base.presenter.BasePresenter;
import com.lucas.newssample.weather.ui.WeatherFragment;
import com.lucas.newssample.weather.view.WeatherView;

import javax.inject.Inject;

/**
 * 作者：lucas on 2016/7/6 14:50
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
public class WeatherPresenter extends BasePresenter<WeatherView>{
    private WeatherFragment mFragment;

    @Inject
    public WeatherPresenter(WeatherFragment fragment) {
        mFragment = fragment;
    }
}
