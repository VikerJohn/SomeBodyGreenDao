package com.zwei.materialdesigndemo.fragment;


import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zwei.materialdesigndemo.activity.PhotoActivity;
import com.zwei.materialdesigndemo.R;
import com.zwei.materialdesigndemo.activity.ScrollingActivity;
import com.zwei.materialdesigndemo.adapter.BaseRVAdpater;
import com.zwei.materialdesigndemo.adapter.ItemAdapater;
import com.zwei.materialdesigndemo.adapter.StringAdpater;
import com.zwei.materialdesigndemo.base.Contants;
import com.zwei.materialdesigndemo.bean.Article;
import com.zwei.materialdesigndemo.service.ApiService;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ItemFragment extends BaseFragment implements BaseRVAdpater.OnItemClickListener {


//    private StringAdpater itemAdapater;
    private ItemAdapater itemAdapater;



    @Override
    protected int setLayoutResId() {
        return R.layout.fragment_item_list;
    }

    @BindView(R.id.list)
    RecyclerView mRecyclerView;

    @Override
    protected void initView() {

        itemAdapater = new ItemAdapater(getContext());
//        itemAdapater = new StringAdpater(getContext());
        itemAdapater.setOnItemClickListener(this);
        itemAdapater.isShowFooter(false);
        mRecyclerView.setAdapter(itemAdapater);
        // 设置LinearLayoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        // 设置ItemAnimator
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mRecyclerView.setItemAnimator(new MyItemAnimator());
        // 设置固定大小
        mRecyclerView.setHasFixedSize(false);

        /*mRecyclerView.addItemDecoration(new RecycleViewDivider(
                getContext(), LinearLayoutManager.VERTICAL, 10, getResources().getColor(R.color.colorAccent)));*/

//        itemAdapater.setDate(new ArrayList<Article.DataBean.ContentBean>());
        loadData();
//        itemAdapater.setDate(null);
    }

    private void loadData() {
      /*  ApiService.getArts(new ApiService.CallbackData<List<Article.DataBean.ContentBean>>() {
            @Override
            public void done(List<Article.DataBean.ContentBean> data) {
                itemAdapater.setDate(data);
                itemAdapater.notifyDataSetChanged();
            }
        });*/

        ApiService.getArts("",new ApiService.CallbackData<List<Article.DataBean.ContentBean>>() {
            @Override
            public void done(List<Article.DataBean.ContentBean> data) {

            }
        });


//        itemAdapater.addData(num++);

    }
    private int num = 0;


    @OnClick({R.id.btn_add,R.id.btn_remove})
    public void onBtnClick(View v){
        switch (v.getId()){
            case R.id.btn_add:
                loadData();
                break;

            case R.id.btn_remove:
                if (num<=0){
                    Snackbar.make(v, "没有数据可以删除了", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                    return;
                }

//              itemAdapater.removeData(num--);
                break;


        }
    }



    @Override
    public void onItemClick(View view, int position) {
        itemAdapater.getItem(position);
        scaleUpAnimation( view);
    }


    private void scaleUpAnimation(View view) {
        //让新的Activity从一个小的范围扩大到全屏
       int width =  (int)view.getWidth()/2;
       int height = (int)view.getHeight()/2;
        Contants.log("width:"+width+" height:"+height);

        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeScaleUpAnimation(view, //The View that the new activity is animating from
                        (int)view.getWidth()/2, (int)view.getHeight()/2, //拉伸开始的坐标
                        view.getWidth(), view.getHeight());//拉伸开始的区域大小，这里用（0，0）表示从无到全屏
        startNewAcitivity(options);
    }

    private void startNewAcitivity(ActivityOptionsCompat options) {
        Intent intent = new Intent(getActivity(),ScrollingActivity.class);
        ActivityCompat.startActivity(getActivity(), intent, options.toBundle());
    }
}
