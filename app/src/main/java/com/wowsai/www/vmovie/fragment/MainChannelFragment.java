package com.wowsai.www.vmovie.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.wowsai.www.vmovie.R;
import com.wowsai.www.vmovie.adapter.MainChannel_RVAdapter;
import com.wowsai.www.vmovie.bean.ChannelEntity;
import com.wowsai.www.vmovie.uri.Uri;
import com.wowsai.www.vmovie.utils.MyCallback;

import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainChannelFragment extends MyBaseFragment {


    private static final String TAG = MainChannelFragment.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private MainChannel_RVAdapter adapter;
    private List<ChannelEntity.DataBean> data;
    public MainChannelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return initView(inflater,container);
    }
    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_main_channel,container,false);
        mRecyclerView = ((RecyclerView) view.findViewById(R.id.rv_channel));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        adapter = new MainChannel_RVAdapter(getContext(),data);
        mRecyclerView.setAdapter(adapter);
        loadData();
        return view;
    }
    @Override
    protected void loadData() {
        RequestParams requestParams = new RequestParams(Uri.MAIN_CHANNEL);
        x.http().post(requestParams, new MyCallback() {
            @Override
            public void onSuccess(String result) {
                data = new Gson().fromJson(result, ChannelEntity
                        .class).getData();
                Log.d(TAG, "------onSuccess: "+data.size());
               adapter.addData(data);
            }
        });
    }
    @Override
    protected void setOnListener() {

    }
}
