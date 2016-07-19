package com.zwei.materialdesigndemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.zwei.materialdesigndemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoActivity extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        ButterKnife.bind(this);

    }
}
