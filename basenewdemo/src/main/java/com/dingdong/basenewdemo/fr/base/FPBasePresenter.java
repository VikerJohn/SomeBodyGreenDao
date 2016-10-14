package com.dingdong.basenewdemo.fr.base;

/**
 * Created by Administrator on 2016/9/3.
 */
public class FPBasePresenter<V extends FVuBase> {
    protected V vu;

    public void initPresenter(V vu){
        this.vu = vu;
        init();
    }

    protected void init() {
    }



}
