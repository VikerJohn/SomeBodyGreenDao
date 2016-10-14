package com.dingdong.basenewdemo.fr.base;

import android.content.Context;


/**
 * Created by Administrator on 2016/9/3.
 */

public interface FVuBase {
    Context getContext();
    void showLoading(String str);
    void hideLoading();

}
