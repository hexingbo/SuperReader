package com.superme.reader.di.component.fragment;

import com.ljy.devring.di.scope.FragmentScope;

import dagger.Component;

import com.superme.reader.di.module.fragment.BookcaseFragmentModule;

import com.superme.reader.mvp.view.fragment.BookcaseFragment;


@FragmentScope
@Component(modules = BookcaseFragmentModule.class)
public interface BookcaseFragmentComponent {
    void inject(BookcaseFragment fragment);
}