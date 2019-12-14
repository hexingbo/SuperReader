package com.superme.reader.di.component.activity;

import com.superme.reader.di.module.activity.MainHomeActivityModule;
import com.ljy.devring.di.scope.ActivityScope;

import dagger.Component;


import com.superme.reader.mvp.view.activity.MainHomeActivity;


@ActivityScope
@Component(modules = MainHomeActivityModule.class)
public interface MainHomeActivityComponent {
    void inject(MainHomeActivity activity);
}