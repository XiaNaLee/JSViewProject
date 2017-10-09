package com.iqyi.paopao.jsviewproject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

public class Demo1Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        long startTime = System.currentTimeMillis();
        setContentView(R.layout.activity_demo1);
        setTitle("纯粹native view");


        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.sd);

        GenericDraweeHierarchy genericDraweeHierarchy = simpleDraweeView.getHierarchy();
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.setRoundAsCircle(true);
        genericDraweeHierarchy.setRoundingParams(roundingParams);
        simpleDraweeView.setHierarchy(genericDraweeHierarchy);

        simpleDraweeView.setImageURI(
                "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3687352270,"
                        + "1420167656&fm=27&gp=0.jpg");

        long endTime = System.currentTimeMillis();
        Log.d("Demo1Activity", "duration=" + (endTime - startTime));
    }


}
