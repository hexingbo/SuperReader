package com.superme.reader.di.component.fragment;

import com.ljy.devring.di.scope.FragmentScope;

import dagger.Component;

import com.superme.reader.di.module.fragment.HotListFragmentModule;

import com.superme.reader.mvp.view.fragment.HotListFragment;


@FragmentScope
@Component(modules = HotListFragmentModule.class)
public interface HotListFragmentComponent {
    void inject(HotListFragment fragment);
}