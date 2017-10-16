package com.iqyi.paopao.jsviewproject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.eclipsesource.v8.V8;
import com.stickers.jsviewsdk.core.J2V8Core;
import com.stickers.jsviewsdk.v8object.WindowJsObj;


public class Demo2Activity extends Activity {
    private WindowJsObj mWindowV8Obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        long startTime = System.currentTimeMillis();
        setContentView(R.layout.activity_demo2);
        setTitle("jsGenerateView");

        final V8 v8 = J2V8Core.getRuntime();
        LinearLayout root = (LinearLayout) findViewById(R.id.layout);
        mWindowV8Obj = new WindowJsObj(v8, root);
        v8.add("window", mWindowV8Obj.getObject());
        J2V8Core.run(this, "test.js");

        root.addView(mWindowV8Obj.getRootView());
        long endTime = System.currentTimeMillis();
        Log.d("Demo2Activity", "duration=" + (endTime - startTime));


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        J2V8Core.clean(mWindowV8Obj);
    }
}
