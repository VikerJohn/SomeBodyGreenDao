package com.zwei.materialdesigndemo.service;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zwei.materialdesigndemo.base.Contants;
import com.zwei.materialdesigndemo.bean.Article;

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
        Map<String, String> params = new HashMap<>();
        params.put("token", "9433eeb7-8fe0-4bcd-b4cb-0589c18555fd ");
        params.put("page", 0 + "");
        params.put("pageSize", "" + 5);//pageSize 加载数量
        params.put("flag", "");
        params.put("createTime", null);

        final Api2Service apiService = ApiSupport.getApi2Service();

        Observable<Article> observable = apiService.getArtList("9433eeb7-8fe0-4bcd-b4cb-0589c18555fd",10,0,null,null);

        observable
                .subscribeOn(Schedulers.io())
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
                        Contants.log("称谷歌::"+article.getCode());
                        if (article.getCode()==2000){
                            callback.done(  article.getData().getContent());

                        }
                    }
                });
    }

    public interface CallbackData<T>{
        void done(T data);
    }


}
