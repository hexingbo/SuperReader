package com.superme.reader.mvp.model.imodel;

import com.ljy.devring.base.imodel.IBaseModel;
import com.superme.reader.mvp.model.entity.res.CategoryBean;
import com.superme.reader.mvp.model.entity.res.CategoryBookItemBean;

import io.reactivex.Observable;

public interface ICategoryModel extends IBaseModel {

    Observable<CategoryBean> getCategory();

    Observable<CategoryBookItemBean> getCategoryBookItem(int start,
                                                         String limit,
                                                         String major,
                                                         String minor,
                                                         String type,
                                                         String gender);

}
