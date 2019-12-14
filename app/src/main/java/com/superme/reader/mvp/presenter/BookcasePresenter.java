package com.superme.reader.mvp.presenter;

import com.ljy.devring.base.presenter.BasePresenter;
import com.superme.reader.mvp.view.iview.IBookcaseView;
import com.superme.reader.mvp.model.imodel.IBookcaseModel;

public class BookcasePresenter extends BasePresenter<IBookcaseView, IBookcaseModel> {

    public BookcasePresenter(IBookcaseView iView, IBookcaseModel iModel) {
        super(iView, iModel);
    }


}
