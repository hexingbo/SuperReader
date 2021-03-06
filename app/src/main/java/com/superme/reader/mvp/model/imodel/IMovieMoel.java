package com.superme.reader.mvp.model.imodel;

import com.superme.reader.mvp.model.entity.table.MovieCollect;
import com.ljy.devring.base.imodel.IBaseModel;

import io.reactivex.Observable;

/**
 * author:  ljy
 * date:    2018/3/21
 * description:
 */

public interface IMovieMoel extends IBaseModel {
    Observable getPlayingMovie(int start, int count);

    Observable getCommingMovie(int start, int count);

    void addToMyCollect(MovieCollect movieCollect);

    void updateMenuCollectCount();

}
