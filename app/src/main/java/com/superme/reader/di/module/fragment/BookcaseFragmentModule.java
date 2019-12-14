package com.superme.reader.di.module.fragment;

import com.ljy.devring.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

import com.superme.reader.mvp.presenter.BookcasePresenter;
import com.superme.reader.mvp.view.iview.IBookcaseView;
import com.superme.reader.mvp.model.imodel.IBookcaseModel;
import com.superme.reader.mvp.model.BookcaseModel;


@Module
public class BookcaseFragmentModule {
    private IBookcaseView mIView;

    public BookcaseFragmentModule(IBookcaseView iView) {
        mIView = iView;
    }

    @FragmentScope
    @Provides
    IBookcaseView iBookcaseView() {
        return mIView;
    }

    @FragmentScope
    @Provides
    IBookcaseModel iBookcaseModel() {
        return new BookcaseModel();
    }

    @FragmentScope
    @Provides
    BookcasePresenter provideBookcasePresenter(IBookcaseView iView, IBookcaseModel iModel) {
        return new BookcasePresenter(iView, iModel);
    }
}