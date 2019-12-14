package com.dev.base.di.component.activity;

import com.dev.base.di.module.activity.MainHomeActivityModule;
import com.ljy.devring.di.scope.ActivityScope;

import dagger.Component;


import com.dev.base.mvp.view.activity.MainHomeActivity;


@ActivityScope
@Component(modules = MainHomeActivityModule.class)
public interface MainHomeActivityComponent {
    void inject(MainHomeActivity activity);
}