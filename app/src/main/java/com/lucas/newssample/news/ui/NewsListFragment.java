package com.lucas.newssample.news.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lucas.newssample.R;
import com.lucas.newssample.base.ui.BaseFragment;
import com.lucas.newssample.beans.News;
import com.lucas.newssample.news.adapter.NewsListAdapter;
import com.lucas.newssample.news.component.DaggerNewsListComponent;
import com.lucas.newssample.news.module.NewsListModule;
import com.lucas.newssample.news.presenter.NewsListPresenter;
import com.lucas.newssample.news.view.NewsListView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.RetrofitError;

/**
 * 作者：lucas on 2016/6/27 09:49
 * 邮箱：lucas_developer@163.com
 * 说明：新闻列表
 */
public class NewsListFragment extends BaseFragment<NewsListPresenter> implements NewsListView {
    public static final int NEWS_TYPE_TOP = 0;//头条
    public static final int NEWS_TYPE_NBA = 1;//nba
    public static final int NEWS_TYPE_CARS = 2;//汽车
    public static final int NEWS_TYPE_JOKES = 3;//笑话

    public int type = NEWS_TYPE_TOP;
    @InjectView(R.id.news_list)
    RecyclerView mNewsList;
    @InjectView(R.id.news_swipe)
    SwipeRefreshLayout mNewsSwipe;
    private NewsRefreshListener mRefreshListener;
    private NewsListAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    //创建一个实例
    public static NewsListFragment newInstance(int type) {
        NewsListFragment fragment = new NewsListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getArguments().getInt("type", NEWS_TYPE_TOP);
    }


    @Override
    protected View initView() {
        DaggerNewsListComponent.builder()
                .newsListModule(new NewsListModule(this))
                .build().inject(this);
        View rootView = View.inflate(getActivity(), R.layout.fragment_news_list, null);
        ButterKnife.inject(this, rootView);
        //设置下拉刷新颜色
        mNewsSwipe.setColorSchemeColors(R.color.primary, R.color.primary_dark,
                R.color.primary_light, R.color.accent);
        mRefreshListener = new NewsRefreshListener();
        mNewsSwipe.setOnRefreshListener(mRefreshListener);
        //固定大小
        mNewsList.setHasFixedSize(true);
        //添加动画
        mNewsList.setItemAnimator(new DefaultItemAnimator());
        mLayoutManager = new LinearLayoutManager(getActivity());
        mNewsList.setLayoutManager(mLayoutManager);
        mAdapter = new NewsListAdapter();
        mNewsList.setAdapter(mAdapter);
        mNewsList.setOnScrollListener(new NewsScrollListener());
        return rootView;
    }

    @Override
    protected void initData() {
        //主动刷新
        mRefreshListener.onRefresh();
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
        mNewsSwipe.setRefreshing(false);
    }

    @Override
    public void refreshData(List<News.T1348647909107Bean> data) {
        //footer可显示
        mAdapter.isShowFooter(true);
        mAdapter.loadData(data);
        if (data == null || data.size() == 0)
            mAdapter.isShowFooter(false);
    }

    @Override
    public void loadFailed(RetrofitError error) {
        mNewsSwipe.setRefreshing(false);
        Toast.makeText(getActivity(), "error:" + error, Toast.LENGTH_SHORT).show();
    }

    class NewsScrollListener extends RecyclerView.OnScrollListener {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            //判断最后一个item是否显示并且是否是加载更多
            int lastPosition = mLayoutManager.findLastVisibleItemPosition();
//            if (mAdapter.isShowFooter() && mAdapter.getItemViewType(lastPosition) == NewsListAdapter.ITEM_FOOTER)
//                mPresenter.
        }
    }

    class NewsRefreshListener implements SwipeRefreshLayout.OnRefreshListener {
        @Override
        public void onRefresh() {
            mPresenter.loadData(type, mAdapter.getIndex());
        }
    }
}
