package com.dev.base.mvp.view.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.dev.base.di.component.activity.DaggerMainHomeActivityComponent;
import com.dev.base.di.module.activity.MainHomeActivityModule;
import com.dev.base.mvp.view.activity.base.BaseActivity;

import com.dev.base.mvp.view.iview.IMainHomeView;
import com.dev.base.mvp.presenter.MainHomePresenter;

import com.dev.base.R;
import com.dev.base.mvp.view.widget.loadlayout.LoadLayout;

import butterknife.BindString;
import butterknife.BindView;


public class MainHomeActivity extends BaseActivity<MainHomePresenter> implements IMainHomeView {

    @BindView(R.id.ll_collect)
    LoadLayout mLoadLayout;//加载布局，可以显示各种状态的布局, 如加载中，加载成功, 加载失败, 无数据
    @BindView(R.id.base_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rv_collect)
    RecyclerView mRvCollect;
    @BindString(R.string.hxb_book)
    String mStrTitle;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_main_home;
    }

    @Override
    protected void initView(Bundle bundle) {
        DaggerMainHomeActivityComponent.builder()
                .mainHomeActivityModule(new MainHomeActivityModule(this))
                .build()
                .inject(this);

        //如果调用了setSupportActionBar，那就必须在setSupportActionBar之前将标题置为空字符串，否则设置具体标题会无效
        mToolbar.setTitle("");
        this.setSupportActionBar(mToolbar);
        mToolbar.setTitle(mStrTitle);
    }

    @Override
    protected void initData(Bundle bundle) {

    }

    @Override
    protected void initEvent() {

    }

}
