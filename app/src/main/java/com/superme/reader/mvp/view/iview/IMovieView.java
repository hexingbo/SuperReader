package com.superme.reader.mvp.view.iview;

import com.superme.reader.mvp.model.entity.res.MovieRes;
import com.ljy.devring.base.iview.IBaseView;

import java.util.List;

/**
 * author:  ljy
 * date:    2017/9/27
 * description:
 */

public interface IMovieView extends IBaseView {
    void getMovieSuccess(List<MovieRes> list, int type);

    void getMovieFail(int status, String desc, int type);

}
