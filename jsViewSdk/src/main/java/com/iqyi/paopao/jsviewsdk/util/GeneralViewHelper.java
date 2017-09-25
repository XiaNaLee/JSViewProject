package com.iqyi.paopao.jsviewsdk.util;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.iqyi.paopao.jsviewsdk.v8object.base.GeneralViewListener;

/**
 * Created by LiYong on 2017/9/21.
 * Email:liyong@qiyi.com/lee131483@gmail.com
 * Version:
 */

public class GeneralViewHelper implements GeneralViewListener {

    private View view;

    public GeneralViewHelper(View view) {
        this.view = view;
    }

    @Override
    public void setRMargin(int left, int top, int right, int bottom) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        RelativeLayout.LayoutParams params;
        if (layoutParams != null && layoutParams instanceof RelativeLayout.LayoutParams) {
            params = (RelativeLayout.LayoutParams) layoutParams;
        } else {
            params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        left = ViewUtil.dp2px(view.getContext(), left);
        top = ViewUtil.dp2px(view.getContext(), top);
        right = ViewUtil.dp2px(view.getContext(), right);
        bottom = ViewUtil.dp2px(view.getContext(), bottom);
        params.leftMargin = left;
        params.topMargin = top;
        params.rightMargin = right;
        params.bottomMargin = bottom;
        view.setLayoutParams(params);
    }

    @Override
    public void setLMargin(int left, int top, int right, int bottom) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        LinearLayout.LayoutParams params;
        if (layoutParams != null && layoutParams instanceof LinearLayout.LayoutParams) {
            params = (LinearLayout.LayoutParams) layoutParams;
        } else {
            params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        left = ViewUtil.dp2px(view.getContext(), left);
        top = ViewUtil.dp2px(view.getContext(), top);
        right = ViewUtil.dp2px(view.getContext(), right);
        bottom = ViewUtil.dp2px(view.getContext(), bottom);
        params.leftMargin = left;
        params.topMargin = top;
        params.rightMargin = right;
        params.bottomMargin = bottom;
        view.setLayoutParams(params);

    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        left = ViewUtil.dp2px(view.getContext(), left);
        top = ViewUtil.dp2px(view.getContext(), top);
        right = ViewUtil.dp2px(view.getContext(), right);
        bottom = ViewUtil.dp2px(view.getContext(), bottom);
        view.setPadding(left, top, right, bottom);
    }

    @Override
    public void setSize(int width, int height) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        width = handleSize(width);
        height = handleSize(height);
        layoutParams.width = width;
        layoutParams.height = height;
        view.setLayoutParams(layoutParams);
    }

    @Override
    public void generateView() {

    }

    @Override
    public int getViewId() {
        return view.getId();
    }


    private int handleSize(int size) {
        if (size == ViewGroup.LayoutParams.WRAP_CONTENT
                || size == ViewGroup.LayoutParams.MATCH_PARENT) {
            return size;
        }
        return ViewUtil.dp2px(view.getContext(), size);
    }
}
