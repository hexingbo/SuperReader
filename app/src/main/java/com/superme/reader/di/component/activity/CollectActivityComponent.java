package com.superme.reader.di.component.activity;

import com.superme.reader.di.module.activity.CollectActivityModule;
import com.superme.reader.mvp.view.activity.CollectActivity;
import com.ljy.devring.di.scope.ActivityScope;

import dagger.Component;

/**
 * author:  ljy
 * date:    2018/3/21
 * description: CollectActivity的Component
 */
@ActivityScope
@Component(modules = CollectActivityModule.class)
public interface CollectActivityComponent {
    void inject(CollectActivity collectActivity);
}
