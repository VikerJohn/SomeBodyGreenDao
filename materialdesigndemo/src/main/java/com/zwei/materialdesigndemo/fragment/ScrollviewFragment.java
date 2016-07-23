package com.zwei.materialdesigndemo.fragment;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.nineoldandroids.view.ViewHelper;
import com.zwei.materialdesigndemo.R;
import com.zwei.materialdesigndemo.activity.DraScrollActivity;
import com.zwei.materialdesigndemo.activity.ScrollingActivity;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/7/21.
 */

public class ScrollViewFragment extends BaseFragment implements ObservableScrollViewCallbacks {

    @BindView(R.id.scroll)
    ObservableScrollView mScrollView;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.anchor)
    View anchor;
    @BindView(R.id.body)
    TextView body;
    @BindView(R.id.toolbar)
    Toolbar mToolbarView;


    private int mParallaxImageHeight;

    @Override
    protected int setLayoutResId() {
        return R.layout.fragment_scroll_view;
    }

    @Override
    protected void initView() {
        setHasOptionsMenu(true);
        mToolbarView.setTitle("");
        mToolbarView.setBackgroundColor(ScrollUtils.getColorWithAlpha(0, getResources().getColor(R.color.colorAccent)));
//        mToolbarView.setBackgroundColor(ScrollUtils.getColorWithAlpha(0, getResources().getColor(R.color.colorPrimary)));

        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbarView);

        mScrollView.setScrollViewCallbacks(this);
        mParallaxImageHeight = getResources().getDimensionPixelSize(R.dimen.parallax_image_height);

        initAction();

    }

    private void initAction() {
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        DrawerLayout drawer = ((DraScrollActivity)getActivity()).getDrawer();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, mToolbarView, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();//不清空就会变成添加进来而不是替换
        inflater.inflate(R.menu.menu_home, menu);
//        LayoutInflater inflator = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        super.onCreateOptionsMenu(menu, inflater);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        onScrollChanged(mScrollView.getCurrentScrollY(), false, false);
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        int baseColor = getResources().getColor(R.color.colorPrimary);
        float alpha = Math.min(1, (float) scrollY / mParallaxImageHeight);
        mToolbarView.setBackgroundColor(ScrollUtils.getColorWithAlpha(alpha, baseColor));
        ViewHelper.setTranslationY(image, scrollY / 2);
    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {

    }

}
