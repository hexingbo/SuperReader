package com.superme.reader.mvp.view.adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.superme.reader.R;
import com.superme.reader.mvp.model.entity.res.CategoryItemBean;
import com.superme.reader.mvp.view.adapter.base.RecyclerBaseAdapter;
import com.superme.reader.mvp.view.adapter.base.ViewHolder;

import java.util.List;

/**
 * author:  ljy
 * date:    2017/9/28
 * description: 我的收藏列表的适配器
 */

public class CategoryLeftAdapter extends RecyclerBaseAdapter<CategoryItemBean> {

    private int mClickIndex = 0;
    private View mOldView;

    public CategoryLeftAdapter(@NonNull List<CategoryItemBean> mDataList) {
        super(mDataList);
    }

    @Override
    protected void bindDataForView(ViewHolder holder, final CategoryItemBean bean, final int position) {
        TextView tvSubject = holder.getView(R.id.tv_subject);
        tvSubject.setText(bean.str);
        holder.itemView.setEnabled(false);
        if (position == mClickIndex) {
            mOldView = tvSubject;
            tvSubject.setBackgroundColor(Color.parseColor("#ffffff"));
        } else {
            tvSubject.setBackgroundColor(Color.parseColor("#f0f0f0"));
        }

        tvSubject.setTag(position);
        tvSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOldView.setBackgroundColor(Color.parseColor("#f0f0f0"));
                mOldView = v;
                mOldView.setBackgroundColor(Color.parseColor("#ffffff"));

                mClickIndex = (int) v.getTag();
                CategoryItemBean bean = getDataList().get(mClickIndex);
                if (mItemListener != null) {
                    mItemListener.onItemClick(position, bean, v);
                }
            }
        });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_left, parent, false);
        return new ViewHolder(view);
    }

}
