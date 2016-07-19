package com.zwei.jswebview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private WebView contentWebView = null;
    private TextView msgView = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contentWebView = (WebView) findViewById(R.id.webview);
        msgView = (TextView) findViewById(R.id.msg);
        // 启用javascript
        contentWebView.getSettings().setJavaScriptEnabled(true);

        // 从assets目录下面的加载html
        contentWebView.loadUrl("file:///android_asset/wst.html");
//        contentWebView.loadUrl("file:///android_asset/articl.html");

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(btnClickListener);



        contentWebView.addJavascriptInterface(this, "wst");
//        contentWebView.addJavascriptInterface(this, "hostapp");

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
 /*       Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });*/


    }

    View.OnClickListener btnClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            // 无参数调用
            contentWebView.loadUrl("javascript:javacalljs()");
            // 传递参数调用
            contentWebView.loadUrl("javascript:javacalljswithargs(" + "'hello world'" + ")");
        }
    };
    //==================测试代码 ==================

    @JavascriptInterface
    public void startFunction() {
        Toast.makeText(this, "js调用了java函数", Toast.LENGTH_SHORT).show();
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                msgView.setText(msgView.getText() + "\njs调用了java函数");

            }
        });
    }
    @JavascriptInterface
    public void startFunction(final String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                msgView.setText(msgView.getText() + "\njs调用了java函数传递参数：" + str);

            }
        });
    }

    @JavascriptInterface
    public void toast(int index, final String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();

        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                msgView.setText(msgView.getText() + "\njs调用了java函数传递参数：" + str);

            }
        });
    }
//==================测试代码 ==================

}
