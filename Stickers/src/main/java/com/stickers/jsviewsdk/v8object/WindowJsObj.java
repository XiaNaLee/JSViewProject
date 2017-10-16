package com.stickers.jsviewsdk.v8object;


import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Object;
import com.stickers.jsviewsdk.v8object.base.BaseJsObject;
import com.stickers.jsviewsdk.v8object.base.BaseJsViewObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

;

/**
 * Created by LiYong on 2017/9/20.
 * Email:lee131483@gmail.com
 */

public class WindowJsObj extends BaseJsObject {

    private ViewGroup mAttachViewGroup;
    private List<BaseJsObject> mV8Objects = new ArrayList<>();
    private LinearLayout mRootLayout;
    private Map<String, BaseJsViewObject> mObjectMap = new HashMap<>();

    public WindowJsObj(V8 v8Runtime, ViewGroup viewGroup) {
        super(v8Runtime);
        mAttachViewGroup = viewGroup;
        mRootLayout = new LinearLayout(viewGroup.getContext());
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        mRootLayout.setLayoutParams(params);
    }

    @Override
    public void clean() {
        for (BaseJsObject v8Object : mV8Objects) {
            v8Object.clean();
        }
        mV8Objects.clear();
        mObjectMap.clear();
        mObject.release();
    }

    @Override
    public void initV8Object() {
        mObject = new V8Object(mRuntime);
        mObject.registerJavaMethod(this, "createButton", "createButton", new Class[]{String.class});
        mObject.registerJavaMethod(this, "createTextView", "createTextView",
                new Class[]{String.class});
        mObject.registerJavaMethod(this, "createLLayout", "createLLayout",
                new Class[]{String.class});
        mObject.registerJavaMethod(this, "createRLayout", "createRLayout",
                new Class[]{String.class});
        mObject.registerJavaMethod(this, "createImageView", "createImageView",
                new Class[]{String.class});
        mObject.registerJavaMethod(this, "findButtonByTag", "findButtonByTag",
                new Class[]{String.class});
        mObject.registerJavaMethod(this, "findTextViewByTag", "findTextViewByTag",
                new Class[]{String.class});
        mObject.registerJavaMethod(this, "findLLayoutByTag", "findLLayoutByTag",
                new Class[]{String.class});
        mObject.registerJavaMethod(this, "findRLayoutByTag", "findRLayoutByTag",
                new Class[]{String.class});
        mObject.registerJavaMethod(this, "findImageViewByTag", "findImageViewByTag",
                new Class[]{String.class});
    }

    public V8Object createButton(String tag) {
        ButtonJsObj buttonV8Object = new ButtonJsObj(mRuntime, mRootLayout);
        mV8Objects.add(buttonV8Object);
        mObjectMap.put(tag, buttonV8Object);
        return buttonV8Object.getObject();
    }

    public V8Object createTextView(String tag) {
        TextViewJsObj textViewJsObj = new TextViewJsObj(mRuntime, mRootLayout);
        mV8Objects.add(textViewJsObj);
        mObjectMap.put(tag, textViewJsObj);
        return textViewJsObj.getObject();
    }

    public V8Object createLLayout(String tag) {
        LinearLayoutJsObj linearLayoutJsObj = new LinearLayoutJsObj(mRuntime, mRootLayout);
        mV8Objects.add(linearLayoutJsObj);
        mObjectMap.put(tag, linearLayoutJsObj);
        return linearLayoutJsObj.getObject();
    }

    public V8Object createRLayout(String tag) {
        RelativeLayoutJsObj relativeLayoutJsObj = new RelativeLayoutJsObj(mRuntime, mRootLayout);
        mV8Objects.add(relativeLayoutJsObj);
        mObjectMap.put(tag, relativeLayoutJsObj);
        return relativeLayoutJsObj.getObject();
    }

    public V8Object createImageView(String tag) {
        ImageViewJsObj imageViewJsObj = new ImageViewJsObj(mRuntime, mRootLayout);
        mV8Objects.add(imageViewJsObj);
        mObjectMap.put(tag, imageViewJsObj);
        return imageViewJsObj.getObject();
    }

    public V8Object findButtonByTag(String tag) {
        return mObjectMap.get(tag).getObject();
    }

    public V8Object findTextViewByTag(String tag) {
        BaseJsViewObject v8Object = mObjectMap.get(tag);
        if (mObjectMap.get(tag).getObject().isReleased()) {
            TextViewJsObj textViewJsObj = (TextViewJsObj) v8Object;
            TextViewJsObj textViewJsObj1 = new TextViewJsObj(mRuntime, mRootLayout,textViewJsObj.getView());
            mV8Objects.add(textViewJsObj1);
            mObjectMap.put(tag, textViewJsObj1);
            return textViewJsObj1.getObject();
        }
        return mObjectMap.get(tag).getObject();
    }

    public V8Object findLLayoutByTag(String tag) {
        return mObjectMap.get(tag).getObject();
    }

    public V8Object findRLayoutByTag(String tag) {
        return mObjectMap.get(tag).getObject();
    }

    public V8Object findImageViewByTag(String tag) {
        BaseJsViewObject v8Object = mObjectMap.get(tag);
        if (mObjectMap.get(tag).getObject().isReleased()) {
            ImageViewJsObj textViewJsObj = (ImageViewJsObj) v8Object;
            ImageViewJsObj imageViewJsObj = new ImageViewJsObj(mRuntime, mRootLayout,textViewJsObj.getView());
            mV8Objects.add(imageViewJsObj);
            mObjectMap.put(tag, imageViewJsObj);
            return imageViewJsObj.getObject();
        }
        return mObjectMap.get(tag).getObject();
    }


    public View getRootView() {
        return mRootLayout;
    }
}
