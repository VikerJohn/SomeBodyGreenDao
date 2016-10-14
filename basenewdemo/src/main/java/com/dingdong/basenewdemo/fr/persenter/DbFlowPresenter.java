package com.dingdong.basenewdemo.fr.persenter;

import com.dingdong.basenewdemo.R;
import com.dingdong.basenewdemo.fr.base.FBTitlePresenter;
import com.dingdong.basenewdemo.fr.base.FPBasePresenter;
import com.dingdong.basenewdemo.fr.view.FVuDbFlow;

/**
 * Created by Viker on 2016/10/14.
 */
public class DbFlowPresenter extends FBTitlePresenter<FVuDbFlow> {
    @Override
    protected void setTopTitle() {
        vu.getTopTitle().setText(getString(R.string.app_name));
    }

   public void loadData(){

   }
}