package com.superme.reader.mvp.presenter;

import com.ljy.devring.base.presenter.BasePresenter;
import com.superme.reader.mvp.view.iview.ICategoryView;
import com.superme.reader.mvp.model.imodel.ICategoryModel;

public class CategoryPresenter extends BasePresenter<ICategoryView, ICategoryModel> {

    public CategoryPresenter(ICategoryView iView, ICategoryModel iModel) {
        super(iView, iModel);
    }


}
