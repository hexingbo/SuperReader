package com.superme.reader.mvp.view.iview;

import com.superme.reader.mvp.model.entity.table.MovieCollect;
import com.ljy.devring.base.iview.IBaseView;

import java.util.List;

/**
 * author:  ljy
 * date:    2018/3/21
 * description:
 */

public interface ICollectView extends IBaseView {

    void getCollectSuccess(List<MovieCollect> list);

}
