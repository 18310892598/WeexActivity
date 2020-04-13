package com.test.weexactivity;

import android.app.Application;

import org.apache.weex.InitConfig;
import org.apache.weex.WXSDKEngine;
import org.apache.weex.adapter.DefaultWXHttpAdapter;


public class WeexApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //weex 初始化
        InitConfig config=new InitConfig.Builder()
                .setImgAdapter(new ImageAdapter())
                .setHttpAdapter(new DefaultWXHttpAdapter())
                .build();
        WXSDKEngine.initialize(WeexApplication.this,config);


    }
}
