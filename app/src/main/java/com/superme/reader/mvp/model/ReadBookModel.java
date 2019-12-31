package com.superme.reader.mvp.model;

import com.ljy.devring.DevRing;
import com.superme.reader.mvp.model.entity.res.BookChapterContentResult;
import com.superme.reader.mvp.model.entity.res.BookChapterResult;
import com.superme.reader.mvp.model.http.BookApiService;
import com.superme.reader.mvp.model.imodel.IReadBookModel;

import io.reactivex.Observable;

public class ReadBookModel implements IReadBookModel {


    @Override
    public Observable<BookChapterResult> getBookChapterList(String url) {
        return DevRing.httpManager().getService(BookApiService.class).getBookChapterList(url);
    }

    @Override
    public Observable<BookChapterContentResult> getBookChapterContent(String url) {
        return DevRing.httpManager().getService(BookApiService.class).getBookChapterContent(url);
    }
}