package com.zwei.emojiapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.et_emoji);

    }


    public void submit(View view) {


        Log.e(TAG, "submit::" + editText.getText().toString());
        String url = "http://192.168.2.204:8080/MyXProject/servlet/InputServlet";

        OkHttpUtils.post()
                .url(url)
                .addParams("input", "input123")
                .build()
                .execute(
                        new StringCallback() {
                            @Override
                            public void onError(Call call, Exception e, int id) {

                            }

                            @Override
                            public void onResponse(String response, int id) {

                            }
                        }
                );

    }
}
