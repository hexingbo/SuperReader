package com.superme.reader.mvp.presenter;

import com.ljy.devring.base.presenter.BasePresenter;
import com.ljy.devring.http.support.observer.CommonObserver;
import com.ljy.devring.http.support.throwable.HttpThrowable;
import com.ljy.devring.util.RingToast;
import com.superme.reader.mvp.model.entity.res.SearchBookInfoBean;
import com.superme.reader.mvp.model.entity.res.SearcheBookResult;
import com.superme.reader.mvp.model.imodel.ISearchModel;
import com.superme.reader.mvp.view.iview.ISearchView;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SearchPresenter extends BasePresenter<ISearchView, ISearchModel> {

    public SearchPresenter(ISearchView iView, ISearchModel iModel) {
        super(iView, iModel);
    }


    public void getSearchBook(String word) {
        mIModel.getSearchBook(word)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CommonObserver<SearcheBookResult>() {

                    @Override
                    public void onResult(SearcheBookResult result) {
                        ArrayList<SearchBookInfoBean> searchBookInfoBeans = new ArrayList<>();
                        //把追书的结果转换成 SearchBookInfoBean
                        SearchBookInfoBean zhuishuBookInfoBean;
                        for (SearcheBookResult.ListBean bean : result.getList()) {
                            zhuishuBookInfoBean = new SearchBookInfoBean();
                            zhuishuBookInfoBean.setBookName(bean.getName());
                            zhuishuBookInfoBean.setImg(bean.getCover());
                            zhuishuBookInfoBean.setAuthor(bean.getAuthor());
                            zhuishuBookInfoBean.setIntro(bean.getIntroduce());
                            zhuishuBookInfoBean.setId(bean.getUrl());
                            zhuishuBookInfoBean.setType(bean.getTag());
                            zhuishuBookInfoBean.setTag("ZS");
                            zhuishuBookInfoBean.setZhuiShu(true);
                            searchBookInfoBeans.add(zhuishuBookInfoBean);
                        }
                        mIView.getSearchBookAdapter().replaceData(searchBookInfoBeans);
                        mIView.getDataFinish();
                    }

                    @Override
                    public void onError(HttpThrowable httpThrowable) {
                        RingToast.show(httpThrowable.message);
                        mIView.getDataFinish();
                    }
                });

    }
}
