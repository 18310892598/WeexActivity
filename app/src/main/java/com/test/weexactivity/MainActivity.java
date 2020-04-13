package com.test.weexactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.apache.weex.IWXRenderListener;
import org.apache.weex.WXSDKInstance;
import org.apache.weex.common.WXRenderStrategy;

public class MainActivity extends AppCompatActivity implements IWXRenderListener {

    protected WXSDKInstance mWXSDKInstance;
    private FrameLayout mFrameLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mFrameLayout=findViewById(R.id.fragment_container);
        setContentView(R.layout.activity_main);
        mWXSDKInstance = new WXSDKInstance(this);
        mWXSDKInstance.registerRenderListener(this);
//        String path = "test.js";
        String pageName = "WXSample";
        String path = "http://10.53.132.31:8081/pages/dataAuditFlow/index.js?weex=1&barHidden=1";
//        String path="components/HelloWorld.js";
//        mWXSDKInstance.render(pageName, WXFileUtils.loadAsset(path, mWXSDKInstance.getContext()),null, null, -1, -1, WXRenderStrategy.APPEND_ASYNC);

        mWXSDKInstance.renderByUrl(pageName,path,null, null, WXRenderStrategy.APPEND_ASYNC);
//        String pageName = "WXSample";
//        String bundleUrl = "http://dotwe.org/raw/dist/38e202c16bdfefbdb88a8754f975454c.bundle.wx";
//        mWXSDKInstance.renderByUrl(pageName, path, null, null,WXRenderStrategy.APPEND_ASYNC);
    }

    @Override
    public void onViewCreated(WXSDKInstance instance, View view) {
        setContentView(view);
    }

    @Override
    public void onRenderSuccess(WXSDKInstance instance, int width, int height) {
    }

    @Override
    public void onRefreshSuccess(WXSDKInstance instance, int width, int height) {
    }

    @Override
    public void onException(WXSDKInstance instance, String errCode, String msg) {
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mWXSDKInstance != null) {
            mWXSDKInstance.onActivityResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mWXSDKInstance != null) {
            mWXSDKInstance.onActivityPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mWXSDKInstance != null) {
            mWXSDKInstance.onActivityStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mWXSDKInstance != null) {
            mWXSDKInstance.onActivityDestroy();
        }


    }
}

