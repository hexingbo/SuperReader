package com.dev.base.mvp.presenter;

import com.ljy.devring.base.presenter.BasePresenter;
import com.dev.base.mvp.view.iview.IMainHomeView;
import com.dev.base.mvp.model.imodel.IMainHomeModel;

public class MainHomePresenter extends BasePresenter<IMainHomeView, IMainHomeModel> {

    public MainHomePresenter(IMainHomeView iView, IMainHomeModel iModel) {
        super(iView, iModel);
    }


}
