package com.wowsai.www.vmovie.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/7/25.
 */
public abstract  class MyBaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view =  initView(inflater, container);
        loadData();
        setOnListener();
        return view;

    }

    protected abstract void setOnListener();

    protected abstract void loadData();

    public abstract  View initView(LayoutInflater inflater, ViewGroup container);
}
