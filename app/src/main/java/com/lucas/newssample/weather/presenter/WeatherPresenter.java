package com.lucas.newssample.weather.presenter;

import android.util.Log;

import com.lucas.newssample.base.presenter.BasePresenter;
import com.lucas.newssample.weather.model.WeatherModel;
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
    WeatherModel mModel;

    @Inject
    public WeatherPresenter(WeatherFragment fragment) {
        mFragment = fragment;
    }

    public void loadDate(){
     mModel.getCityName(mFragment.getActivity(), new WeatherModel.OnLocationListener() {
         @Override
         public void onSuccess(String cityName) {
            mFragment.setCityName(cityName);
         }

         @Override
         public void onFailed(String errorMsg) {
             Log.d("WeatherPresenter", errorMsg);
             mFragment.setCityName("深圳");
         }
     });
    }
}
