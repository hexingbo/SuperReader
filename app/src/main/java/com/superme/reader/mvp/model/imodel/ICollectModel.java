package com.superme.reader.mvp.model.imodel;

import com.superme.reader.mvp.model.entity.table.MovieCollect;
import com.ljy.devring.base.imodel.IBaseModel;

import io.reactivex.Observable;

/**
 * author:  ljy
 * date:    2018/3/21
 * description:
 */

public interface ICollectModel extends IBaseModel {

    Observable getAllCollect();

    void deleteFromMyCollect(MovieCollect movieCollect);

    int getCollectCount();

    void updateMenuCollectCount();
}
