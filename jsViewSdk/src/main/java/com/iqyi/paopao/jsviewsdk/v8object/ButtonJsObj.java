package com.iqyi.paopao.jsviewsdk.v8object;

import android.view.ViewGroup;
import android.widget.Button;

import com.eclipsesource.v8.V8;

/**
 * Created by LiYong on 2017/9/20.
 * Email:liyong@qiyi.com/lee131483@gmail.com
 */

public class ButtonJsObj extends ViewJsObj<Button> {

    public ButtonJsObj(V8 v8Runtime, ViewGroup viewGroup) {
        super(v8Runtime, viewGroup, null);
    }

    @Override
    public void initV8Object() {
        super.initV8Object();
        mObject.registerJavaMethod(this, "setText", "setText", new Class[]{String.class});
    }

    @Override
    public Button getView() {
        return view != null ? view : new Button(mContext);
    }

    public void setText(String text) {
        view.setText(text);
    }
}
