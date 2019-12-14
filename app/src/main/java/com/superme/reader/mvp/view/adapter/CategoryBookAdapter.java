package com.superme.reader.mvp.view.adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ljy.devring.DevRing;
import com.ljy.devring.other.RingLog;
import com.superme.reader.R;
import com.superme.reader.mvp.model.entity.res.CategoryBookItemBean;
import com.superme.reader.mvp.view.adapter.base.RecyclerBaseAdapter;
import com.superme.reader.mvp.view.adapter.base.ViewHolder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * author:  ljy
 * date:    2017/9/28
 * description: 我的收藏列表的适配器
 */

public class CategoryBookAdapter extends RecyclerBaseAdapter<CategoryBookItemBean.BooksBean> {

    public CategoryBookAdapter(@NonNull List<CategoryBookItemBean.BooksBean> mDataList) {
        super(mDataList);
    }

    @Override
    protected void bindDataForView(ViewHolder holder, final CategoryBookItemBean.BooksBean bean, final int position) {
        ImageView ivLogo = holder.getView(R.id.iv_logo);
        TextView tvBookName = holder.getView(R.id.tv_book_name);
        TextView tvAuther = holder.getView(R.id.tv_auther);
        TextView tvIntro = holder.getView(R.id.tv_intro);

        tvBookName.setText(bean.getTitle());
        tvAuther.setText(bean.getAuthor());
        tvIntro.setText(bean.getShortIntro());
        try {
            String urlLink = URLDecoder.decode(bean.getCover(), "UTF-8").replace("/agent/", "");
            RingLog.d("imgUrl：" + urlLink);
            //加载图片，且效果为 圆角&灰白&模糊
            DevRing.imageManager().loadNet(urlLink, ivLogo);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rank, parent, false);
        return new ViewHolder(view);
    }

}
