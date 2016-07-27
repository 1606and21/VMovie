package com.wowsai.www.vmovie.activity;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2016/7/25.
 */
public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
