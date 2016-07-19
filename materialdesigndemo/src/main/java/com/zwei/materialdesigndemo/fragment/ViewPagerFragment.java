package com.zwei.materialdesigndemo.fragment;


import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zwei.materialdesigndemo.R;
import com.zwei.materialdesigndemo.widget.viewpager.DepthPageTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class ViewPagerFragment extends BaseFragment {

    public ViewPagerFragment() {
        resId = R.layout.fragment_view_pager;
    }

    @Override
    protected int setLayoutResId() {
        return R.layout.fragment_view_pager;
    }

    @BindView(R.id.vp_title)
    TextView tvTitle;

    @BindView(R.id.vp_photo)
    ViewPager mViewPager;

    private int[] mImgIds = new int[] { R.drawable.liu,
            R.drawable.s2, R.drawable.selina,R.drawable.t1,R.drawable.n1 };
    private List<ImageView> mImageViews = new ArrayList<ImageView>();


    @Override
    protected void initView() {
        initData();
        mViewPager.setAdapter(new MyAdapter());
        mViewPager.setPageTransformer(true,new DepthPageTransformer());

    }

    private void initData()
    {
        for (int imgId : mImgIds)
        {
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(imgId);
            mImageViews.add(imageView);
        }
    }

    class MyAdapter extends PagerAdapter
    {
        @Override
        public Object instantiateItem(ViewGroup container, int position)
        {
            container.addView(mImageViews.get(position));
            return mImageViews.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position,
                                Object object)
        {
            container.removeView(mImageViews.get(position));
        }

        @Override
        public boolean isViewFromObject(View view, Object object)
        {
            return view == object;
        }

        @Override
        public int getCount()
        {
            return mImgIds.length;
        }
    }
}
