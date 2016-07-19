package com.zwei.mymvpdemo.view;

import com.zwei.mymvpdemo.bean.User;

/**
 * Created by Administrator on 2016/6/28.
 */
public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
