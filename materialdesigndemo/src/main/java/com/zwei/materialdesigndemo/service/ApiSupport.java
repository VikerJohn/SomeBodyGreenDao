package com.zwei.materialdesigndemo.service;

import android.content.Context;
import android.text.TextUtils;


import com.zwei.materialdesigndemo.base.Contants;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Administrator on 2016/7/7.
 */
public class ApiSupport {

    private static Context mContext;
    private static OkHttpClient okHttpClient;
    private static Api2Service api2Service;

    public static void initReft(Context context) {
        mContext = context;
        initOkhttp();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Contants.baseUrl + "/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        api2Service = retrofit.create(Api2Service.class);
    }

    public static Api2Service getApi2Service() {
        return api2Service;
    }

    private static void initOkhttp() {

        Interceptor  interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Contants.log("request="+request);
                Response response = chain.proceed(request);
                Contants.log("response="+response);

                String cacheControl = request.cacheControl().toString();
                if (TextUtils.isEmpty(cacheControl)) {
                    cacheControl = "public, max-age=60";
                }
                return response.newBuilder()
                        .header("Cache-Control", cacheControl)
                        .removeHeader("Pragma")
                        .build();
            }
        };

        File cacheFile = new File(getCacheDir(), "cacheFile");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb
//Contants.log("cacheFile::"+cacheFile.getAbsolutePath());
        //缓存
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .cache(cache)//缓存
                .addNetworkInterceptor(interceptor)
                .build();

    }

    private static File getCacheDir() {
        if (mContext == null)
            throw new IllegalStateException(
                    "applicationContext is null, Please call initialize first");
        else {
            System.out.println("============mContext.getCacheDir():"+ mContext.getExternalCacheDir());
            return mContext.getExternalCacheDir();
        }
    }



}

