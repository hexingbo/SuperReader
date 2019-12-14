package com.superme.reader.mvp.model;

import com.ljy.devring.DevRing;
import com.superme.reader.mvp.model.entity.res.CategoryBean;
import com.superme.reader.mvp.model.http.BookApiService;
import com.superme.reader.mvp.model.imodel.ICategoryModel;

import io.reactivex.Observable;

public class CategoryModel implements ICategoryModel {

    @Override
    public Observable<CategoryBean> getCategory() {
        return DevRing.httpManager().getService(BookApiService.class).getCategory();
    }
}