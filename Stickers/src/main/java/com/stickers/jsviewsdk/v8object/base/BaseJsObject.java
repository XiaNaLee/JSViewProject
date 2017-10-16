package com.stickers.jsviewsdk.v8object.base;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Object;

/**
 * Created by LiYong on 2017/9/20.
 * Email:lee131483@gmail.com
 */

public abstract class BaseJsObject {

    protected V8 mRuntime;
    protected V8Object mObject;

    public BaseJsObject(V8 v8Runtime) {
        mRuntime = v8Runtime;
        initV8Object();
    }

    public V8Object getObject() {
        return mObject;
    }

    public abstract void clean();

    public abstract void initV8Object();
}
