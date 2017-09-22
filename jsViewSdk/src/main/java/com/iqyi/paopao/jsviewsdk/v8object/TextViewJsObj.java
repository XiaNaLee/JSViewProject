package com.iqyi.paopao.jsviewsdk.v8object;

import android.view.ViewGroup;
import android.widget.TextView;

import com.eclipsesource.v8.V8;

/**
 * Created by LiYong on 2017/9/20.
 * Email:liyong@qiyi.com/lee131483@gmail.com
 * Version:
 */

public class TextViewJsObj extends ViewJsObj<TextView>  {

    public TextViewJsObj(V8 v8Runtime, ViewGroup viewGroup) {
        super(v8Runtime, viewGroup);
    }

    @Override
    public void initV8Object() {
        super.initV8Object();
        mObject.registerJavaMethod(this, "setText", "setText", new Class[]{String.class});
    }

    @Override
    public TextView getView() {
        return new TextView(mContext);
    }

    public void setText(String text) {
        view.setText(text);
    }
}
