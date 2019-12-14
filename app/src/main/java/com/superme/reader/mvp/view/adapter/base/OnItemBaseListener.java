package com.superme.reader.mvp.view.adapter.base;

import android.view.View;

/**
 * @Author :hexingbo
 * @Date :2019/12/14
 * @FileName： OnItemBaseListener
 * @Describe :
 */
public interface OnItemBaseListener<T> {
    void onItemClick(int position, T bean, View view);
}
