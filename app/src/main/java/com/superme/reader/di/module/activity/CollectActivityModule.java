package com.superme.reader.di.module.activity;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;

import com.superme.reader.mvp.model.CollectModel;
import com.superme.reader.mvp.model.imodel.ICollectModel;
import com.superme.reader.mvp.presenter.CollectPresenter;
import com.superme.reader.mvp.view.iview.ICollectView;
import com.ljy.devring.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * author:  ljy
 * date:    2018/3/21
 * description: 对CollectActivity中的相关变量进行初始化
 */
@Module
public class CollectActivityModule {

    private ICollectView mICollectView;
    private Context mContext;

    public CollectActivityModule(ICollectView iCollectView, Context context) {
        mContext = context;
        mICollectView = iCollectView;
    }

    @Provides
    @ActivityScope
    Context context() {
        return mContext;
    }

    @Provides
    @ActivityScope
    ICollectView iCollectView() {
        return mICollectView;
    }

    @Provides
    @ActivityScope
    ICollectModel iCollectModel() {
        return new CollectModel();
    }

    @Provides
    @ActivityScope
    CollectPresenter collectPresenter(ICollectView iCollectView, ICollectModel iCollectModel) {
        return new CollectPresenter(iCollectView, iCollectModel);
    }

    @Provides
    @ActivityScope
    GridLayoutManager gridLayoutManager(Context context) {
        return new GridLayoutManager(context, 2);
    }
}
