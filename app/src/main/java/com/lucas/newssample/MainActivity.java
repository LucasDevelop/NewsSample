package com.lucas.newssample;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
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
