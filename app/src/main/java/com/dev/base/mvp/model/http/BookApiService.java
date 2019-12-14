package com.dev.base.mvp.model.http;

import com.dev.base.mvp.model.entity.res.HomeResBean;
import com.dev.base.mvp.model.entity.res.HttpResult;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * author:  ljy
 * date:    2017/9/14
 * description: retrofit的请求接口定义，用于豆瓣电影请求
 * <a>https://www.jianshu.com/p/092452f287db</a>
 */

public interface BookApiService {

    //请求参数一次性传入（通过Map来存放参数名和参数值）
    @GET("?name=1")
    Observable<HomeResBean> getHomeDataList();


}
