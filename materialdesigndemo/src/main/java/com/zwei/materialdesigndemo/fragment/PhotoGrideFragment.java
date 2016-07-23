package com.zwei.materialdesigndemo.fragment;



import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.GridLayoutManager;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.zwei.materialdesigndemo.R;

import com.zwei.materialdesigndemo.activity.DraScrollActivity;
import com.zwei.materialdesigndemo.adapter.BaseRVAdpater;
import com.zwei.materialdesigndemo.adapter.PhotoGrideAdapter;
import com.zwei.materialdesigndemo.bean.Article;
import com.zwei.materialdesigndemo.service.ApiService;
import com.zwei.materialdesigndemo.widget.recyclerview.adapter.AlphaAnimatorAdapter;

import java.util.List;

import butterknife.BindView;


public class PhotoGrideFragment extends BaseFragment {

    @BindView(R.id.list)
    RecyclerView mRecyclerView;
    private GridLayoutManager layoutManager;
    private PhotoGrideAdapter adapter;


    public PhotoGrideFragment() {
        resId = R.layout.fragment_photo_gride;
    }

    @Override
    protected int setLayoutResId() {
        return R.layout.fragment_photo_gride;
    }

    @Override
    protected void initView() {

        layoutManager = new GridLayoutManager(getContext(),3);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(false);

        adapter = new PhotoGrideAdapter(getContext());
        adapter.setOnItemClickListener(listener);
        adapter.isShowFooter(false);

        //添加Item动画
        AlphaAnimatorAdapter animatorAdapter = new AlphaAnimatorAdapter(adapter,mRecyclerView);
        mRecyclerView.setAdapter(adapter);

        loadData();
    }

    private void loadData() {

        ApiService.getArts(new ApiService.CallbackData<List<Article.DataBean.ContentBean>>() {
            @Override
            public void done(List<Article.DataBean.ContentBean> data) {
                adapter.setDate(data);
            }
        });

    }

    BaseRVAdpater.OnItemClickListener listener = new BaseRVAdpater.OnItemClickListener()
    {
        @Override
        public void onItemClick(View view, int position) {
            getActivity().startActivity(new Intent(getContext(), DraScrollActivity.class));
        }
    };

}
