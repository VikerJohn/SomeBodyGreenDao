package com.dingdong.basenewdemo.ac.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;


import com.dingdong.basenewdemo.R;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/1.
 */

public abstract class BaseAc<P extends BasePresenter> extends AppCompatActivity {
    protected P mPresenter;
    //加载dialog
    private AlertDialog shapeLoadingDialog;
    //是否已经显示过加载dialog
    private boolean isShowProgressDialog = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
        try {
            mPresenter = getPresenterClass().newInstance();
            mPresenter.setVu(this);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        initView(savedInstanceState);
    }

    protected abstract Class<P> getPresenterClass();

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract int getLayoutResId();

/*    public void addFragment(Fragment fragment, int id) {


        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction();
        fragmentTransaction.add(android.R.id.content, aMapFragment,
                MAP_FRAGMENT_TAG);
        fragmentTransaction.commit();
    }*/

    /**
     * 新增Fragment
     *
     * @param resid
     * @param fragment
     */
    public void addFragment(int resid, @NonNull Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.add(resid, fragment, fragment.getClass().getSimpleName());
        transaction.commitAllowingStateLoss();
    }

    /**
     * 新增Fragment
     *
     * @param resid
     * @param fragment
     */
    public void addFragmentToBackStack(int resid, @NonNull Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(fragment.getClass().getSimpleName());
        transaction.add(resid, fragment, fragment.getClass().getSimpleName());
        transaction.commitAllowingStateLoss();
    }

    /**
     * 新增Fragment
     *
     * @param resid
     * @param fragment
     */
    public void replaceFragmentToBackStack(int resid, @NonNull Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(fragment.getClass().getSimpleName());
        transaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        transaction.replace(resid, fragment, fragment.getClass().getSimpleName());
        transaction.commitAllowingStateLoss();
    }


    /**
     * 显示进度dialog
     *
     * @param title
     */
    public synchronized void showProgressDialog(String title) {
   /*     if (this.isFinishing()) {
            return;
        }
        if (shapeLoadingDialog == null) {
            shapeLoadingDialog = new ShapeLoadingDialog(this);
            isShowProgressDialog = false;
        }
        if (shapeLoadingDialog != null) {
            shapeLoadingDialog.setLoadingText(title);
            if (isShowProgressDialog == false) {
                shapeLoadingDialog.show();
                isShowProgressDialog = true;
            }
        }*/
    }

    /**
     * 隐藏进度dialog
     */
    public synchronized void hideProgressDialog() {
        if (shapeLoadingDialog != null) {
            shapeLoadingDialog.dismiss();
            shapeLoadingDialog = null;
            isShowProgressDialog = false;
        }
    }
}
