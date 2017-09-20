package com.iqyi.paopao.jsviewsdk.core;

import android.content.Context;
import android.view.View;

import com.eclipsesource.v8.V8;
import com.iqyi.paopao.jsviewsdk.FileUtil;
import com.iqyi.paopao.jsviewsdk.v8object.base.BaseJsObject;

import java.util.Stack;

/**
 * Created by LiYong on 2017/9/20.
 * Email:liyong@qiyi.com/lee131483@gmail.com
 * Version:
 */

public class J2V8Core {

    final static String LOG_TAG = "J2V8Core";

    static V8 mRuntime;

    private Context mContext;

    private static Stack<View> mViews;

    private static View mCurViewGroup;

    public static V8 getRuntime() {
        mViews = new Stack<>();
        mRuntime = V8.createV8Runtime();
        return mRuntime;
    }

    public static void run(Context context,String jsName) {
        mRuntime.executeScript(FileUtil.getJsContent(context,jsName));
    }

    public static void clean(BaseJsObject justV8Object) {
        justV8Object.getObject().release();
        mRuntime.release();
    }

    public static void push(View view) {
        mCurViewGroup = view;
        mViews.push(view);
    }

    public static Context getContext() {
        return mCurViewGroup != null ? mCurViewGroup.getContext() : null;
    }


}
