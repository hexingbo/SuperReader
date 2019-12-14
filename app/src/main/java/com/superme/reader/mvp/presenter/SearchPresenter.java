package com.superme.reader.mvp.presenter;

import com.ljy.devring.base.presenter.BasePresenter;
import com.ljy.devring.http.support.observer.CommonObserver;
import com.ljy.devring.http.support.throwable.HttpThrowable;
import com.ljy.devring.util.RingToast;
import com.superme.reader.mvp.model.entity.res.SearchBookInfoBean;
import com.superme.reader.mvp.model.entity.res.ZhuiShuSearcheBean;
import com.superme.reader.mvp.model.imodel.ISearchModel;
import com.superme.reader.mvp.view.iview.ISearchView;

import java.net.URLDecoder;
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
                .subscribe(new CommonObserver<ZhuiShuSearcheBean>() {

                    @Override
                    public void onResult(ZhuiShuSearcheBean result) {
                        ArrayList<SearchBookInfoBean> searchBookInfoBeans = new ArrayList<>();
                        //把追书的结果转换成 SearchBookInfoBean
                        SearchBookInfoBean zhuishuBookInfoBean;
                        for (ZhuiShuSearcheBean.BooksBean bean : result.getBooks()) {
                            zhuishuBookInfoBean = new SearchBookInfoBean();
                            zhuishuBookInfoBean.setBookName(bean.getTitle());
                            zhuishuBookInfoBean.setImg(URLDecoder.decode(bean.getCover()).replace("/agent/", ""));
                            zhuishuBookInfoBean.setAuthor(bean.getAuthor());
                            zhuishuBookInfoBean.setIntro(bean.getShortIntro());
                            zhuishuBookInfoBean.setId(bean.get_id());
                            zhuishuBookInfoBean.setType(bean.getCat());
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
