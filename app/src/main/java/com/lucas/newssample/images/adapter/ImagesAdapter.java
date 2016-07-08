package com.lucas.newssample.images.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lucas.newssample.App;
import com.lucas.newssample.R;
import com.lucas.newssample.beans.Images;
import com.lucas.newssample.utils.ViewUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：lucas on 2016/7/6 10:37
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImagesHolder> {

    private final int mX;
    List<Images> datas = new ArrayList<>();

    public ImagesAdapter(Context context) {
        mX = ViewUtils.getWindowSize(context).x-ViewUtils.dip2px(App.getApp(),10);
    }

    @Override
    public ImagesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = View.inflate(parent.getContext(), R.layout.item_images, null);
        return new ImagesHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ImagesHolder holder, int position) {
        holder.mTitle.setText(datas.get(position).title);
        Images image = datas.get(position);
        //按比例缩放
        float scale = (float) image.width / (float) image.height;
        int imageHeight = (int) (mX/scale);
        holder.mImage.setLayoutParams(new LinearLayout.LayoutParams(mX,imageHeight));
        Picasso.with(App.getApp()).load(datas.get(position).thumburl).into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void refreshData(List<Images> data) {
        datas.clear();
        datas.addAll(data);
        notifyDataSetChanged();
    }

    public class ImagesHolder extends RecyclerView.ViewHolder {

        public final TextView mTitle;
        public final ImageView mImage;

        public ImagesHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title);
            mImage = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
