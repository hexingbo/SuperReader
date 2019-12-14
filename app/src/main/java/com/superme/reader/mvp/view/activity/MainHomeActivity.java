package com.superme.reader.mvp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.ljy.devring.DevRing;
import com.ljy.devring.image.support.LoadOption;
import com.ljy.devring.util.RingToast;
import com.superme.reader.R;
import com.superme.reader.app.constant.FragmentTag;
import com.superme.reader.di.component.activity.DaggerMainHomeActivityComponent;
import com.superme.reader.di.module.activity.MainHomeActivityModule;
import com.superme.reader.mvp.model.entity.event.CollectCountEvent;
import com.superme.reader.mvp.presenter.MainHomePresenter;
import com.superme.reader.mvp.view.activity.base.BaseActivity;
import com.superme.reader.mvp.view.fragment.BookcaseFragment;
import com.superme.reader.mvp.view.fragment.CategoryFragment;
import com.superme.reader.mvp.view.fragment.HotListFragment;
import com.superme.reader.mvp.view.fragment.base.BaseFragment;
import com.superme.reader.mvp.view.iview.IMainHomeView;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;


public class MainHomeActivity extends BaseActivity<MainHomePresenter> implements IMainHomeView {

    @BindView(R.id.base_drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.nv_menu)
    NavigationView mNavigationView;
    @BindView(R.id.base_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tl_movie)
    TabLayout mTlMovie;//顶部选项卡
    ImageView mIvAvatar;
    @BindString(R.string.tv_super_reader)
    String mStrTitle;
    @BindString(R.string.exit_confirm)
    String mStrExitConfirm;
    @BindString(R.string.book_case)
    String mStrPlaying;
    @BindString(R.string.category)
    String mStrComming;
    @BindString(R.string.hotlist)
    String mStrHotList;
    @BindColor(R.color.black_4d)
    int mColorBlack;
    @BindColor(R.color.colorPrimary)
    int mColorPrimary;

    @Inject
    @Named(FragmentTag.BookcaseFragmentTag)
    BookcaseFragment mBookcaseFragment;
    @Inject
    @Named(FragmentTag.CategoryFragmentTag)
    CategoryFragment mCategoryFragment;
    @Inject
    @Named(FragmentTag.HotListFragmentTag)
    HotListFragment mHotListFragment;


    private BaseFragment mCurrentFragment;//当前展示的Fragment
    private long mExitTime;
    private int mCurrentIndex;//记录当前显示的fragment索引，用于配置变化重建后恢复页面


    @Override
    protected int getContentLayout() {
        return R.layout.activity_main_home;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        DaggerMainHomeActivityComponent.builder()
                .mainHomeActivityModule(new MainHomeActivityModule(this))
                .build()
                .inject(this);

        //如果经过了配置变化而重建(如横竖屏切换)，则不使用新建的Fragment。
        if (savedInstanceState != null) {
            BookcaseFragment oldBookcaseFragment = (BookcaseFragment) getSupportFragmentManager().findFragmentByTag(FragmentTag.BookcaseFragmentTag);
            if (oldBookcaseFragment != null) {
                mBookcaseFragment = oldBookcaseFragment;
            }
            CategoryFragment oldCategoryFragment = (CategoryFragment) getSupportFragmentManager().findFragmentByTag(FragmentTag.CategoryFragmentTag);
            if (oldCategoryFragment != null) {
                mCategoryFragment = oldCategoryFragment;
            }
            HotListFragment oldHotListFragment = (HotListFragment) getSupportFragmentManager().findFragmentByTag(FragmentTag.HotListFragmentTag);
            if (oldHotListFragment != null) {
                mHotListFragment = oldHotListFragment;
            }
            mCurrentIndex = savedInstanceState.getInt("index");
        }

        //如果调用了setSupportActionBar，那就必须在setSupportActionBar之前将标题置为空字符串，否则设置具体标题会无效
        mToolbar.setTitle("");
        this.setSupportActionBar(mToolbar);
        mToolbar.setTitle(mStrTitle);
        //如果调用了setSupportActionBar，那就必须在setSupportActionBar之前将标题置为空字符串，否则设置具体标题会无效
        mToolbar.setTitle("");
        this.setSupportActionBar(mToolbar);
        mToolbar.setTitle(mStrTitle);

        //初始化TabLayout
        mTlMovie.setTabMode(TabLayout.MODE_FIXED);//支持水平滑动，当屏幕空间不足
        mTlMovie.setTabTextColors(mColorBlack, mColorPrimary);//设置文本在未选中和选中时候的颜色
        mTlMovie.setSelectedTabIndicatorColor(mColorPrimary);//设置选中长条的颜色
        mTlMovie.addTab(mTlMovie.newTab().setText(mStrPlaying), mCurrentIndex == 0 ? true : false);
        mTlMovie.addTab(mTlMovie.newTab().setText(mStrComming), mCurrentIndex == 1 ? true : false);
        mTlMovie.addTab(mTlMovie.newTab().setText(mStrHotList), mCurrentIndex == 2 ? true : false);

        //侧滑抽屉里的圆形头像，比较特殊，无法通过butterknife初始化
        mIvAvatar = mNavigationView.getHeaderView(0).findViewById(R.id.iv_avatar);
        DevRing.imageManager().loadRes(R.mipmap.ic_logo, mIvAvatar, new LoadOption().setIsCircle(true));
    }

