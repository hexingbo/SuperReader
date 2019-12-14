package com.superme.reader.mvp.view.iview;

import com.ljy.devring.base.iview.IBaseView;
import com.superme.reader.mvp.model.entity.res.CategoryBookItemBean;
import com.superme.reader.mvp.model.entity.res.CategoryItemBean;
import com.superme.reader.mvp.view.adapter.CategoryBookAdapter;
import com.superme.reader.mvp.view.adapter.CategoryLeftAdapter;
import com.superme.reader.mvp.view.adapter.base.OnItemBaseListener;

import java.util.List;


public interface ICategoryView extends IBaseView {

    OnItemBaseListener getItemClickListener();

    CategoryLeftAdapter getCategoryLeftAdapter();

    CategoryBookAdapter getCategoryBookAdapter();

    List<CategoryItemBean> getCategoryItemList();

    List<CategoryBookItemBean.BooksBean> getBooksLsit();
}
