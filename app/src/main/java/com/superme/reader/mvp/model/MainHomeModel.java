package com.superme.reader.mvp.model;

import com.superme.reader.mvp.model.entity.res.HomeResBean;
import com.superme.reader.mvp.model.http.BookApiService;
import com.superme.reader.mvp.model.imodel.IMainHomeModel;
import com.ljy.devring.DevRing;

import io.reactivex.Observable;

public class MainHomeModel implements IMainHomeModel {


    @Override
    public Observable<HomeResBean> getHomeDataList() {
       return null;
    }
}