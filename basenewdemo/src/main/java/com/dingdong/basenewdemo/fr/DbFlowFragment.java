package com.dingdong.basenewdemo.fr;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


import com.dingdong.basenewdemo.R;
import com.dingdong.basenewdemo.fr.base.BaseFragment;
import com.dingdong.basenewdemo.fr.persenter.DbFlowPresenter;
import com.dingdong.basenewdemo.fr.view.FVuDbFlow;

import butterknife.BindView;

/**
 * Created by Viker on 2016/10/14.
 */
public class DbFlowFragment extends BaseFragment<DbFlowPresenter> implements FVuDbFlow {
    @BindView(R.id.btnBack)
    Button btnBack;
    @BindView(R.id.topTitle)
    TextView topTitle;

    @Override
    public int getLayoutResId() {
        return R.layout.fr_db_flow;
    }

    @Override
    protected Class<DbFlowPresenter> getPresenterClass() {
        return DbFlowPresenter.class;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {

    }

    @Override
    public TextView getTopTitle() {
        return topTitle;
    }
}