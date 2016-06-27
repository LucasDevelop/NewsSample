package com.lucas.newssample.news.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lucas.newssample.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 作者：lucas on 2016/6/24 18:16
 * 邮箱：lucas_developer@163.com
 * 说明：新闻页
 */
public class NewsFragment extends Fragment {
    @InjectView(R.id.news_tab)
    TabLayout mNewsTab;
    @InjectView(R.id.news_content)
    ViewPager mNewsContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = View.inflate(getActivity(), R.layout.fragment_news, null);
        ButterKnife.inject(this, rootView);
        initView();
        return rootView;
    }

    private void initView() {
        String[] titles = {"头条", "NBA", "汽车", "笑话"};
        NewsAdapter adapter = new NewsAdapter(getChildFragmentManager());
        for (int i = 0; i < titles.length; i++) {
            mNewsTab.addTab(mNewsTab.newTab().setText(titles[i]));
            adapter.addFragment(NewsListFragment.newInstance(i),titles[i]);
        }
        mNewsContent.setOffscreenPageLimit(3);
        mNewsContent.setAdapter(adapter);
        mNewsTab.setupWithViewPager(mNewsContent);
    }

    class NewsAdapter extends FragmentPagerAdapter {
        List<NewsListFragment> mFragments = new ArrayList<>();
        List<String> mTitles = new ArrayList<>();

        public NewsAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(NewsListFragment f, String title) {
            mFragments.add(f);
            mTitles.add(title);
        }

        @Override
        public int getCount() {
            return mFragments != null ? mFragments.size() : 0;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ButterKnife.reset(this);
    }
}
