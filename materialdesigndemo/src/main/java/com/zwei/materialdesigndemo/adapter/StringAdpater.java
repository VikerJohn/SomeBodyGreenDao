package com.zwei.materialdesigndemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zwei.materialdesigndemo.R;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/7/15.
 */
public class StringAdpater extends BaseRVAdpater<String> {
    public StringAdpater(Context context) {
        super(context);
    }

    @Override
    public void setDate(List<String> data) {
        /*for (int i = mData.size(); i < data.size(); i++) {
            mData.add(i,data.get(i));
            notifyItemInserted(i);
        }*/

        for (int i = mData.size(); i < 5; i++) {
            mData.add(i, "data.get(i):::" + i);
            notifyItemInserted(i);
        }
    }

    public void addData(int i) {
        mData.add(i, "data.get(i):::" + i);
        notifyItemInserted(i);
    }

    public void removeData(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
    }
    @Override
    protected RecyclerView.ViewHolder initViewholder(ViewGroup parent, int viewType) {
//        View view = View.inflate(mContext, R.layout.item_string, null);
//        View view = View.inflate(mContext, R.layout.item_string, parent);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_string, parent,false);

//        inflate(R.layout.item_view
//                parent,false);

        return new StringViewHolder(view);
    }

    @Override
    protected void toBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((StringViewHolder) holder).textView.setText(mData.get(position));

    }

    class StringViewHolder extends BaseViewHolder {
        @BindView(R.id.text)
        TextView textView;

        public StringViewHolder(View itemView) {
            super(itemView);
        }
    }
}
