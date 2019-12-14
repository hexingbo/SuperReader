package com.superme.reader.di.component.fragment;

import com.ljy.devring.di.scope.FragmentScope;

import dagger.Component;

import com.superme.reader.di.module.fragment.CategoryFragmentModule;

import com.superme.reader.mvp.view.fragment.CategoryFragment;


@FragmentScope
@Component(modules = CategoryFragmentModule.class)
public interface CategoryFragmentComponent {
    void inject(CategoryFragment fragment);
}