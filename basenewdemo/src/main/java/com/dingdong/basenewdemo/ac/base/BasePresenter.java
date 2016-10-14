package com.dingdong.basenewdemo.ac.base;

/**
 * Created by Administrator on 2016/9/3.
 */
public class BasePresenter<V> {
    protected V vu;

    public void setVu(V vu){
        this.vu = vu;
    }
}