    @Override
    protected void initData(Bundle bundle) {
        switch (mCurrentIndex) {
            case 0:
                setDefaultFragment(mBookcaseFragment, FragmentTag.BookcaseFragmentTag);//设置默认的Fragment
                break;
            case 1:
                setDefaultFragment(mCategoryFragment, FragmentTag.CategoryFragmentTag);//设置默认的Fragment
                break;
        }
    }

    @Override
    protected void initEvent() {
        //设置TabLayout选项卡的点击事件
        mTlMovie.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        mCurrentIndex = 0;
                        clickBookcase();
                        break;
                    case 1:
                        mCurrentIndex = 1;
                        clickCategory();
                        break;
                    case 2:
                        mCurrentIndex = 2;
                        clickHotList();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });


        //设置DrawerLayout滑动的相关监听
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                View mContent = mDrawerLayout.getChildAt(0);
                mContent.setTranslationX(drawerView.getMeasuredWidth() * slideOffset);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
            }

            @Override
            public void onDrawerClosed(View drawerView) {
            }

            @Override
            public void onDrawerStateChanged(int newState) {
            }
        });

        //设置侧滑栏中的菜单项点击事件
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_item_collect:
                        startActivity(new Intent(MainHomeActivity.this, CollectActivity.class));
                        break;

                    case R.id.nav_item_upload:
                        startActivity(new Intent(MainHomeActivity.this, UploadActivity.class));
                        break;
                    case R.id.nav_item_download:
                        startActivity(new Intent(MainHomeActivity.this, DownloadActivity.class));
                        break;
                }
                //收起侧滑栏
//                mDrawerLayout.closeDrawers();

                return false; //true则点击的菜单项会变成选中状态,，false则不会变成选中状态
            }
        });

        mIvAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RingToast.show(R.string.github_star);
            }
        });
    }

    //重写返回键点击事件
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                //没收起侧滑栏的话则先收起
                if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                } else if (System.currentTimeMillis() - mExitTime > 2000) {
                    RingToast.show(mStrExitConfirm);
                    mExitTime = System.currentTimeMillis();
                } else {
                    DevRing.activityListManager().exitApp();
                }
                return true;
            default:
                return super.onKeyDown(keyCode, event);
        }
    }

    //设置默认Fragment
    private void setDefaultFragment(BaseFragment fragment, String tag) {
        if (!fragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().add(R.id.fl_movie, fragment, tag).commit();
        }
        mCurrentFragment = fragment;
        mCurrentFragment.setUserVisibleHint(true);
    }

    //显示“正在上映”Fragment
    private void clickBookcase() {
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), mBookcaseFragment, FragmentTag.BookcaseFragmentTag);
    }

    //显示“即将上映”Fragment
    private void clickCategory() {
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), mCategoryFragment, FragmentTag.CategoryFragmentTag);
    }
    //显示“即将上映”Fragment
    private void clickHotList() {
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), mHotListFragment, FragmentTag.HotListFragmentTag);
    }

    //显示或隐藏Fragment，用于切换Fragment的展示
    private void addOrShowFragment(FragmentTransaction transaction, BaseFragment fragment, String tag) {
        if (mCurrentFragment == fragment) return;

        if (!fragment.isAdded()) {
            transaction.hide(mCurrentFragment).add(R.id.fl_movie, fragment, tag).commit();
        } else {
            transaction.hide(mCurrentFragment).show(fragment).commit();
        }

        //不与ViewPager嵌套的话，需要显式调用setUserVisibleHint才能使用懒加载功能。
        mCurrentFragment.setUserVisibleHint(false);
        mCurrentFragment = fragment;
        mCurrentFragment.setUserVisibleHint(true);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("index", mCurrentIndex);
    }

    @Override
    public boolean isUseEventBus() {
        return true;
    }

    //接收事件总线发来的事件
    @org.greenrobot.eventbus.Subscribe //如果使用默认的EventBus则使用此@Subscribe
    @com.superme.reader.mvp.model.bus.support.Subscribe //如果使用RxBus则使用此@Subscribe
    public void handleEvent(CollectCountEvent event) {
        //更新侧滑栏中菜单项的收藏数量
        mNavigationView.getMenu().findItem(R.id.nav_item_collect).setTitle(getResources().getString(R.string.collect, event.getCount()));
    }

}
