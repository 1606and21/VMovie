package com.wowsai.www.vmovie.fragment;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.gson.Gson;
import com.wowsai.www.vmovie.R;
import com.wowsai.www.vmovie.activity.LeastDetailActivity;
import com.wowsai.www.vmovie.adapter.MainLeast_ListViewAdapter;
import com.wowsai.www.vmovie.adapter.MyPagerAdapter;
import com.wowsai.www.vmovie.bean.Banner_Entity;
import com.wowsai.www.vmovie.bean.LeastEntity;
import com.wowsai.www.vmovie.uri.Uri;
import com.wowsai.www.vmovie.utils.MyCallback;

import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainLeastFragment extends Fragment {


    private static final String TAG = MainLeastFragment.class.getSimpleName();
    private SwipeRefreshLayout mSwipeRefreshView;
    private ListView mListView;
    private int pager = 1;
    private List<LeastEntity.DataBean> data = new ArrayList<>();
    private Context mContext;
    private MainLeast_ListViewAdapter adapter;
    private View header;
    private ViewPager mViewPager;
    private List<Banner_Entity.DataBean> mBannerData;
    private MyPagerAdapter myPagerAdapter;
    private LinearLayout ll_header;
    private boolean isStop = false;
    private boolean isBottom = false;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
            mHandler.sendEmptyMessageDelayed(0,3000);
        }
    };
    public MainLeastFragment() {
        // Required empty public constructor
        mContext = getContext();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = initView(inflater, container);
        loadData();
        setOnListener();
        mHandler.sendEmptyMessage(0);
        return view;
    }


    private View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_main_least, container, false);
        mSwipeRefreshView = (SwipeRefreshLayout) view.findViewById(R.id.swipeRecyclerLayout_least);
       mSwipeRefreshView.setColorSchemeColors(Color.BLUE);
        mListView = (ListView) view.findViewById(R.id.listView_least);
        header = inflater.inflate(R.layout.listview_header, null);
        mViewPager = (ViewPager) header.findViewById(R.id.viewPager_listView_header);
        ll_header = ((LinearLayout) header.findViewById(R.id.ll_header));
        return view;
    }

    private void loadData() {
        adapter = new MainLeast_ListViewAdapter(getContext(), data);
        mListView.setAdapter(adapter);
        //添加头布局
        mListView.addHeaderView(header);
//        myPagerAdapter= new MyPagerAdapter(getContext(),mBannerData);
//        mViewPager.setAdapter(myPagerAdapter);
        getBannerData(Uri.MAIN_BANNER);
        getData(pager);
    }

    public void getData(int pager) {
        RequestParams requestParams = new RequestParams(String.format(Uri.MAIN_LEAST, pager));
        Log.d(TAG, "=====getData: "+String.format(Uri.MAIN_LEAST, pager));
        Log.d(TAG, "======getData: "+requestParams.getUri());
        x.http().post(requestParams, new MyCallback() {
            @Override
            public void onSuccess(String result) {
                Log.d(TAG, "=====onSuccess: "+result);
                List<LeastEntity.DataBean> mData = new Gson().fromJson(result, LeastEntity.class).getData();
                Log.d(TAG, "=====onSuccess: "+mData.get(0).getTitle());
                adapter.addData(mData);
            }
        });
    }
    //获得轮播的json数据
    public void getBannerData(String path) {
        RequestParams requestParams = new RequestParams(path);
        x.http().post(requestParams, new MyCallback() {
            private List<Banner_Entity.DataBean> bannerData;
            @Override
            public void onSuccess(String result) {
                bannerData = new Gson().fromJson(result, Banner_Entity.class).getData();
                Log.d(TAG, "======onSuccess:ban: " + bannerData.size());
                myPagerAdapter = new MyPagerAdapter(getContext(), bannerData);
                mViewPager.setAdapter(myPagerAdapter);
                //设置无限轮播
                final ImageView[] imageViews = new ImageView[bannerData.size()];
                //下方的下划线
                Log.d(TAG, "=====onSuccess: 循环钱:"+imageViews.length);
                for (int i = 0; i < bannerData.size(); i++) {
                    ImageView imageView = new ImageView(getContext());
                    imageView.setImageResource(R.drawable.header_line);
                    ll_header.addView(imageView);
                    imageView.setTag(i);
                    imageViews[i] = imageView;
                }
                Log.d(TAG, "=====Success: 循环后:"+imageViews.length);
                imageViews[0].setEnabled(true);

                mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int
                            positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        for (int i = 0; i < imageViews.length; i++) {
                            imageViews[i].setEnabled(false);
                        }
                        imageViews[position % imageViews.length].setEnabled(true);
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });
            }
        });

    }

    private void setOnListener() {
        mSwipeRefreshView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //刷新数据,重新加载数据
                data.clear();
                getData(1);
                getBannerData(Uri.MAIN_BANNER);
                mSwipeRefreshView.setRefreshing(false);
            }
        });
        //加载更多,分页
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (isBottom&&i==0){
                    pager++;
                    Log.d(TAG, "=====onScrollStateChanged: "+pager);
                    getData(pager);
                    isBottom = false;
                }
            }
            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                isBottom = i+i1==i2;
            }
        });
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), LeastDetailActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("postid",data.get(i).getPostid());
                intent.putExtra("postid",data.get(i).getPostid());
                startActivity(intent);
            }
        });

    }

    @Override
    public void onDestroy() {
        //防止内存泄漏
       mHandler.removeMessages(0);
        mHandler.removeCallbacksAndMessages(null);//移除所有的消息和回调,
        super.onDestroy();

    }
}
