package com.wowsai.www.vmovie.utils;

import android.util.Log;

import org.xutils.common.Callback;

/**
 * Created by Administrator on 2016/7/25.
 */
public abstract class MyCallback implements Callback.CommonCallback<String> {
private String TAG = MyCallback.class.getSimpleName();
    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        Log.d(TAG, "======onError: ");
    }

    @Override
    public void onCancelled(CancelledException cex) {
        Log.d(TAG, "======onCancelled: ");
    }

    @Override
    public void onFinished() {
        Log.d(TAG, "========onFinished: ");
    }
}
