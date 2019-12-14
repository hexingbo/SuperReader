package com.superme.reader.mvp.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;

import com.superme.reader.mvp.view.fragment.base.BaseFragment;
import com.superme.reader.mvp.view.iview.ICategoryView;
import com.superme.reader.mvp.presenter.CategoryPresenter;
import com.superme.reader.R;


public class CategoryFragment extends BaseFragment<CategoryPresenter> implements ICategoryView {

    @Override
    protected boolean isLazyLoad() {
        return true;
    }

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_category;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }

}
