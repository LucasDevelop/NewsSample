package com.lucas.newssample.news.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.liuguangqiang.swipeback.SwipeBackActivity;
import com.liuguangqiang.swipeback.SwipeBackLayout;
import com.lucas.newssample.R;
import com.lucas.newssample.base.ui.BaseActivity;
import com.lucas.newssample.beans.News;
import com.lucas.newssample.news.component.DaggerNewsDetailComponent;
import com.lucas.newssample.news.module.NewsDetailModule;
import com.lucas.newssample.news.presenter.NewsDetailPresenter;
import com.lucas.newssample.news.view.NewsDetailView;
import com.squareup.picasso.Picasso;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.io.Serializable;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 作者：lucas on 2016/6/30 10:16
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
public class NewsDetailActivity extends SwipeBackActivity implements NewsDetailView {
    @InjectView(R.id.news_detail_header_img)
    ImageView mHeaderImg;
    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.news_detail_content)
    HtmlTextView mContent;
    @InjectView(R.id.news_detail_progress)
    ProgressBar mProgress;
    @Inject
    NewsDetailPresenter mPresenter;
    private News mNews;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        mPresenter.attach(this);
        initData();
    }

    protected void initView() {
        DaggerNewsDetailComponent
                .builder()
                .newsDetailModule(new NewsDetailModule(this))
                .build().inject(this);
        setContentView(R.layout.activity_news_detail);
        ButterKnife.inject(this);
        setSupportActionBar(mToolbar);
        //显示返回键
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(v -> onBackPressed());
        //左滑动
        getSwipeBackLayout().setDragEdge(SwipeBackLayout.DragEdge.LEFT);
        //设置滑动返回的可触摸范围
        getSwipeBackLayout().setFinishAnchor(getResources().getDisplayMetrics().widthPixels);
        Intent intent = getIntent();
        mNews = (News) intent.getSerializableExtra("news");
        getSupportActionBar().setTitle(mNews.title);
        Picasso.with(this).load(mNews.imgsrc).into(mHeaderImg);
    }

    protected void initData() {
        mPresenter.loadNewsDetail(mNews.docid);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
    }

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }
}
