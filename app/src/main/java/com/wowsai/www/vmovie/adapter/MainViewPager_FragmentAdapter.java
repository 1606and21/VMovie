package com.wowsai.www.vmovie.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class MainViewPager_FragmentAdapter extends FragmentPagerAdapter{
    private List<Fragment> mFragments;
    private String[] titles = {"最新","频道"};

    public MainViewPager_FragmentAdapter(FragmentManager fm,List<Fragment> mFragments) {
        super(fm);
        if (mFragments != null) {
            this.mFragments = mFragments;
        }else
            this.mFragments = new ArrayList<>();

    }

    @Override
    public Fragment getItem(int position) {
        return mFragments!=null?mFragments.get(position):null;
    }

    @Override
    public int getCount() {
        return mFragments!=null?mFragments.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
