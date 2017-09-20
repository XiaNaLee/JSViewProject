package com.iqyi.paopao.jsviewsdk.v8object;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Object;
import com.iqyi.paopao.jsviewsdk.v8object.base.BaseJsViewObject;

/**
 * Created by LiYong on 2017/9/20.
 * Email:liyong@qiyi.com/lee131483@gmail.com
 * Version:
 */

public class TextViewJsObj extends BaseJsViewObject<TextView> {

    private ViewGroup mViewGroup;
    private Context mContext;

    public TextViewJsObj(V8 v8Runtime, Context context) {
        super(v8Runtime);
    }


    public TextViewJsObj(V8 v8Runtime, ViewGroup viewGroup) {
        super(v8Runtime);
        mViewGroup = viewGroup;
        mContext = mViewGroup.getContext();
        view = new TextView(mContext);
    }

    public TextViewJsObj(V8 v8Runtime) {
        super(v8Runtime);
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
        view.setText(text);
        Log.d("mButton", "" + view);
    }

    public void show() {
        mViewGroup.addView(view);
    }

}
