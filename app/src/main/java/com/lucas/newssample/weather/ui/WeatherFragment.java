package com.lucas.newssample.weather.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lucas.newssample.AppComponent;
import com.lucas.newssample.R;
import com.lucas.newssample.base.ui.BaseFragment;
import com.lucas.newssample.weather.component.DaggerWeatherComponent;
import com.lucas.newssample.weather.model.WeatherModel;
import com.lucas.newssample.weather.module.WeatherModule;
import com.lucas.newssample.weather.presenter.WeatherPresenter;
import com.lucas.newssample.weather.view.WeatherView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 作者：lucas on 2016/7/6 14:49
 * 邮箱：lucas_developer@163.com
 * 说明：天气
 */
public class WeatherFragment extends BaseFragment<WeatherPresenter> implements WeatherView{
    @InjectView(R.id.address)
    TextView mAddress;
    @InjectView(R.id.datetime)
    TextView mDatetime;
    @InjectView(R.id.weather_state)
    ImageView mWeatherState;
    @InjectView(R.id.temperature)
    TextView mTemperature;
    @InjectView(R.id.wind_direction)
    TextView mWindDirection;
    @InjectView(R.id.state)
    TextView mState;
    @InjectView(R.id.future_weather)
    LinearLayout mFutureWeather;

    @Override
    protected void setupComponent(AppComponent appComponent) {
        DaggerWeatherComponent.builder()
                .appComponent(appComponent)
                .weatherModule(new WeatherModule(this))
                .build().injeect(this);
    }

    @Override
    protected View initView() {
        View rootView = View.inflate(getActivity(), R.layout.fragment_weather, null);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    protected void initData() {
        mPresenter.loadDate();
    }

    @Override
    public void setCityName(String cityName) {
        mAddress.setText(cityName);
    }
}
