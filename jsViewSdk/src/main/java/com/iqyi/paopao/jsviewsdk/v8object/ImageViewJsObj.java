package com.iqyi.paopao.jsviewsdk.v8object;

import android.view.ViewGroup;

import com.eclipsesource.v8.V8;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by LiYong on 2017/9/20.
 * Email:liyong@qiyi.com/lee131483@gmail.com
 * Version:
 */

public class ImageViewJsObj extends ViewJsObj<SimpleDraweeView> {

    public ImageViewJsObj(V8 v8Runtime, ViewGroup viewGroup) {
        super(v8Runtime, viewGroup, null);
    }

    public ImageViewJsObj(V8 v8Runtime, ViewGroup viewGroup, SimpleDraweeView imageView) {
        super(v8Runtime, viewGroup, imageView);
    }

    @Override
    public void initV8Object() {
        super.initV8Object();
        mObject.registerJavaMethod(this, "setUrl", "setUrl", new Class[]{String.class});
        mObject.registerJavaMethod(this, "setRoundedCorners", "setRoundedCorners",
                new Class[]{boolean.class});
    }

    @Override
    public SimpleDraweeView getView() {
        return view != null ? view : new SimpleDraweeView(mContext);
    }

    public void setUrl(String url) {
        view.setImageURI(url);
    }

    public void setRoundedCorners(boolean roundedCorners) {
        GenericDraweeHierarchy genericDraweeHierarchy = view.getHierarchy();
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.setRoundAsCircle(roundedCorners);
        genericDraweeHierarchy.setRoundingParams(roundingParams);
        view.setHierarchy(genericDraweeHierarchy);
    }
}
