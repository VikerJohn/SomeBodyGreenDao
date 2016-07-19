package com.zwei.materialdesigndemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.zwei.materialdesigndemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/7/2.
 */
public abstract class BaseRVAdpater<T> extends RecyclerView.Adapter {
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    protected List<T> mData;
    private boolean mShowFooter = true;
    protected Context mContext;
    private boolean delectFlag = false;

    private   OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public BaseRVAdpater(Context context) {
        this.mContext = context;
        mData = new ArrayList<>();
    }

    public void setDate(List<T> data) {
        this.mData = data;
        this.notifyDataSetChanged();
    }

    public List<T> getData() {
        return mData;
    }

    public void setDelectFlag(boolean delectFlag) {
        this.delectFlag = delectFlag;
    }

    @Override
    public int getItemViewType(int position) {
        // 最后一个item设置为footerView
        if (!mShowFooter) {
            return TYPE_ITEM;
        }
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        if (viewType == TYPE_ITEM) {
            RecyclerView.ViewHolder vh = initViewholder(parent, viewType);
            return vh;
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.footer, null);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            return new FooterViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder.getItemViewType() == TYPE_ITEM) {
            toBindViewHolder(holder, position);
        } else {
            toBindFootViewHolder(holder, position);
        }
    }

    protected abstract RecyclerView.ViewHolder initViewholder(ViewGroup parent, int viewType);

    protected abstract void toBindViewHolder(RecyclerView.ViewHolder holder, int position);

    protected void toBindFootViewHolder(RecyclerView.ViewHolder holder, int position) {

    }



    @Override
    public int getItemCount() {
        int begin = mShowFooter ? 1 : 0;
        if (mData == null) {
            return begin;
        }
        return mData.size() + begin;
    }

    public T getItem(int position) {
        return mData == null ? null : mData.get(position);
    }


    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public void isShowFooter(boolean showFooter) {
        this.mShowFooter = showFooter;
    }

    public boolean isShowFooter() {
        return this.mShowFooter;
    }


    public static class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View view) {
            super(view);
        }

    }


    public  class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public BaseViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mOnItemClickListener.onItemClick(view, this.getAdapterPosition());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
