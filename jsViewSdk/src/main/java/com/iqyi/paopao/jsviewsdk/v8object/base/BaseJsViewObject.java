package com.iqyi.paopao.jsviewsdk.v8object.base;

import android.content.Context;
import android.view.View;

import com.eclipsesource.v8.V8;
import com.iqyi.paopao.jsviewsdk.core.J2V8Core;
import com.iqyi.paopao.jsviewsdk.util.GeneralViewHelper;
import com.iqyi.paopao.jsviewsdk.util.ViewUtil;

/**
 * Created by LiYong on 2017/9/20.
 * Email:liyong@qiyi.com/lee131483@gmail.com
 */

public abstract class BaseJsViewObject<T extends View> extends BaseJsObject {
    protected T view;
    protected Context mContext;
    protected GeneralViewListener mGeneralViewHelper;
    protected String mOnClickFName;

    public BaseJsViewObject(V8 v8Runtime, Context context) {
        super(v8Runtime);
        mContext = context;
        view = getView();
        ViewUtil.setId(view);
        J2V8Core.addViewByViewId(view.getId(),view);
        mGeneralViewHelper = new GeneralViewHelper(view);
    }

    public abstract T getView();

}
