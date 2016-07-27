package com.wowsai.www.vmovie.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.wowsai.www.vmovie.R;
import com.wowsai.www.vmovie.adapter.MainViewPager_FragmentAdapter;
import com.wowsai.www.vmovie.fragment.MainChannelFragment;
import com.wowsai.www.vmovie.fragment.MainLeastFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends MyBaseActivity implements View.OnClickListener {


    private static final String TAG = MainActivity.class.getSimpleName();
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> fragments;
    private ImageView iv_menu;

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(mToolbar);
        mTabLayout = (TabLayout) findViewById(R.id.tablayout_main);
        mViewPager = (ViewPager) findViewById(R.id.viewPager_main);
        iv_menu = (ImageView) findViewById(R.id.iv_main);
    }

    @Override
    public void loadData() {
        fragments = new ArrayList<>();
        MainLeastFragment mlf = new MainLeastFragment();
        MainChannelFragment mcf = new MainChannelFragment();
        fragments.add(mlf);
        fragments.add(mcf);
        MainViewPager_FragmentAdapter  adapter = new MainViewPager_FragmentAdapter(getSupportFragmentManager(),fragments);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void setOnListener() {
        iv_menu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.iv_main:
                intent.setClass(getApplicationContext(),MenuActivity.class);
                startActivity(intent);
                break;
        }
    }
}
