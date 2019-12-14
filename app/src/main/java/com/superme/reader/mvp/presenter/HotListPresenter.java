package com.superme.reader.mvp.presenter;

import com.ljy.devring.base.presenter.BasePresenter;
import com.superme.reader.mvp.view.iview.IHotListView;
import com.superme.reader.mvp.model.imodel.IHotListModel;

public class HotListPresenter extends BasePresenter<IHotListView, IHotListModel> {

    public HotListPresenter(IHotListView iView, IHotListModel iModel) {
        super(iView, iModel);
    }


}
