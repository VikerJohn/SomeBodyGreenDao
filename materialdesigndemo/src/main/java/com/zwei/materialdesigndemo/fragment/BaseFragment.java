package com.zwei.materialdesigndemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zwei.materialdesigndemo.R;
import com.zwei.materialdesigndemo.utils.YLog;

import java.lang.ref.SoftReference;

import butterknife.ButterKnife;


/**
 * Created by Administrator on 2016/7/11.
 */
public abstract class BaseFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */

    protected int resId ;

    public BaseFragment() {
        if (resId==0){
            resId = setLayoutResId();
        }
    }

    protected abstract int setLayoutResId();

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */



    protected SoftReference<View> rootview;
    @Override
    public synchronized View onCreateView(LayoutInflater inflater, ViewGroup container,
                                          Bundle savedInstanceState) {
        if (rootview == null || rootview.get() == null) {
            System.out.println("onCreateView view is null");
            try {
                View view = inflater.inflate(resId,
                        container, false);
                rootview = new SoftReference<View>(view);

                ButterKnife.bind(this, rootview.get());

                initView();


            } catch (Exception e) {
                YLog.e("Exception:",e.getMessage());
            }

        } else {
            System.out.println("onCreateView but view has value");
            if ((ViewGroup) rootview.get().getParent() != null) {
                ((ViewGroup) rootview.get().getParent()).removeView(rootview.get());
            }
            refreshView();
        }
        return rootview.get();
    }

    protected void refreshView() {
    }

    protected abstract void initView();
}
