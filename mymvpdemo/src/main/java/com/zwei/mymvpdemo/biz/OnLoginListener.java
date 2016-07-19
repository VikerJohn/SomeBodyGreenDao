package com.zwei.mymvpdemo.biz;


import com.zwei.mymvpdemo.bean.User;

/**
 * Created by zhy on 15/6/19.
 */
public interface OnLoginListener
{
    void loginSuccess(User user);

    void loginFailed();
}
