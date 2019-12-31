package com.superme.reader.mvp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.glong.reader.TurnStatus;
import com.glong.reader.widget.PageChangedCallback;
import com.glong.reader.widget.ReaderView;
import com.ljy.devring.DevRing;
import com.superme.reader.R;
import com.superme.reader.di.component.activity.DaggerReadBookActivityComponent;
import com.superme.reader.di.module.activity.ReadBookActivityModule;
import com.superme.reader.mvp.model.entity.read.ChapterContentBean;
import com.superme.reader.mvp.model.entity.read.ChapterItemBean;
import com.superme.reader.mvp.model.entity.res.SearchBookInfoBean;
import com.superme.reader.mvp.presenter.ReadBookPresenter;
import com.superme.reader.mvp.view.activity.base.BaseActivity;
import com.superme.reader.mvp.view.iview.IReadBookView;

import butterknife.BindView;


public class ReadBookActivity extends BaseActivity<ReadBookPresenter> implements IReadBookView {

    @BindView(R.id.simple_reader_view)
    ReaderView readerView;

    private ReaderView.Adapter<ChapterItemBean, ChapterContentBean> mAdapter;
    private SearchBookInfoBean bookInfoBean;


    public static Intent getBookInfoBean(Context context, SearchBookInfoBean bean) {
        Intent intent = new Intent(context, ReadBookActivity.class);
        intent.putExtra("BookInfoBean", bean);
        return intent;
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_read_book;
    }

    @Override
    protected void initView(Bundle bundle) {

        DaggerReadBookActivityComponent.builder().readBookActivityModule(new ReadBookActivityModule(this)).build().inject(this);
        ReaderView.ReaderManager readerManager = new ReaderView.ReaderManager();
        readerView.setReaderManager(readerManager);
        readerView.setTextSize(56);
    }

    @Override
    protected void initData(Bundle bundle) {
        bookInfoBean = (SearchBookInfoBean) getIntent().getSerializableExtra("BookInfoBean");
        if (bookInfoBean != null) {
            mAdapter = new ReaderView.Adapter<ChapterItemBean, ChapterContentBean>() {

                @Override
                public String obtainCacheKey(ChapterItemBean chapterItemBean) {
                    return chapterItemBean.getChapterId();
                }

                @Override
                public String obtainChapterName(ChapterItemBean chapterItemBean) {
                    return chapterItemBean.getChapterName();
                }

                @Override
                public String obtainChapterContent(ChapterContentBean contentBean) {
                    if (TextUtils.isEmpty(contentBean.getChapterContent())) {
                        mPresenter.getBookChapterContent(contentBean.getChapterId());
                    }
                    return contentBean.getChapterContent();
                }

                /**
                 * 这个方法运行在子线程中，同步返回章节内容
                 */
                @Override
                public ChapterContentBean downLoad(ChapterItemBean chapterItemBean) {
                    return mPresenter.syncDownloadContent(chapterItemBean);
                }
            };
            readerView.setAdapter(mAdapter);

            mPresenter.getBookChapterList(bookInfoBean.getId());
        }

    }

    @Override
    protected void initEvent() {

    }


    @Override
    public ReaderView.Adapter<ChapterItemBean, ChapterContentBean> getAdapter() {
        return mAdapter;
    }
}
