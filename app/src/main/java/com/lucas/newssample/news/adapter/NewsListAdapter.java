package com.lucas.newssample.news.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lucas.newssample.App;
import com.lucas.newssample.R;
import com.lucas.newssample.beans.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：lucas on 2016/6/27 15:58
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsHolder> {
    private List<News.T1348647909107Bean> mData = new ArrayList<>();

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(App.getApp()).inflate(R.layout.item_news_list,null);
        return new NewsHolder(root);
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        Picasso.with(App.getApp())
                .load(mData.get(position).imgsrc)
                .into(holder.mIcon);
        holder.mTitle.setText(mData.get(position).title);
        holder.mDes.setText(mData.get(position).digest);
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    //加载数据
    public void loadData(List<News.T1348647909107Bean> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    //加载更多
    public void addData(List<News.T1348647909107Bean> data) {
        mData.addAll(data);
        notifyDataSetChanged();
    }

    public class NewsHolder extends RecyclerView.ViewHolder {

        public ImageView mIcon;
        public TextView mTitle;
        public TextView mDes;

        public NewsHolder(View itemView) {
            super(itemView);
            mIcon = (ImageView) itemView.findViewById(R.id.news_list_icon);
            mTitle = (TextView) itemView.findViewById(R.id.news_list_title);
            mDes = (TextView) itemView.findViewById(R.id.news_list_des);
        }
    }
}
