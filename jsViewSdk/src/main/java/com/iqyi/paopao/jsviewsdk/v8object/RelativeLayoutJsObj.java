package com.iqyi.paopao.jsviewsdk.v8object;

import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.eclipsesource.v8.V8;
import com.iqyi.paopao.jsviewsdk.core.J2V8Core;

/**
 * Created by LiYong on 2017/9/20.
 * Email:liyong@qiyi.com/lee131483@gmail.com
 */

public class RelativeLayoutJsObj extends ViewJsObj<RelativeLayout> {

    public RelativeLayoutJsObj(V8 v8Runtime, ViewGroup viewGroup) {
        super(v8Runtime, viewGroup);
    }

    @Override
    public void initV8Object() {
        super.initV8Object();
        mObject.registerJavaMethod(this, "addView", "addView", new Class[]{int.class});
    }

    @Override
    public RelativeLayout getView() {
        return new RelativeLayout(mContext);
    }

    public void addView(int viewId) {
        view.addView(J2V8Core.findViewById(viewId));
    }

}
