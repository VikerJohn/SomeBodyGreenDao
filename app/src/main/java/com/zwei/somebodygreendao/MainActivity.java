package com.zwei.somebodygreendao;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.rockerhieu.emojicon.EmojiconEditText;
import com.rockerhieu.emojicon.EmojiconTextView;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.tv_emoji)
    EmojiconTextView tvEmoji;
    @BindView(R.id.tv_test)
    TextView tvTest;
    @BindView(R.id.et_emoji)
    EmojiconEditText etEmoji;
    private String str;
    @BindView(R.id.et_et)
    EditText etEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        String html = "";

        tvEmoji.setMovementMethod(ScrollingMovementMethod.getInstance());//滚动
        etEmoji.setMovementMethod(ScrollingMovementMethod.getInstance());//滚动

//        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.hanguo);

//        ImageSpan imgSpan = new ImageSpan(this,Code.getInstance().createBitmap());

        str = "nicke";
        ImageSpan imgSpan = new ImageSpan(this, NickeToBitmapUtil.getInstance().createBitmap(str));
        SpannableString spanString = new SpannableString(str);
        spanString.setSpan(imgSpan, 0, str.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        etEmoji.setText(spanString);

        etEmoji.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.e("beforeTextChanged", "CharSequence::" + s + "  start:" + start + " count:" + count + " after:" + after);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("onTextChanged", "CharSequence::" + s + "start:" + start + " before:" + before + " count:" + count);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.e("afterTextChanged", s.toString());

            }
        });

//        etEmoji.setText(Html.fromHtml(html)+"45645");
    }


    /*  public void sendMessage(View view) {
          Log.e("sendMessage", "sendMessage");
          etEmoji.getText();
          String str = etEmoji.getText().toString();
  *//*
        tvEmoji.setText(str);
        Log.e("sendMessage", "sendMessage:" + etEmoji.getText().toString());
        String tv = tvEmoji.getText().toString();
        Log.e("tvEmoji", "tvEmoji:" + tv);
        tvTest.setText(str);
        String tvT = tvTest.getText().toString();
        Log.e("tvTest", "tvTest:" + tvT);
*//*


        String etEtee = etEt.getText().toString();
        Log.e("etEtee", "etEtee:" + etEtee);
        comitMessage(str);
    }  */
    public void sendMessage(View view) {
        Log.e("sendMessage", "sendMessage");
        etEmoji.getText();
        String str = etEmoji.getText().toString();

     String emojiContent=   EmojiParser.getInstance(MainActivity.this).parseEmoji(str);

     SpannableStringBuilder ssb = EmojiParser.getInstance(MainActivity.this).convertToEmoji(emojiContent);

        tvTest.setText(ssb);


        String tvT = tvTest.getText().toString();
        Log.e("tvTest", "tvTest:" + tvT);

    }


    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

}
