package com.zwei.mymvpdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;

import com.zwei.mymvpdemo.bean.User;
import com.zwei.mymvpdemo.view.IUserLoginView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.iv);
    }

    public void goUserLogin(View view) {
        Intent intent = new Intent(MainActivity.this, UserLoginActivity.class);
        startActivity(intent);
    }

/*    public void showImg( View view){
        if (view.getVisibility()==View.VISIBLE){
            imageView.setVisibility(View.GONE);
        }else {
            imageView.setVisibility(View.VISIBLE);
        }
    } */
    public void showImg( View view){
        ViewStub stub = (ViewStub) findViewById(R.id.viewstub_demo_image);
        stub.inflate();
        ImageView image = (ImageView) findViewById(R.id.iv);
//        image.setImageResource(R.drawable.happy_running_dog);
    }
}
