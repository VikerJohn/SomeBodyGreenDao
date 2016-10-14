package com.dingdong.basenewdemo.fr.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dingdong.basenewdemo.ac.base.BaseAc;
import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/1.
 */

public abstract class BaseFragment<P extends FPBasePresenter> extends RxFragment implements FVuBase {


    public abstract int getLayoutResId();


    protected View mRootView;

    protected P mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        if (mRootView == null) {

            mRootView = inflater.inflate(getLayoutResId(), container, false);
            ButterKnife.bind(this, mRootView);//绑定framgent

            try {

                try {
                    mPresenter = getPresenterClass().newInstance();
                } catch (java.lang.InstantiationException e) {
                    e.printStackTrace();
                }

                mPresenter.initPresenter(this);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            initAllMembersView(savedInstanceState);
            return mRootView;
        }

        return mRootView;
    }

    protected abstract Class<P> getPresenterClass();

    protected abstract void initAllMembersView(Bundle savedInstanceState);

    /**
     * 新增Fragment
     *
     * @param resid
     * @param fragment
     */
    public void addFragmentToBackStack(int resid, @NonNull Fragment fragment) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.addToBackStack(fragment.getClass().getSimpleName());
        transaction.add(resid, fragment, fragment.getClass().getSimpleName());
        transaction.commitAllowingStateLoss();
    }

    /**
     * @param resid
     * @param fragment
     */
    public void replaceFragmentToBackStackByActivity(int resid, @NonNull Fragment fragment) {

        ((BaseAc) getActivity()).replaceFragmentToBackStack(resid, fragment);

    }


    public void finishAc() {
        getActivity().finish();
    }

    public void onPressBack() {
        if (!getChildFragmentManager().popBackStackImmediate()) {
            getActivity().onBackPressed();
        }
    }


    public void showLoading(String str) {
        ((BaseAc) getActivity()).showProgressDialog(str);
    }

    public void hideLoading() {
        ((BaseAc) getActivity()).hideProgressDialog();
    }
}

