package com.dingdong.basenewdemo.fr.base;

import android.support.annotation.StringRes;

/**
 * TopTitle
 * Created by Administrator on 2016/9/3.
 */
public abstract class FBTitlePresenter<V extends FVuBaseTitle> extends FPBasePresenter<V> {

    protected void init() {
        setTopTitle();
    }

    protected abstract void setTopTitle();

    public String getString(@StringRes int resId) {
        return vu.getContext().getString(resId);
    }
}
