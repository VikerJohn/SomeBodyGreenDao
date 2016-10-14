package com.dingdong.basenewdemo.ac;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.View;

import com.dingdong.basenewdemo.R;
import com.dingdong.basenewdemo.ac.base.BaseAc;
import com.dingdong.basenewdemo.ac.base.BasePresenter;
import com.dingdong.basenewdemo.ui.GettingStartActivity;

public class MainActivity extends BaseAc {

    @Override
    protected Class getPresenterClass() {
        return BasePresenter.class;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    public void DbFragment(View view){
        startActivity(new Intent(MainActivity.this, ContentAc.class));
    }

}
