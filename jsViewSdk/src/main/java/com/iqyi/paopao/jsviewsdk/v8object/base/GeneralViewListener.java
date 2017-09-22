package com.iqyi.paopao.jsviewsdk.v8object.base;

/**
 * Created by LiYong on 2017/9/21.
 * Email:liyong@qiyi.com/lee131483@gmail.com
 * Version:
 */

public interface GeneralViewListener {

    /**
     * 设置RelativeLayout.LayoutParam
     */
    void setRMargin(int left,int top,int right,int bottom);

    /**
     * 设置LinearLayout.LayoutParam
     */
    void setLMargin(int left,int top,int right,int bottom);

    void setPadding(int left,int top,int right,int bottom);

    void setSize(int width,int height);

    int getViewId();

    void generateView();


}
