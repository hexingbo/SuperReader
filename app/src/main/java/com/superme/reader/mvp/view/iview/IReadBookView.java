package com.superme.reader.mvp.view.iview;

import com.glong.reader.widget.ReaderView;
import com.ljy.devring.base.iview.IBaseView;
import com.superme.reader.mvp.model.entity.read.ChapterContentBean;
import com.superme.reader.mvp.model.entity.read.ChapterItemBean;


public interface IReadBookView extends IBaseView {

    ReaderView.Adapter<ChapterItemBean, ChapterContentBean> getAdapter();

}
