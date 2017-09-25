package com.iqyi.paopao.jsviewsdk.v8object;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Object;
import com.iqyi.paopao.jsviewsdk.v8object.base.BaseJsObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiYong on 2017/9/20.
 * Email:liyong@qiyi.com/lee131483@gmail.com
 */

public class WindowJsObj extends BaseJsObject {

    private ViewGroup mAttachViewGroup;
    private List<BaseJsObject> mV8Objects = new ArrayList<>();
    private LinearLayout mRootLayout;

    public WindowJsObj(V8 v8Runtime, ViewGroup viewGroup) {
        super(v8Runtime);
        mAttachViewGroup = viewGroup;
        mRootLayout = new LinearLayout(viewGroup.getContext());
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        mRootLayout.setLayoutParams(params);
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
        mObject.registerJavaMethod(this, "createLLayout", "createLLayout", null);
        mObject.registerJavaMethod(this, "createRLayout", "createRLayout", null);
        mObject.registerJavaMethod(this, "createImageView", "createImageView", null);
    }

    public V8Object createButton() {
        ButtonJsObj buttonV8Object = new ButtonJsObj(mRuntime, mRootLayout);
        mV8Objects.add(buttonV8Object);
        return buttonV8Object.getObject();
    }

    public V8Object createTextView() {
        TextViewJsObj textViewJsObj = new TextViewJsObj(mRuntime, mRootLayout);
        mV8Objects.add(textViewJsObj);
        return textViewJsObj.getObject();
    }

    public V8Object createLLayout() {
        LinearLayoutJsObj linearLayoutJsObj = new LinearLayoutJsObj(mRuntime, mRootLayout);
        mV8Objects.add(linearLayoutJsObj);
        return linearLayoutJsObj.getObject();
    }

    public V8Object createRLayout() {
        RelativeLayoutJsObj relativeLayoutJsObj = new RelativeLayoutJsObj(mRuntime, mRootLayout);
        mV8Objects.add(relativeLayoutJsObj);
        return relativeLayoutJsObj.getObject();
    }

    public V8Object createImageView() {
        ImageViewJsObj relativeLayoutJsObj = new ImageViewJsObj(mRuntime, mRootLayout);
        mV8Objects.add(relativeLayoutJsObj);
        return relativeLayoutJsObj.getObject();
    }

    public View getRootView() {
        return mRootLayout;
    }
}
