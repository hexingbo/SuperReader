package com.superme.reader.mvp.view.adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ljy.devring.DevRing;
import com.ljy.devring.image.support.LoadOption;
import com.superme.reader.R;
import com.superme.reader.mvp.model.entity.res.CategoryBookItemBean;
import com.superme.reader.mvp.view.adapter.base.RecyclerBaseAdapter;
import com.superme.reader.mvp.view.adapter.base.ViewHolder;

import java.util.List;

import butterknife.BindView;

/**
 * author:  ljy
 * date:    2017/9/28
 * description: 我的收藏列表的适配器
 */

public class CategoryBookAdapter extends RecyclerBaseAdapter<CategoryBookItemBean.BooksBean> {

    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.tv_book_name)
    TextView tvBookName;
    @BindView(R.id.tv_auther)
    TextView tvAuther;
    @BindView(R.id.tv_intro)
    TextView tvIntro;

    public CategoryBookAdapter(@NonNull List<CategoryBookItemBean.BooksBean> mDataList) {
        super(mDataList);
    }

    @Override
    protected void bindDataForView(ViewHolder holder, final CategoryBookItemBean.BooksBean bean, final int position) {

        tvBookName.setText(bean.getTitle());
        tvAuther.setText(bean.getAuthor());
        tvIntro.setText(bean.getShortIntro());

        //加载图片，且效果为 圆角&灰白&模糊
        DevRing.imageManager().loadNet(bean.getCover(), ivLogo,
                new LoadOption().setRoundRadius(80).setIsGray(true).setBlurRadius(5));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rank, parent, false);
        return new ViewHolder(view);
    }

}
