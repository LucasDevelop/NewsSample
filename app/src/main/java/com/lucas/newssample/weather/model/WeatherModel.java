package com.lucas.newssample.weather.model;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.util.Log;

import com.lucas.newssample.App;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;

/**
 * 作者：lucas on 2016/7/6 14:55
 * 邮箱：lucas_developer@163.com
 * 说明：天气数据层
 */
public class WeatherModel {
    @Inject
    public WeatherModel() {
    }

    public void getCityName(Context context,OnLocationListener listener) {
        //检查权限
        LocationManager systemService = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                context.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                context.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            listener.onFailed("权限被拒绝！");
            return;
        }
        //基站定位
        Location location = systemService.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        if (location==null) {
            listener.onFailed("基站定位失败！");
            return;
        }
        double latitude = location.getLatitude();//经度
        double longitude = location.getLongitude();//纬度
        App.getAppComponent()
                .getApiService()
                .getCityName(latitude+","+longitude)
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        listener.onSuccess(response.body());
                        Log.d("WeatherModel", response.body());
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        listener.onFailed(t.toString());
                    }
                });
    }

    public interface OnLocationListener{
        void onSuccess(String cityName);
        void onFailed(String errorMsg);
    }
}
