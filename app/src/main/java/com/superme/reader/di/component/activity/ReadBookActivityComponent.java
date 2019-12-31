package com.superme.reader.di.component.activity;

import com.ljy.devring.di.scope.ActivityScope;

import dagger.Component;

import com.superme.reader.di.module.activity.ReadBookActivityModule;

import com.superme.reader.mvp.view.activity.ReadBookActivity;


@ActivityScope
@Component(modules = ReadBookActivityModule.class)
public interface ReadBookActivityComponent {
    void inject(ReadBookActivity activity);
}