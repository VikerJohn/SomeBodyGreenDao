package com.zwei.materialdesigndemo.service;

import com.zwei.materialdesigndemo.bean.Article;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/7/11.
 */
public interface Api2Service {
    /*@GET("app/read/infoCount")
       Observable<Result<ArticleInfoList>> getInfoCount(@Query("token") String token);*/


    @GET("app/read/findArticle")
    Observable<Article> getArtList(@Query("token") String token
            ,@Query("pageSize") int pageSize
            ,@Query("page") int page
            ,@Query("flag") Integer flag
            ,@Query("createTime") String createTime
    );

}
