package com.superme.reader.mvp.view.adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.ljy.devring.DevRing;
import com.ljy.devring.other.RingLog;
import com.superme.reader.R;
import com.superme.reader.mvp.model.entity.res.SearchBookInfoBean;
import com.superme.reader.mvp.view.adapter.base.RecyclerBaseAdapter;
import com.superme.reader.mvp.view.adapter.base.ViewHolder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import butterknife.ButterKnife;

/**
 * author:  ljy
 * date:    2017/9/28
 * description: 我的收藏列表的适配器
 */

public class SearchBookAdapter extends RecyclerBaseAdapter<SearchBookInfoBean> {


    View mShowingDetails = null;
    int mShowingIndex = -1;

    public SearchBookAdapter(@NonNull List<SearchBookInfoBean> mDataList) {
        super(mDataList);
    }

    @Override
    protected void bindDataForView(ViewHolder holder, final SearchBookInfoBean bean, final int position) {
        View mBookInfo = holder.getView(R.id.view_book_info);
        final View mDetails = holder.getView(R.id.view_details);
        SimpleDraweeView ivLogo = holder.getView(R.id.iv_logo);
        TextView tvBookName = holder.getView(R.id.tv_book_name);
        TextView tvAuther = holder.getView(R.id.tv_auther);
        TextView tvSource = holder.getView(R.id.tv_source);
        TextView tvIntroduction = holder.getView(R.id.tv_introduction);
        TextView btRead = holder.getView(R.id.bt_read);
        TextView tvType = holder.getView(R.id.tv_type);
        Button btAddBookCase = holder.getView(R.id.bt_add_bookcase);
        Button btNoBook = holder.getView(R.id.bt_no_book);

        if (mShowingDetails != null && mShowingIndex == position) {
            mDetails.setVisibility(View.VISIBLE);
        } else {
            mDetails.setVisibility(View.GONE);
        }
        tvBookName.setText(bean.getBookName());
        tvAuther.setText("作者：" + bean.getAuthor());
        tvType.setText("类型：" + bean.getType());
        tvSource.setText("来源：" + bean.getTag());
        RingLog.d("hxb---->", "getIntro：" + bean.getIntro());
        tvIntroduction.setText(bean.getIntro().replaceAll("\\\\n", "\n"));

        if ((TextUtils.isEmpty(bean.getBaseLink()) || TextUtils.equals(bean.getTag(), "未收录")) && !bean.isZhuiShu()) {
            btAddBookCase.setVisibility(View.GONE);
            btRead.setVisibility(View.GONE);

            btNoBook.setVisibility(View.VISIBLE);
        } else {
            btAddBookCase.setVisibility(View.VISIBLE);
            btRead.setVisibility(View.VISIBLE);

            btNoBook.setVisibility(View.GONE);

            //判断是否在书架中
            boolean isExist = false;
//            if (BookCaseAdapter.mBeans != null) {
//                for (BookCaseBean itemBean : BookCaseAdapter.mBeans) {
//                    if (TextUtils.equals(itemBean.getBookName(), bean.getBookName())) {
//                        isExist = true;
//                        break;
//                    }
//                }
//            }

            //如果已经存在在书架上则隐藏
            if (isExist) {
                btAddBookCase.setEnabled(false);
                btAddBookCase.setBackgroundColor(Color.parseColor("#909090"));
            } else {
                btAddBookCase.setEnabled(true);
                btAddBookCase.setBackgroundColor(Color.parseColor("#B63327"));
            }
        }

        try {
            String urlLink = URLDecoder.decode(bean.getImg(), "UTF-8").replace("/agent/", "");
            RingLog.d("imgUrl：" + urlLink);
            DevRing.imageManager().loadNet(urlLink, ivLogo);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        mBookInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDetails.isShown()) {
                    mDetails.setVisibility(View.GONE);
                    mShowingDetails = null;
                    mShowingIndex = -1;
                } else {
                    if (mShowingDetails != null)
                        mShowingDetails.setVisibility(View.GONE);
                    mDetails.setVisibility(View.VISIBLE);
                    mShowingDetails = mDetails;
                    mShowingIndex = position;
                }
            }
        });

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_book, parent, false);
        ButterKnife.bind(this, view);
        return new ViewHolder(view);
    }

}
