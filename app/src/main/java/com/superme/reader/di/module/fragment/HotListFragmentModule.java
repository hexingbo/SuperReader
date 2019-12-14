package com.superme.reader.di.module.fragment;

import com.ljy.devring.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

import com.superme.reader.mvp.presenter.HotListPresenter;
import com.superme.reader.mvp.view.iview.IHotListView;
import com.superme.reader.mvp.model.imodel.IHotListModel;
import com.superme.reader.mvp.model.HotListModel;


@Module
public class HotListFragmentModule {
    private IHotListView mIView;

    public HotListFragmentModule(IHotListView iView) {
        mIView = iView;
    }

    @FragmentScope
    @Provides
    IHotListView iHotListView() {
        return mIView;
    }

    @FragmentScope
    @Provides
    IHotListModel iHotListModel() {
        return new HotListModel();
    }

    @FragmentScope
    @Provides
    HotListPresenter provideHotListPresenter(IHotListView iView, IHotListModel iModel) {
        return new HotListPresenter(iView, iModel);
    }
}