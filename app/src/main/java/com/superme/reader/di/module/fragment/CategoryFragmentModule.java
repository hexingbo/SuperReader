package com.superme.reader.di.module.fragment;

import com.ljy.devring.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

import com.superme.reader.mvp.presenter.CategoryPresenter;
import com.superme.reader.mvp.view.iview.ICategoryView;
import com.superme.reader.mvp.model.imodel.ICategoryModel;
import com.superme.reader.mvp.model.CategoryModel;


@Module
public class CategoryFragmentModule {
    private ICategoryView mIView;

    public CategoryFragmentModule(ICategoryView iView) {
        mIView = iView;
    }

    @FragmentScope
    @Provides
    ICategoryView iCategoryView() {
        return mIView;
    }

    @FragmentScope
    @Provides
    ICategoryModel iCategoryModel() {
        return new CategoryModel();
    }

    @FragmentScope
    @Provides
    CategoryPresenter provideCategoryPresenter(ICategoryView iView, ICategoryModel iModel) {
        return new CategoryPresenter(iView, iModel);
    }
}