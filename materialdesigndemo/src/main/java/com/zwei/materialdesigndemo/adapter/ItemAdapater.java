package com.zwei.materialdesigndemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.zwei.materialdesigndemo.R;
import com.zwei.materialdesigndemo.bean.Article;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/7/11.
 */
public class ItemAdapater extends BaseRVAdpater<Article.DataBean.ContentBean> {

    public ItemAdapater(Context context) {
        super(context);
    }


    @Override
    public void setDate(List<Article.DataBean.ContentBean> data) {
        for (int i = mData.size(); i < data.size(); i++) {
            mData.add(i, data.get(i));
            notifyItemInserted(i);
        }
    }


    @Override
    protected RecyclerView.ViewHolder initViewholder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.fragment_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    protected void toBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Article.DataBean.ContentBean bean = getItem(position);

        ItemViewHolder viewHolder = (ItemViewHolder) holder;

        viewHolder.itemTitle.setText(bean.getTitle());

//        Picasso.with(mContext).load(bean.getImg()).into(viewHolder.itemImg);
        Glide.with(mContext).load(bean.getImg()).into(viewHolder.itemImg);
    }

    class ItemViewHolder extends BaseRVAdpater.BaseViewHolder {
        @BindView(R.id.item_img)
        ImageView itemImg;
        @BindView(R.id.item_title)
        TextView itemTitle;
  /*      @BindView(R.id.picture)
        ImageView itemImg;
        @BindView(R.id.name)
        TextView itemTitle;*/

        public ItemViewHolder(View itemView) {
            super(itemView);
        }


    }
}
