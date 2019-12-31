package com.superme.reader.mvp.model.http;

import com.superme.reader.app.constant.UrlConstants;
import com.superme.reader.mvp.model.entity.res.BookChapterContentResult;
import com.superme.reader.mvp.model.entity.res.BookChapterResult;
import com.superme.reader.mvp.model.entity.res.CategoryBean;
import com.superme.reader.mvp.model.entity.res.CategoryBookItemBean;
import com.superme.reader.mvp.model.entity.res.SearcheBookResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * author:  ljy
 * date:    2017/9/14
 * description: retrofit的请求接口定义，用于豆瓣电影请求
 * <a>https://www.jianshu.com/p/092452f287db</a>
 */

public interface BookApiService {

    /**
     * 分类
     * @return
     */
    @GET(UrlConstants.Get_Book_Category)
    Observable<CategoryBean> getCategory();

    /**
     * 分类数据
     * @param start
     * @param limit
     * @param major
     * @param minor
     * @param type
     * @param gender
     * @return
     */
    @GET(UrlConstants.Get_Book_Category_Item)
    Observable<CategoryBookItemBean> getCategoryBookItem(@Query("start") int start,
                                                         @Query("limit") String limit,
                                                         @Query("major") String major,
                                                         @Query("minor") String minor,
                                                         @Query("type") String type,
                                                         @Query("gender") String gender);

    /**
     * 模糊搜索词列表
     * @param word
     * @return
     */
    @GET("http://api.pingcc.cn")
    Observable<SearcheBookResult> getSearchBook(@Query("xsname") String word);

    /**
     * 章节
     * @param url
     * @return
     */
    @GET("http://api.pingcc.cn")
    Observable<BookChapterResult> getBookChapterList(@Query("xsurl1") String url);

    /**
     * 章节内容详情
     * @param url
     * @return
     */
    @GET("http://api.pingcc.cn")
    Observable<BookChapterContentResult> getBookChapterContent(@Query("xsurl2") String url);

}
