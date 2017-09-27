package com.iqyi.paopao.jsviewproject;

import android.app.Activity;
import android.os.Bundle;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

public class Demo1Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_demo1);
        setTitle("纯粹native view");


        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.sd);

        GenericDraweeHierarchy genericDraweeHierarchy = simpleDraweeView.getHierarchy();
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.setRoundAsCircle(true);
        genericDraweeHierarchy.setRoundingParams(roundingParams);
        simpleDraweeView.setHierarchy(genericDraweeHierarchy);

        simpleDraweeView.setImageURI(
                "https://timgsa.baidu"
                        + ".com/timg?image&quality=80&size=b9999_10000&sec=1506319612933&di"
                        + "=ab5bf4792e57c6935beff7e5b7218598&imgtype=0&src=http%3A%2F%2Fimage"
                        + ".tianjimedia.com%2FuploadImages%2F2017%2F011%2F43%2FT2BQI68W995R.jpg");
    }


}
