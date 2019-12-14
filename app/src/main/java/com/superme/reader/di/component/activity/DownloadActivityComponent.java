package com.superme.reader.di.component.activity;

import com.superme.reader.di.module.activity.DownloadActivityModule;
import com.superme.reader.mvp.view.activity.DownloadActivity;
import com.ljy.devring.di.scope.ActivityScope;

import dagger.Component;

/**
 * author:  ljy
 * date:    2018/3/23
 * description:  DownloadActivity的Component
 */
@ActivityScope
@Component(modules = DownloadActivityModule.class)
public interface DownloadActivityComponent {
    void inject(DownloadActivity downloadActivity);
}
