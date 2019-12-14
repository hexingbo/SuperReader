package com.dev.base.mvp.model;

import com.dev.base.mvp.model.entity.res.HomeResBean;
import com.dev.base.mvp.model.http.BookApiService;
import com.dev.base.mvp.model.imodel.IMainHomeModel;
import com.ljy.devring.DevRing;

import io.reactivex.Observable;

public class MainHomeModel implements IMainHomeModel {


    @Override
    public Observable<HomeResBean> getHomeDataList() {
        return DevRing.httpManager().getService(BookApiService.class).getHomeDataList();
    }
}