package com.zwei.materialdesigndemo.fragment;


import android.annotation.TargetApi;
import android.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.zwei.materialdesigndemo.R;
import com.zwei.materialdesigndemo.widget.viewpager.DepthPageTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/7/20.
 */
public class ContentFragment extends BaseFragment {
    @Override
    protected int setLayoutResId() {
        return R.layout.app_bar_dra_scroll;
    }

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout mCollapsingToolbarLayout;

    @BindView(R.id.viewpager)
    ViewPager mViewPager;

    private int[] mImgIds = new int[] { R.drawable.liu,
            R.drawable.s2, R.drawable.selina,R.drawable.t1,R.drawable.n1 };
    private List<ImageView> mImageViews = new ArrayList<ImageView>();

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initView() {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        initData();
        mViewPager.setAdapter(new MyAdapter());
        mViewPager.setPageTransformer(true,new DepthPageTransformer());


        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);

        mCollapsingToolbarLayout.setTitle(" 替天冷");
        mCollapsingToolbarLayout.setTitleEnabled(false);

        toolbar.setTitle("ContentFragment");
//        toolbar.setNavigationIcon(R.mipmap.ic_launcher);

        // 使左上角图标是否显示，如果设成false，则没有程序图标，仅仅就个标题，
        // 否则，显示应用程序图标，对应id为android.R.id.home，对应ActionBar.DISPLAY_SHOW_HOME


        DrawerLayout drawer = (DrawerLayout) getView().findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();


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
