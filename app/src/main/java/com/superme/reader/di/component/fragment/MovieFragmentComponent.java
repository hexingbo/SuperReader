package com.superme.reader.di.component.fragment;

import com.superme.reader.di.module.fragment.MovieFragmentModule;
import com.superme.reader.mvp.view.fragment.MovieFragment;
import com.ljy.devring.di.scope.FragmentScope;

import dagger.Component;

/**
 * author:  ljy
 * date:    2018/3/21
 * description: MovieFragment的Component
 */
@FragmentScope
@Component(modules = MovieFragmentModule.class)
public interface MovieFragmentComponent {
    void inject(MovieFragment movieFragment);
}
