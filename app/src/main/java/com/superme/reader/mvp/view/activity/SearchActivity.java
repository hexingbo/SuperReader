package com.superme.reader.mvp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ljy.devring.util.KeyboardUtil;
import com.superme.reader.di.component.activity.DaggerSearchActivityComponent;
import com.superme.reader.di.module.activity.SearchActivityModule;
import com.superme.reader.mvp.model.entity.res.SearchBookInfoBean;
import com.superme.reader.mvp.view.activity.base.BaseActivity;

import com.superme.reader.mvp.view.adapter.SearchBookAdapter;
import com.superme.reader.mvp.view.iview.ISearchView;
import com.superme.reader.mvp.presenter.SearchPresenter;

import com.superme.reader.R;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;


public class SearchActivity extends BaseActivity<SearchPresenter> implements ISearchView ,TextView.OnEditorActionListener{

    @BindView(R.id.searchBookList)
    RecyclerView mSearchBookList;
    @BindView(R.id.etSearch)
    EditText etSearch;
    @BindView(R.id.ivClear)
    ImageView ivClear;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    @Inject
    SearchBookAdapter mAdapter;
    @Inject
    List<SearchBookInfoBean> mData;

    public static Intent getSearchIntent(Context context, String bookName) {
        Intent intent = new Intent(context, SearchActivity.class);
        intent.putExtra("bookName", bookName);
        return intent;
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView(Bundle bundle) {
        DaggerSearchActivityComponent.builder().searchActivityModule(new SearchActivityModule(this)).build().inject(this);
        mSearchBookList.setLayoutManager(new LinearLayoutManager(this));
        mSearchBookList.setAdapter(mAdapter);
    }

    @Override
    protected void initData(Bundle bundle) {
        String bookName = getIntent().getStringExtra("bookName");
        if (!TextUtils.isEmpty(bookName)) {
            etSearch.setText(bookName);
            onSearch(null);
        }
    }

    @Override
    protected void initEvent() {
        //添加搜索按钮监听
        etSearch.setOnEditorActionListener(this);
        etSearch.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(s)) {
                    ivClear.setVisibility(View.INVISIBLE);
                } else {
                    ivClear.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        /*判断是否是“搜索”键*/
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            // 隐藏键盘
            KeyboardUtil.hideKeyboard(SearchActivity.this, etSearch);
            //让EditText失去焦点
            etSearch.setFocusable(false);
            etSearch.setFocusableInTouchMode(true);
            onSearch(null);
            return true;
        }
        return false;
    }



    @OnClick(R.id.ivReturn)
    public void onReturn(View view) {
        finish();
    }

    @OnClick(R.id.ivSearch)
    public void onSearch(View view) {
        //让EditText失去焦点
        KeyboardUtil.hideKeyboard(SearchActivity.this, etSearch);
        etSearch.setFocusable(false);
        etSearch.setFocusableInTouchMode(true);
        actionSearch();
    }

    private void actionSearch() {
        String word = etSearch.getText().toString();
        if (!TextUtils.isEmpty(word)) {
            setRotateLoading(true);
            mPresenter.getSearchBook(word);
        }
    }

    @OnClick(R.id.ivClear)
    public void onClear(View view) {
        etSearch.setText("");
    }

    public void setRotateLoading(boolean isShow) {
        if (isShow) {
            mProgressBar.setVisibility(View.VISIBLE);
        } else {
            mProgressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public SearchBookAdapter getSearchBookAdapter() {
        return mAdapter;
    }

    @Override
    public void getDataFinish() {
        setRotateLoading(false);
    }
}
