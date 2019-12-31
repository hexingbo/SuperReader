package com.superme.reader.mvp.model;

import com.ljy.devring.DevRing;
import com.superme.reader.mvp.model.entity.res.SearcheBookResult;
import com.superme.reader.mvp.model.http.BookApiService;
import com.superme.reader.mvp.model.imodel.ISearchModel;

import io.reactivex.Observable;

public class SearchModel implements ISearchModel {


    @Override
    public Observable<SearcheBookResult> getSearchBook(String word) {
        return DevRing.httpManager().getService(BookApiService.class).getSearchBook(word);
    }
}