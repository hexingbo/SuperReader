package com.superme.reader.mvp.model.imodel;

import com.superme.reader.mvp.model.entity.res.HomeResBean;
import com.ljy.devring.base.imodel.IBaseModel;

import io.reactivex.Observable;


public interface IMainHomeModel extends IBaseModel {

    Observable<HomeResBean> getHomeDataList();
}
