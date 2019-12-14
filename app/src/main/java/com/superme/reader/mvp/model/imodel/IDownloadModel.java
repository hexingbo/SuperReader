package com.superme.reader.mvp.model.imodel;

import com.ljy.devring.base.imodel.IBaseModel;

import io.reactivex.Observable;

/**
 * author:  ljy
 * date:    2018/3/23
 * description:
 */

public interface IDownloadModel extends IBaseModel {

    Observable downloadFile();

}
