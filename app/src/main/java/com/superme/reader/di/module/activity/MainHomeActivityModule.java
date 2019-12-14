package com.superme.reader.di.module.activity;

import com.ljy.devring.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.superme.reader.app.constant.FragmentTag;
import com.superme.reader.mvp.presenter.CategoryPresenter;
import com.superme.reader.mvp.presenter.MainHomePresenter;
import com.superme.reader.mvp.view.fragment.BookcaseFragment;
import com.superme.reader.mvp.view.fragment.CategoryFragment;
import com.superme.reader.mvp.view.fragment.HotListFragment;
import com.superme.reader.mvp.view.iview.IMainHomeView;
import com.superme.reader.mvp.model.imodel.IMainHomeModel;
import com.superme.reader.mvp.model.MainHomeModel;

import javax.inject.Named;


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

    @ActivityScope
    @Provides
    @Named(FragmentTag.BookcaseFragmentTag)
    BookcaseFragment provideBookcaseFragment() {
        return new BookcaseFragment();
    }

    @ActivityScope
    @Provides
    @Named(FragmentTag.CategoryFragmentTag)
    CategoryFragment provideCategoryFragment() {
        return new CategoryFragment();
    }

    @ActivityScope
    @Provides
    @Named(FragmentTag.HotListFragmentTag)
    HotListFragment provideHotListFragment() {
        return new HotListFragment();
    }

}