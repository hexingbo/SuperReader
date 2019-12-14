package com.superme.reader.mvp.model;

import com.ljy.devring.DevRing;
import com.superme.reader.mvp.model.entity.res.ZhuiShuSearcheBean;
import com.superme.reader.mvp.model.http.BookApiService;
import com.superme.reader.mvp.model.imodel.ISearchModel;

import io.reactivex.Observable;

public class SearchModel implements ISearchModel {


    @Override
    public Observable<ZhuiShuSearcheBean> getSearchBook(String word) {
        return DevRing.httpManager().getService(BookApiService.class).getSearchBook(word);
    }
}