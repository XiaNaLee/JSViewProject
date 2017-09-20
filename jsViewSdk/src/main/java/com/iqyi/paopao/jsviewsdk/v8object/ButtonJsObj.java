package com.iqyi.paopao.jsviewsdk.v8object;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Object;
import com.iqyi.paopao.jsviewsdk.core.J2V8Core;
import com.iqyi.paopao.jsviewsdk.v8object.base.BaseJsObject;

/**
 * Created by LiYong on 2017/9/20.
 * Email:liyong@qiyi.com/lee131483@gmail.com
 * Version:
 */

public class ButtonJsObj extends BaseJsObject {

    private Button mButton;
    private ViewGroup mViewGroup;

    public ButtonJsObj(V8 v8Runtime, Context context) {
        super(v8Runtime);
        mButton = new Button(context);
    }

    public ButtonJsObj(V8 v8Runtime, ViewGroup viewGroup) {
        super(v8Runtime);
        mButton = new Button(viewGroup.getContext());
        mViewGroup = viewGroup;
    }

    public ButtonJsObj(V8 v8Runtime) {
        super(v8Runtime);
        mButton = new Button(J2V8Core.getContext());
    }

    @Override
    public void clean() {
        mObject.release();
    }

    @Override
    public void initV8Object() {
        mObject = new V8Object(mRuntime);
        mObject.registerJavaMethod(this, "setText", "setText", new Class[]{String.class});
        mObject.registerJavaMethod(this, "show", "show", null);
    }


    public void setText(String text) {
        mButton.setText(text);
        Log.d("mButton", "" + mButton);
    }

    public void show(){
        mViewGroup.addView(mButton);
    }

}
