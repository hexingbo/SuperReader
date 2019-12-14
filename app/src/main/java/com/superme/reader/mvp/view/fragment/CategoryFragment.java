package com.superme.reader.mvp.view.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.superme.reader.R;
import com.superme.reader.di.component.fragment.DaggerCategoryFragmentComponent;
import com.superme.reader.di.module.fragment.CategoryFragmentModule;
import com.superme.reader.mvp.model.entity.res.CategoryBookItemBean;
import com.superme.reader.mvp.model.entity.res.CategoryItemBean;
import com.superme.reader.mvp.presenter.CategoryPresenter;
import com.superme.reader.mvp.view.adapter.CategoryBookAdapter;
import com.superme.reader.mvp.view.adapter.CategoryLeftAdapter;
import com.superme.reader.mvp.view.adapter.base.OnItemBaseListener;
import com.superme.reader.mvp.view.fragment.base.BaseFragment;
import com.superme.reader.mvp.view.iview.ICategoryView;
import com.superme.reader.util.LayoutManagerUtil;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;


public class CategoryFragment extends BaseFragment<CategoryPresenter> implements ICategoryView {

    @BindView(R.id.category_item)
    RecyclerView categoryLeftItem;
    @BindView(R.id.category_book)
    RecyclerView categoryRightItem;
    @BindView(R.id.refreshLayout)
    TwinklingRefreshLayout mRefreshLayout;

    @Inject
    CategoryBookAdapter mBookAdapter;
    @Inject
    CategoryLeftAdapter mCategoryLeftAdapter;
    @Inject
    List<CategoryItemBean> mCategoryItemList;
    @Inject
    List<CategoryBookItemBean.BooksBean> mBooksList;

    @Override
    protected boolean isLazyLoad() {
        return true;
    }

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_category;
    }

    @Override
    protected void initView() {
        DaggerCategoryFragmentComponent.builder()
                .categoryFragmentModule(new CategoryFragmentModule(this))
                .build().inject(this);

        categoryLeftItem.setLayoutManager(LayoutManagerUtil.getLinearLayoutManager_VERTICAL(getActivity()));
        categoryLeftItem.setAdapter(mCategoryLeftAdapter);

        categoryRightItem.setLayoutManager(LayoutManagerUtil.getLinearLayoutManager_VERTICAL(getActivity()));
        categoryRightItem.setAdapter(mBookAdapter);
        //不需要下拉刷新
        mRefreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
            }

            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {

            }
        });

    }

    @Override
    protected void initData() {
        mPresenter.getCategory();
    }

    @Override
    protected void initEvent() {

    }

    @Override
    public OnItemBaseListener getItemClickListener() {
        return new OnItemBaseListener() {
            @Override
            public void onItemClick(int position, Object bean, View view) {

            }
        };
    }

    @Override
    public CategoryLeftAdapter getCategoryLeftAdapter() {
        return mCategoryLeftAdapter;
    }

    @Override
    public CategoryBookAdapter getCategoryBookAdapter() {
        return mBookAdapter;
    }

    @Override
    public List<CategoryItemBean> getCategoryItemList() {
        return mCategoryItemList;
    }

    @Override
    public List<CategoryBookItemBean.BooksBean> getBooksLsit() {
        return mBooksList;
    }
}
