package com.lucas.newssample.main.presenter;

import android.util.Log;

import com.lucas.newssample.R;
import com.lucas.newssample.base.presenter.BasePresenter;
import com.lucas.newssample.main.ui.MainActivity;
import com.lucas.newssample.main.view.MainView;

import javax.inject.Inject;

/**
 * 作者：lucas on 2016/6/24 11:12
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
public class MainPresenter extends BasePresenter<MainView> {
    private MainActivity mMainActivity;
    private static final int NEWS = 0;
    private static final int IMAGES = 1;
    private static final int WEATHER = 2;
    private static final int ABOUT = 3;
    private int currentType = NEWS;

    @Inject
    public MainPresenter(MainActivity mainActivity) {
        mMainActivity = mainActivity;
    }

    public void loadData() {
//        mMainActivity.showLoading("Loading...");
    }

    public void switchNav(int itemId) {
        switch (itemId) {
            case R.id.menu_news:
                if (currentType == NEWS) return;
                currentType = NEWS;
                mMainActivity.switch2News();
                break;
            case R.id.menu_img:
                if (currentType == IMAGES) return;
                currentType = IMAGES;
                mMainActivity.switch2Images();
                break;
            case R.id.menu_weather:
                if (currentType == WEATHER) return;
                currentType = WEATHER;
                mMainActivity.switch2Weather();
                break;
            case R.id.menu_about:
                if (currentType == ABOUT) return;
                currentType = ABOUT;
                mMainActivity.switch2About();
                break;
            default:
                break;
        }
    }
}
