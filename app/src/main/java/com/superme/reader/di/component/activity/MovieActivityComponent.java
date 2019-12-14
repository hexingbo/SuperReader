package com.superme.reader.di.component.activity;

import com.superme.reader.di.module.activity.MovieActivityModule;
import com.superme.reader.mvp.view.activity.MovieActivity;
import com.ljy.devring.di.scope.ActivityScope;

import dagger.Component;

/**
 * author:  ljy
 * date:    2018/3/21
 * description: MovieActivity的Component
 */
@ActivityScope
@Component(modules = MovieActivityModule.class)
public interface MovieActivityComponent {
    void inject(MovieActivity movieActivity);
}
