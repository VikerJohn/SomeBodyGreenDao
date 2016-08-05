package com.zwei.materialdesigndemo.service;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zwei.materialdesigndemo.base.Contants;
import com.zwei.materialdesigndemo.bean.Article;
import com.zwei.materialdesigndemo.bean.Token;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/7/11.
 */
public class ApiService {

    public static void getArts(final CallbackData<List<Article.DataBean.ContentBean>> callback) {

//        Api2Service apiService = ;
        getToken(new CallbackData<String>() {
            @Override
            public void done(String data) {

                ApiSupport.getApi2Service().getArtList(data, 10, 0, null, null).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<Article>() {
                            @Override
                            public void onCompleted() {
                                Contants.log("onCompleted");
                            }

                            @Override
                            public void onError(Throwable e) {
                                Contants.log("onError:" + e.getMessage());
                            }


                            @Override
                            public void onNext(Article article) {
                                Contants.log("称谷歌::" + article.getCode());
                                if (article.getCode() == 2000) {
                                    callback.done(article.getData().getContent());

                                }
                            }
                        });
            }
        });




    }

    public static void getToken(final CallbackData<String> callback) {

        ApiSupport.getApi2Service().getToken("123", "123").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Token>() {
                    @Override
                    public void onCompleted() {
                        Contants.log("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Contants.log("onError:" + e.getMessage());
                    }


                    @Override
                    public void onNext(Token data) {
                        if (data.getCode() == 2000) {
                            callback.done(data.getData());
                        }else {
                            callback.done(null);
                            Contants.log("错误码:" + data.getCode()+":    :"+data.getMsg());
                        }
                    }
                });
    }


    public interface CallbackData<T> {
        void done(T data);
    }


}
