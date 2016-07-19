package com.zwei.ximage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

import cn.kejin.ximageview.XImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private XImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.ibtn).setOnClickListener(this);
        findViewById(R.id.btn_show).setOnClickListener(this);
        imageView = (XImageView) findViewById(R.id.xImageView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ibtn:
                Log.e("showBig", "showBig");
                Toast.makeText(this, "12312", Toast.LENGTH_SHORT).show();
                imageView.setVisibility(View.VISIBLE);
                try {
                    imageView.setImage(getAssets().open("world.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }


//        Intent intent = new Intent(this,Main2Activity.class);
                Intent intent = new Intent(this, ArticleShowPicActivity.class);
//        Intent intent = new Intent(this,ImageActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_show:
                int num = 0 / 5;
                Log.e(getLocalClassName(), "答案:"+num+"");
                break;
        }
    }
}
