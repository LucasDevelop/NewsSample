package com.lucas.newssample.news.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lucas.newssample.App;
import com.lucas.newssample.R;
import com.lucas.newssample.beans.News;
import com.lucas.newssample.utils.Constant;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：lucas on 2016/6/27 15:58
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
public class NewsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int ITEM_FOOTER = 1;
    public static final int ITEM_NORMAL = 0;
    private List<News> mData = new ArrayList<>();
    private boolean mIsShowFooter;
    private int mIndex;
    private NewsItemClickListener mListener;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_NORMAL) {
            View root = LayoutInflater.from(App.getApp()).inflate(R.layout.item_news_list, null);
            return new NewsHolder(root);
        } else {
            View view = LayoutInflater.from(App.getApp()).inflate(R.layout.item_footer, null);
            return new FooterHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == ITEM_NORMAL) {
            NewsHolder newsHolder = (NewsHolder) holder;
            Picasso.with(App.getApp())
                    .load(mData.get(position).imgsrc)
                    .into(newsHolder.mIcon);
            newsHolder.mTitle.setText(mData.get(position).title);
            newsHolder.mDes.setText(mData.get(position).digest);
        }
    }

    public News getNew(int position){
        return mData.get(position);
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() + (mIsShowFooter ? 1 : 0) : 0;
    }

    @Override
    public int getItemViewType(int position) {
        return mIsShowFooter && position == getItemCount() - 1 ? ITEM_FOOTER : ITEM_NORMAL;
    }

    //加载数据
    public void loadData(List<News> data) {
        mData.clear();
        mData.addAll(data);
        mIndex += Constant.PAGE_SIZE;
        notifyDataSetChanged();
    }

    //显示于隐藏加载更多
    public void isShowFooter(boolean isShowFooter) {
        mIsShowFooter = isShowFooter;
    }

    public boolean isShowFooter() {
        return mIsShowFooter;
    }

    public int getIndex() {
        return mIndex;
    }

    //加载更多
    public void addData(List<News> data) {
        mData.addAll(data);
        mIndex += Constant.PAGE_SIZE;
        //没有更多数据，不显示footer
        if (data.size() == 0)
            mIsShowFooter = false;
        notifyDataSetChanged();
    }

    //设置监听
    public void setOnItemClickListener(NewsItemClickListener listener) {
        mListener = listener;
    }

    public interface NewsItemClickListener {
        void onItemClick(View view, int position);
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
            itemView.setOnClickListener(v -> mListener.onItemClick(v, getAdapterPosition()));
        }
    }

    public class FooterHolder extends RecyclerView.ViewHolder {
        public FooterHolder(View itemView) {
            super(itemView);
        }
    }
}
