package com.iqyi.paopao.jsviewsdk.v8object;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.iqyi.paopao.jsviewsdk.core.J2V8Core;
import com.iqyi.paopao.jsviewsdk.v8object.base.BaseJsViewObject;
import com.iqyi.paopao.jsviewsdk.v8object.base.GeneralViewListener;

/**
 * Created by LiYong on 2017/9/21.
 * Email:liyong@qiyi.com/lee131483@gmail.com
 * Version:
 */

public abstract class ViewJsObj<U extends View> extends BaseJsViewObject<U> implements
        GeneralViewListener {

    protected ViewGroup mViewGroup;

    public ViewJsObj(V8 v8Runtime, ViewGroup viewGroup) {
        super(v8Runtime, viewGroup.getContext());
        mViewGroup = viewGroup;

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnClickFName != null) {
                    mRuntime.executeScript(mOnClickFName);
                    V8Array parameters = new V8Array(mRuntime);
                    mRuntime.executeVoidFunction("click", parameters);
                    parameters.release();
                }
            }
        });
    }

    @Override
    public void clean() {
        J2V8Core.removeViewById(view.getId());
        mObject.release();
    }

    @Override
    public void initV8Object() {
        mObject = new V8Object(mRuntime);
        mObject.registerJavaMethod(this, "setRMargin", "setRMargin",
                new Class[]{int.class, int.class, int.class, int.class});
        mObject.registerJavaMethod(this, "setLMargin", "setLMargin",
                new Class[]{int.class, int.class, int.class, int.class});
        mObject.registerJavaMethod(this, "setPadding", "setPadding",
                new Class[]{int.class, int.class, int.class, int.class});
        mObject.registerJavaMethod(this, "setSize", "setSize", new Class[]{int.class, int.class});
        mObject.registerJavaMethod(this, "generateView", "generateView", null);
        mObject.registerJavaMethod(this, "click", "click", new Class[]{V8Function.class});
        mObject.registerJavaMethod(this, "getViewId", "getViewId", null);
        mObject.registerJavaMethod(this, "addRuleBySub", "addRuleBySub",
                new Class[]{int.class, int.class});
        mObject.registerJavaMethod(this, "addRule", "addRule", new Class[]{int.class});
        mObject.registerJavaMethod(this, "setBgColor", "setBgColor", new Class[]{String.class});

    }

    @Override
    public void setRMargin(int left, int top, int right, int bottom) {
        mGeneralViewHelper.setRMargin(left, top, right, bottom);
    }

    @Override
    public void setLMargin(int left, int top, int right, int bottom) {
        mGeneralViewHelper.setLMargin(left, top, right, bottom);
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        mGeneralViewHelper.setPadding(left, top, right, bottom);
    }

    @Override
    public void setSize(int width, int height) {
        mGeneralViewHelper.setSize(width, height);
    }

    @Override
    public void generateView() {
        mViewGroup.addView(view);
    }

    @Override
    public int getViewId() {
        return mGeneralViewHelper.getViewId();
    }

    public void click(final V8Function v8Function) {
        mOnClickFName = v8Function.toString();
    }

    public void addRuleBySub(int verb, int subject) {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
        if (params == null) {
            params =new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        params.addRule(verb, subject);
        view.setLayoutParams(params);
    }

    public void addRule(int verb) {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
        if (params == null) {
            params =new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        params.addRule(verb);
        view.setLayoutParams(params);
    }

    public void setBgColor(String color) {
        view.setBackgroundColor(Color.parseColor(color));
    }

}
