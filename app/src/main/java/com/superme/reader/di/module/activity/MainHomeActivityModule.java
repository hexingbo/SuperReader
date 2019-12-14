package com.superme.reader.di.module.activity;

import com.ljy.devring.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.superme.reader.mvp.presenter.MainHomePresenter;
import com.superme.reader.mvp.view.iview.IMainHomeView;
import com.superme.reader.mvp.model.imodel.IMainHomeModel;
import com.superme.reader.mvp.model.MainHomeModel;


@Module
public class MainHomeActivityModule {
    private IMainHomeView mIView;

    public MainHomeActivityModule(IMainHomeView iView) {
        mIView = iView;
    }

    @ActivityScope
    @Provides
    IMainHomeView iMainHomeView() {
        return mIView;
    }

    @ActivityScope
    @Provides
    IMainHomeModel iMainHomeModel() {
        return new MainHomeModel();
    }

    @ActivityScope
    @Provides
    MainHomePresenter provideMainHomePresenter(IMainHomeView iView, IMainHomeModel iModel) {
        return new MainHomePresenter(iView, iModel);
    }
}