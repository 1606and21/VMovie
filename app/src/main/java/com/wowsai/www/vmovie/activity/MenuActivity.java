package com.wowsai.www.vmovie.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.wowsai.www.vmovie.R;

public class MenuActivity extends MyBaseActivity implements View.OnClickListener {

    private ImageView iv_close;
    private ImageView iv_setting;
    private ImageView iv_massage;
    private TextView tv_login;
    private TextView tv_subscribe;
    private TextView tv_cache;
    private TextView tv_collect;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;

    @Override
    public void initView() {
        setContentView(R.layout.activity_menu);
        iv_close = (ImageView) findViewById(R.id.iv_close);
        iv_setting = (ImageView) findViewById(R.id.iv_setting_menu);
        iv_massage = (ImageView) findViewById(R.id.iv_massage_menu);
        tv_login = (TextView) findViewById(R.id.tv_login_menu);
        tv_subscribe = (TextView) findViewById(R.id.tv_subscribe_menu);
        tv_cache = (TextView) findViewById(R.id.tv_cache_menu);
        tv_collect = (TextView) findViewById(R.id.tv_collect_menu);
        rb1 = (RadioButton) findViewById(R.id.rb1_menu);
        rb2 = (RadioButton) findViewById(R.id.rb2_menu);
        rb3 = (RadioButton) findViewById(R.id.rb3_menu);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void setOnListener() {
        iv_close.setOnClickListener(this);
        iv_setting.setOnClickListener(this);
        rb3.setOnClickListener(this);
        rb2.setOnClickListener(this);
        rb1.setOnClickListener(this);
        tv_collect.setOnClickListener(this);
        tv_cache.setOnClickListener(this);
        tv_subscribe.setOnClickListener(this);
        tv_login.setOnClickListener(this);
        iv_massage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.iv_close:
                finish();
                break;
            case R.id.iv_setting_menu:
                break;
            case R.id.tv_login_menu:
                break;
            case R.id.iv_massage_menu:
                break;
            case R.id.tv_subscribe_menu:
                break;
            case R.id.tv_cache_menu:
                break;
            case R.id.tv_collect_menu:
                break;
            case R.id.rb1_menu:
                intent.setClass(this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case R.id.rb2_menu:
                break;
            case R.id.rb3_menu:
                break;
        }
    }
}
