package com.zwei.mymvpdemo.biz;

/**
 * Created by Administrator on 2016/6/28.
 */
public interface IUserBiz {
    public void login(String username,String password,OnLoginListener listener);
}
