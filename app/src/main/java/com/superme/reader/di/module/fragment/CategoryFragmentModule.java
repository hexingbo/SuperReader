package com.superme.reader.di.module.fragment;

import com.ljy.devring.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

import com.superme.reader.mvp.model.entity.res.CategoryBookItemBean;
import com.superme.reader.mvp.model.entity.res.CategoryItemBean;
import com.superme.reader.mvp.presenter.CategoryPresenter;
import com.superme.reader.mvp.view.adapter.CategoryBookAdapter;
import com.superme.reader.mvp.view.adapter.CategoryLeftAdapter;
import com.superme.reader.mvp.view.iview.ICategoryView;
import com.superme.reader.mvp.model.imodel.ICategoryModel;
import com.superme.reader.mvp.model.CategoryModel;

import java.util.ArrayList;
import java.util.List;


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
    static CategoryPresenter provideCategoryPresenter(ICategoryView iView, ICategoryModel iModel) {
        return new CategoryPresenter(iView, iModel);
    }

    @FragmentScope
    @Provides
    static  List<CategoryBookItemBean.BooksBean> provideBooksBeanList() {
        return new ArrayList<>();
    }

    @FragmentScope
    @Provides
    static   CategoryBookAdapter provideCategoryBookAdapter(List<CategoryBookItemBean.BooksBean> mDataList, ICategoryView iView) {
        CategoryBookAdapter adapter = new CategoryBookAdapter(mDataList);
        adapter.setItemClickListener(iView.getItemClickListener());
        return adapter;
    }

    @FragmentScope
    @Provides
    static  List<CategoryItemBean> provideCategoryItemList() {
        return new ArrayList<>();
    }

    @FragmentScope
    @Provides
    static  CategoryLeftAdapter provideCategoryLeftAdapter(List<CategoryItemBean> mDataList, ICategoryView iView) {
        CategoryLeftAdapter adapter = new CategoryLeftAdapter(mDataList);
        adapter.setItemClickListener(iView.getItemClickListener());
        return adapter;
    }
}