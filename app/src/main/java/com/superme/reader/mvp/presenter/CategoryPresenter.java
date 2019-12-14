package com.superme.reader.mvp.presenter;

import com.ljy.devring.DevRing;
import com.ljy.devring.base.presenter.BasePresenter;
import com.ljy.devring.http.support.observer.CommonObserver;
import com.ljy.devring.http.support.throwable.HttpThrowable;
import com.ljy.devring.util.RxLifecycleUtil;
import com.superme.reader.mvp.model.entity.res.CategoryBean;
import com.superme.reader.mvp.model.entity.res.CategoryItemBean;
import com.superme.reader.mvp.model.imodel.ICategoryModel;
import com.superme.reader.mvp.view.iview.ICategoryView;
import com.trello.rxlifecycle2.android.FragmentEvent;


public class CategoryPresenter extends BasePresenter<ICategoryView, ICategoryModel> {


    public CategoryPresenter(ICategoryView iView, ICategoryModel iModel) {
        super(iView, iModel);
    }

    public void getCategory() {
        DevRing.httpManager().commonRequest(mIModel.getCategory(),
                new CommonObserver<CategoryBean>() {
                    @Override
                    public void onResult(CategoryBean beans) {
                        setCategoryLeftData(beans);
                    }

                    @Override
                    public void onError(HttpThrowable throwable) {

                    }
                }, RxLifecycleUtil.bindUntilEvent(mIView, FragmentEvent.DESTROY));
    }

    private void setCategoryLeftData(CategoryBean beans) {
        if (beans != null) {
            CategoryItemBean bean;
            for (CategoryBean.MaleBean item : beans.getMale()) {
                if (item.getMins().isEmpty()) {
                    bean = new CategoryItemBean();
                    bean.gender = "male";
                    bean.major = item.getMajor();
                    bean.minor = "";
                    bean.str = bean.major;
                    mIView.getCategoryItemList().add(bean);
                } else {
                    for (String mins : item.getMins()) {
                        bean = new CategoryItemBean();
                        bean.gender = "male";
                        bean.major = item.getMajor();
                        bean.minor = mins;
                        bean.str = mins;
                        mIView.getCategoryItemList().add(bean);
                    }
                }
            }

            for (CategoryBean.FemaleBean item : beans.getFemale()) {
                if (item.getMins().isEmpty()) {
                    bean = new CategoryItemBean();
                    bean.gender = "female";
                    bean.major = item.getMajor();
                    bean.minor = "";
                    bean.str = bean.major;
                    mIView.getCategoryItemList().add(bean);
                } else {
                    for (String mins : item.getMins()) {
                        bean = new CategoryItemBean();
                        bean.gender = "female";
                        bean.major = item.getMajor();
                        bean.minor = mins;
                        bean.str = mins;
                        mIView.getCategoryItemList().add(bean);
                    }
                }
            }
            for (CategoryBean.PictureBean item : beans.getPicture()) {
                if (item.getMins().isEmpty()) {
                    bean = new CategoryItemBean();
                    bean.gender = "picture";
                    bean.major = item.getMajor();
                    bean.minor = "";
                    bean.str = bean.major;
                    mIView.getCategoryItemList().add(bean);
                } else {
                    for (Object mins : item.getMins()) {
                        bean = new CategoryItemBean();
                        bean.gender = "picture";
                        bean.major = item.getMajor();
                        bean.minor = (String) mins;
                        bean.str = (String) mins;
                        mIView.getCategoryItemList().add(bean);
                    }
                }
            }
            for (CategoryBean.PressBean item : beans.getPress()) {
                if (item.getMins().isEmpty()) {
                    bean = new CategoryItemBean();
                    bean.gender = "press";
                    bean.major = item.getMajor();
                    bean.minor = "";
                    bean.str = bean.major;
                    mIView.getCategoryItemList().add(bean);
                } else {
                    for (Object mins : item.getMins()) {
                        bean = new CategoryItemBean();
                        bean.gender = "press";
                        bean.major = item.getMajor();
                        bean.minor = (String) mins;
                        bean.str = (String) mins;
                        mIView.getCategoryItemList().add(bean);
                    }
                }
            }
            mIView.getCategoryLeftAdapter().notifyDataSetChanged();
        }

    }

}
