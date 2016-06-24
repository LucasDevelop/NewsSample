package com.lucas.newssample.main.ui;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.lucas.newssample.App;
import com.lucas.newssample.R;
import com.lucas.newssample.base.ui.BaseActivity;
import com.lucas.newssample.main.component.DaggerMainComponent;
import com.lucas.newssample.main.module.MainModule;
import com.lucas.newssample.main.presenter.MainPresenter;
import com.lucas.newssample.main.view.MainView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.main_content)
    FrameLayout mainContent;
    @InjectView(R.id.main_coor)
    CoordinatorLayout mainCoor;
    @InjectView(R.id.main_nav)
    NavigationView mainNav;
    @InjectView(R.id.main_draw)
    DrawerLayout mainDraw;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .appComponent(App.getApp(this).getAppComponent())
                .build().inject(this);
        //设置toolbar
        setSupportActionBar(toolbar);
        drawerToggle = new ActionBarDrawerToggle(this, mainDraw, toolbar, R.string.drawer_open, R.string.drawer_close);
        //同步状态
        drawerToggle.syncState();
        //关联开关
        mainDraw.addDrawerListener(drawerToggle);
        mainNav.setNavigationItemSelectedListener(
                item -> {
                    mainDraw.closeDrawers();
                    return true;
                });
    }

    @Override
    protected void initData() {
        mPresenter.loadData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
