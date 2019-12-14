package com.superme.reader.mvp.view.iview;

import com.ljy.devring.base.iview.IBaseView;
import com.superme.reader.mvp.view.adapter.SearchBookAdapter;


public interface ISearchView extends IBaseView {

    SearchBookAdapter getSearchBookAdapter();

    void getDataFinish();
}
