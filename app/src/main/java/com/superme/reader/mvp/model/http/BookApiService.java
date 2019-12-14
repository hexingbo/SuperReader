package com.superme.reader.mvp.model.http;

import com.superme.reader.app.constant.UrlConstants;
import com.superme.reader.mvp.model.entity.res.CategoryBean;
import com.superme.reader.mvp.model.entity.res.CategoryBookItemBean;
import com.superme.reader.mvp.model.entity.res.HomeResBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * author:  ljy
 * date:    2017/9/14
 * description: retrofit的请求接口定义，用于豆瓣电影请求
 * <a>https://www.jianshu.com/p/092452f287db</a>
 */

public interface BookApiService {

    @GET(UrlConstants.Get_Book_Category)
    Observable<CategoryBean> getCategory();

    @GET(UrlConstants.Get_Book_Category_Item)
    Observable<CategoryBookItemBean> getCategoryBookItem(@Query("start") int start,
                                                 @Query("limit") String limit,
                                                 @Query("major") String major,
                                                 @Query("minor") String minor,
                                                 @Query("type") String type,
                                                 @Query("gender") String gender);


}
