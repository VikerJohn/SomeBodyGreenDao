package com.zwei.mymvpdemo.presenter;

import android.os.Handler;

import com.zwei.mymvpdemo.bean.User;
import com.zwei.mymvpdemo.biz.IUserBiz;
import com.zwei.mymvpdemo.biz.OnLoginListener;
import com.zwei.mymvpdemo.biz.UserBiz;
import com.zwei.mymvpdemo.view.IUserLoginView;

/**
 * Created by zhy on 15/6/19.
 */
public class UserLoginPresenter
{
    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();


    public UserLoginPresenter(IUserLoginView userLoginView)
    {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    public void login()
    {
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener()
        {
            @Override
            public void loginSuccess(final User user)
            {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });

            }

            @Override
            public void loginFailed()
            {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });

            }
        });
    }

    public void clear()
    {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }



}
