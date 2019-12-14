package com.superme.reader.mvp.presenter;

import com.ljy.devring.base.presenter.BasePresenter;
import com.superme.reader.mvp.view.iview.IMainHomeView;
import com.superme.reader.mvp.model.imodel.IMainHomeModel;

public class MainHomePresenter extends BasePresenter<IMainHomeView, IMainHomeModel> {

    public MainHomePresenter(IMainHomeView iView, IMainHomeModel iModel) {
        super(iView, iModel);
    }


}
