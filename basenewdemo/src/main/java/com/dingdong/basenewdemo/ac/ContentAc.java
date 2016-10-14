package com.dingdong.basenewdemo.ac;

import android.support.v4.app.Fragment;
import android.os.Bundle;

import com.dingdong.basenewdemo.R;
import com.dingdong.basenewdemo.ac.base.BaseAc;
import com.dingdong.basenewdemo.ac.base.BasePresenter;
import com.dingdong.basenewdemo.fr.DbFlowFragment;

public class ContentAc extends BaseAc {

    private Fragment fragment;

    @Override
    protected Class getPresenterClass() {
        return BasePresenter.class;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {


        fragment = new DbFlowFragment();
        addFragment(R.id.ac_content, fragment);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }
}
