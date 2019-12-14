package com.superme.reader.mvp.model.imodel;

import com.ljy.devring.base.imodel.IBaseModel;
import com.superme.reader.mvp.model.entity.res.ZhuiShuSearcheBean;

import io.reactivex.Observable;


public interface ISearchModel extends IBaseModel {

    Observable<ZhuiShuSearcheBean> getSearchBook(String word);

}
