package com.zwei.materialdesigndemo.service;

import com.zwei.materialdesigndemo.base.Contants;
import com.zwei.materialdesigndemo.bean.Article;
import com.zwei.materialdesigndemo.bean.Token;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/7/11.
 */
public class ApiService {


    public static void getArts(final String token, final CallbackData<List<Article.DataBean.ContentBean>> callback) {

        ApiSupport.getApi2Service().getArtList(token, 10, 0, null, null).subscribeOn(Schedulers.io())
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
                        } else {
                            callback.done(null);
                            Contants.log("错误码:" + data.getCode() + ":    :" + data.getMsg());
                        }
                    }
                });
    }


    public interface CallbackData<T> {
        void done(T data);
    }


}
