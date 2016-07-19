package com.zwei.materialdesigndemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zwei.materialdesigndemo.R;
import com.zwei.materialdesigndemo.bean.Article;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/7/18.
 */
public class PhotoGrideAdapter extends BaseRVAdpater<Article.DataBean.ContentBean> {
    public PhotoGrideAdapter(Context context) {
        super(context);
    }

    @Override
    protected RecyclerView.ViewHolder initViewholder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_photo,parent,false);
        return new photoViewHolder(view);
    }

    @Override
    protected void toBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        photoViewHolder photoViewHolder = (PhotoGrideAdapter.photoViewHolder) holder;
        Glide.with(mContext).load(mData.get(position).getImg()).into(photoViewHolder.imageView);
        photoViewHolder.text.setText(mData.get(position).getTitle());
    }

    class photoViewHolder extends BaseRVAdpater.BaseViewHolder{
        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.text)
        TextView text;
        public photoViewHolder(View itemView) {
            super(itemView);
        }
    }
}
