package com.zwei.materialdesigndemo.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.zwei.materialdesigndemo.R;
import com.zwei.materialdesigndemo.base.Contants;
import com.zwei.materialdesigndemo.utils.String16Utils;
import com.zwei.materialdesigndemo.utils.YLog;

import butterknife.BindView;
import butterknife.OnClick;


public class EmojiViewFragment extends BaseFragment {
    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.textView)
    TextView textView;

    @Override
    protected void initView() {

    }

    @Override
    protected int setLayoutResId() {
        return R.layout.fragment_emoji_view;
    }

    @OnClick({R.id.acbtn, R.id.btn})
    public void onclickBtn(View view) {
        switch (view.getId()) {
            case R.id.acbtn:


                String str = etContent.getText().toString();
                String str16 = String16Utils.encode(str);

                Contants.log(str16);

                Contants.log(String16Utils.decode(str16));

                textView.setText(str);

                break;

            case R.id.btn:
                break;


        }
    }


}
