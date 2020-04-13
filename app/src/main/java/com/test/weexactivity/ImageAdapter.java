package com.test.weexactivity;

import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.apache.weex.WXEnvironment;
import org.apache.weex.WXSDKManager;
import org.apache.weex.adapter.IWXImgLoaderAdapter;
import org.apache.weex.common.WXImageStrategy;
import org.apache.weex.dom.WXImageQuality;


public class ImageAdapter implements IWXImgLoaderAdapter {


    @Override
    public void setImage(final  String url, final ImageView view, WXImageQuality quality, WXImageStrategy strategy) {


        WXSDKManager.getInstance().postOnUiThread(new Runnable() {

            @Override
            public void run() {
                if(view==null||view.getLayoutParams()==null){
                    return;
                }
                if (TextUtils.isEmpty(url)) {
                    view.setImageBitmap(null);
                    return;
                }
                String temp = url;
                if (url.startsWith("//")) {
                    temp = "http:" + url;
                }
                if (view.getLayoutParams().width <= 0 || view.getLayoutParams().height <= 0) {
                    return;
                }
                Picasso.with(WXEnvironment.getApplication())
                        .load(temp)
                        .into(view);
            }
        },0);

    }
}
