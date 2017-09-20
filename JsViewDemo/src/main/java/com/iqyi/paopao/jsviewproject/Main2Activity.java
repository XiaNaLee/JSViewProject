package com.iqyi.paopao.jsviewproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.iqyi.paopao.jsviewsdk.core.J2V8Core;
import com.iqyi.paopao.jsviewsdk.v8object.WindowJsObj;


public class Main2Activity extends Activity {
    long startTime;
    private WindowJsObj mWindowV8Obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        final V8 v8 = J2V8Core.getRuntime();
        LinearLayout root = findViewById(R.id.layout);
        mWindowV8Obj = new WindowJsObj(v8, root);
        v8.add("window", mWindowV8Obj.getObject());
        J2V8Core.run(this, "test.js");


        startTime = System.currentTimeMillis();


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                V8Array parameters = new V8Array(v8);
                parameters.push("John");
                parameters.push("Smith");
                v8.executeVoidFunction("setData", parameters);

                parameters.release();
            }
        });


    }


}
