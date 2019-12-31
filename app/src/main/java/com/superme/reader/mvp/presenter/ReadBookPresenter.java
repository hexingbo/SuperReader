package com.superme.reader.mvp.presenter;

import android.util.Log;

import com.ljy.devring.base.presenter.BasePresenter;
import com.ljy.devring.http.support.observer.CommonObserver;
import com.ljy.devring.http.support.throwable.HttpThrowable;
import com.ljy.devring.util.RingToast;
import com.superme.reader.mvp.model.entity.read.ChapterContentBean;
import com.superme.reader.mvp.model.entity.read.ChapterItemBean;
import com.superme.reader.mvp.model.entity.res.BookChapterContentResult;
import com.superme.reader.mvp.model.entity.res.BookChapterResult;
import com.superme.reader.mvp.model.imodel.IReadBookModel;
import com.superme.reader.mvp.view.iview.IReadBookView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ReadBookPresenter extends BasePresenter<IReadBookView, IReadBookModel> {

    private List<ChapterItemBean> chapters;

    public ReadBookPresenter(IReadBookView iView, IReadBookModel iModel) {
        super(iView, iModel);
    }


    public void getBookChapterList(String url) {
        mIModel.getBookChapterList(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CommonObserver<BookChapterResult>() {

                    @Override
                    public void onResult(BookChapterResult result) {
                        BookChapterResult.DataBean data = result.getData();
                        List<BookChapterResult.ListBean> list = result.getList();
                        chapters = new ArrayList<>();

                        for (BookChapterResult.ListBean bean : list) {
                            ChapterItemBean chapterItemBean = new ChapterItemBean();
                            chapterItemBean.setChapterId(bean.getUrl());
                            chapterItemBean.setChapterName(bean.getNum() + " " + data.getName());
                            chapters.add(chapterItemBean);
                        }
                        getBookChapterContent(chapters.get(0).getChapterId());

                    }

                    @Override
                    public void onError(HttpThrowable httpThrowable) {
                        RingToast.show(httpThrowable.message);
                    }
                });

    }

    Map<String, String> mapContent = new HashMap<>();

    public void getBookChapterContent(String url) {
        mIModel.getBookChapterContent(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CommonObserver<BookChapterContentResult>() {

                    /**
                     * @param result
                     */
                    @Override
                    public void onResult(BookChapterContentResult result) {
                        StringBuilder contentBuilder = new StringBuilder();
                        for (int i = 0; i < result.getContent().size(); i++) {
                            String str2 = result.getContent().get(i).replaceAll("\\s*", "");
                            if (i == 0) {
                                contentBuilder.append("\u3000\u3000" + str2 + "\n\u3000");
                            } else {
                                if (str2.length() <= 14) {
                                    contentBuilder.append("\u3000" + str2 + "\n\u3000");
                                } else
                                    contentBuilder.append("\u3000\u3000" + str2 + "\n\u3000");
                            }
                        }
                        mapContent.put(url, contentBuilder.toString());
                        mIView.getAdapter().setChapterList(chapters);
                        mIView.getAdapter().notifyDataSetChanged();

                    }

                    @Override
                    public void onError(HttpThrowable httpThrowable) {
                        RingToast.show(httpThrowable.message);
                    }
                });
    }

    /**
     * 模拟网络同步下载
     *
     * @return 章节内容
     */
    public ChapterContentBean syncDownloadContent(ChapterItemBean chapterItemBean) {
        ChapterContentBean chapterContentBean = new ChapterContentBean();
        chapterContentBean.setChapterId(chapterItemBean.getChapterId());
        chapterContentBean.setChapterName(chapterItemBean.getChapterName());
        StringBuilder contentBuilder = new StringBuilder();
        if (mapContent.containsKey(chapterItemBean.getChapterId())) {
            contentBuilder.append(mapContent.get(chapterItemBean.getChapterId()));
            chapterContentBean.setChapterContent(contentBuilder.toString());
        } else {
            chapterContentBean.setChapterContent("");
        }

        return chapterContentBean;

    }

}
