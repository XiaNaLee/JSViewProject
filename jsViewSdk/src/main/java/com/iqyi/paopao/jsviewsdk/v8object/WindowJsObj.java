package com.iqyi.paopao.jsviewsdk.v8object;

import android.view.ViewGroup;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Object;
import com.iqyi.paopao.jsviewsdk.v8object.base.BaseJsObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiYong on 2017/9/20.
 * Email:liyong@qiyi.com/lee131483@gmail.com
 * Version:
 */

public class WindowJsObj extends BaseJsObject {

    private ViewGroup mViewGroup;
    List<BaseJsObject> mV8Objects = new ArrayList<>();

    public WindowJsObj(V8 v8Runtime, ViewGroup viewGroup) {
        super(v8Runtime);
        mViewGroup = viewGroup;
    }

    @Override
    public void clean() {
        for (BaseJsObject v8Object : mV8Objects) {
            v8Object.clean();
        }
        mObject.release();
    }

    @Override
    public void initV8Object() {
        mObject = new V8Object(mRuntime);
        mObject.registerJavaMethod(this, "createButton", "createButton", null);
        mObject.registerJavaMethod(this, "createTextView", "createTextView", null);

    }

    public V8Object createButton() {
        ButtonJsObj buttonV8Object = new ButtonJsObj(mRuntime, mViewGroup);
        mV8Objects.add(buttonV8Object);
        return buttonV8Object.getObject();
    }

    public V8Object createTextView() {
        TextViewJsObj textViewJsObj = new TextViewJsObj(mRuntime, mViewGroup);
        mV8Objects.add(textViewJsObj);
        return textViewJsObj.getObject();
    }

    public BaseJsObject contain(V8Object v8Object) {
        for (BaseJsObject object : mV8Objects) {
            if (object.getObject() == v8Object) {
                return object;
            }
        }
        return null;
    }
}
