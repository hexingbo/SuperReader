package com.superme.reader.mvp.model.imodel;

import com.ljy.devring.base.imodel.IBaseModel;
import com.superme.reader.mvp.model.entity.res.BookChapterContentResult;
import com.superme.reader.mvp.model.entity.res.BookChapterResult;

import io.reactivex.Observable;


public interface IReadBookModel extends IBaseModel {

    Observable<BookChapterResult> getBookChapterList(String url);

    Observable<BookChapterContentResult> getBookChapterContent(String url);
}
