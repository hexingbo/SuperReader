package com.superme.reader.di.component.activity;

import com.ljy.devring.di.scope.ActivityScope;

import dagger.Component;

import com.superme.reader.di.module.activity.SearchActivityModule;

import com.superme.reader.mvp.view.activity.SearchActivity;


@ActivityScope
@Component(modules = SearchActivityModule.class)
public interface SearchActivityComponent {
    void inject(SearchActivity activity);
}