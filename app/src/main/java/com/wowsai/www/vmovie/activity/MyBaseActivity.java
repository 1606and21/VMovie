package com.wowsai.www.vmovie.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2016/7/25.
 */
public abstract class MyBaseActivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        loadData();
        setOnListener();
    }

    //初始化控件,必须重写
   public abstract void initView();

    //加载数据,
    public abstract  void loadData();

    //设置监听
    public abstract void setOnListener();
}
