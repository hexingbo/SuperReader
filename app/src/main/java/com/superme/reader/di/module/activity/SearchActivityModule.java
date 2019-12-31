package com.superme.reader.di.module.activity;

import android.view.View;

import com.ljy.devring.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.superme.reader.mvp.model.entity.res.SearchBookInfoBean;
import com.superme.reader.mvp.presenter.SearchPresenter;
import com.superme.reader.mvp.view.activity.ReadBookActivity;
import com.superme.reader.mvp.view.activity.SearchActivity;
import com.superme.reader.mvp.view.adapter.SearchBookAdapter;
import com.superme.reader.mvp.view.adapter.base.OnItemBaseListener;
import com.superme.reader.mvp.view.iview.ISearchView;
import com.superme.reader.mvp.model.imodel.ISearchModel;
import com.superme.reader.mvp.model.SearchModel;

import java.util.ArrayList;
import java.util.List;


@Module
public class SearchActivityModule {
    private ISearchView mIView;

    public SearchActivityModule(ISearchView iView) {
        mIView = iView;
    }

    @ActivityScope
    @Provides
    ISearchView iSearchView() {
        return mIView;
    }

    @ActivityScope
    @Provides
    ISearchModel iSearchModel() {
        return new SearchModel();
    }

    @ActivityScope
    @Provides
    SearchPresenter provideSearchPresenter(ISearchView iView, ISearchModel iModel) {
        return new SearchPresenter(iView, iModel);
    }

    @ActivityScope
    @Provides
    List<SearchBookInfoBean> provideSearchBookList() {
        return new ArrayList<>();
    }

    @ActivityScope
    @Provides
    SearchBookAdapter provideSearchBookAdapter(List<SearchBookInfoBean> mDataList) {
        return new SearchBookAdapter(mDataList);
    }
}