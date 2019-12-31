package com.superme.reader.di.module.activity;

import com.ljy.devring.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.superme.reader.mvp.presenter.ReadBookPresenter;
import com.superme.reader.mvp.view.iview.IReadBookView;
import com.superme.reader.mvp.model.imodel.IReadBookModel;
import com.superme.reader.mvp.model.ReadBookModel;


@Module
public class ReadBookActivityModule {
    private IReadBookView mIView;

    public ReadBookActivityModule(IReadBookView iView) {
        mIView = iView;
    }

    @ActivityScope
    @Provides
    IReadBookView iReadBookView() {
        return mIView;
    }

    @ActivityScope
    @Provides
    IReadBookModel iReadBookModel() {
        return new ReadBookModel();
    }

    @ActivityScope
    @Provides
    ReadBookPresenter provideReadBookPresenter(IReadBookView iView, IReadBookModel iModel) {
        return new ReadBookPresenter(iView, iModel);
    }
}