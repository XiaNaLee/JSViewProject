package com.iqyi.paopao.jsviewsdk.v8object.base;

import android.view.View;

import com.eclipsesource.v8.V8;

/**
 * Created by LiYong on 2017/9/20.
 * Email:liyong@qiyi.com/lee131483@gmail.com
 */

public abstract class BaseJsViewObject<T extends View> extends BaseJsObject {
    protected T view;

    public BaseJsViewObject(V8 v8Runtime) {
        super(v8Runtime);
    }

}
