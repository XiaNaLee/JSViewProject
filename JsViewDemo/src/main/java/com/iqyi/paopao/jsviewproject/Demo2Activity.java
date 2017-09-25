package com.iqyi.paopao.jsviewproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.eclipsesource.v8.V8;
import com.iqyi.paopao.jsviewsdk.core.J2V8Core;
import com.iqyi.paopao.jsviewsdk.v8object.WindowJsObj;


public class Demo2Activity extends Activity {
    private WindowJsObj mWindowV8Obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);

        final V8 v8 = J2V8Core.getRuntime();
        LinearLayout root =(LinearLayout) findViewById(R.id.layout);
        mWindowV8Obj = new WindowJsObj(v8, root);
        v8.add("window", mWindowV8Obj.getObject());
        J2V8Core.run(this, "test.js");

        root.addView(mWindowV8Obj.getRootView());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        J2V8Core.clean(mWindowV8Obj);
    }
}
