package com.zwei.materialdesigndemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zwei.materialdesigndemo.R;
import com.zwei.materialdesigndemo.utils.YLog;

import java.lang.ref.SoftReference;

import butterknife.BindView;


/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends BaseFragment {

    protected static final String ARG_SECTION_NUMBER = "section_number";

    public PlaceholderFragment() {
        resId = R.layout.fragment_main;
    }

    @Override
    protected int setLayoutResId() {
        return R.layout.fragment_main;
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.section_label)
    TextView textView ;

    protected void initView() {
        textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
    }


}

