package com.wowsai.www.vmovie.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.wowsai.www.vmovie.bean.Banner_Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class MyPagerAdapter extends PagerAdapter {
    List<ImageView> mImageViews;
    List<Banner_Entity.DataBean> data;
    private Context mContext;

    public MyPagerAdapter(Context context, List<Banner_Entity.DataBean> data) {
        mContext = context;
        mImageViews = new ArrayList<>();
        if (data != null) {
            this.data = data;
        } else
            this.data = new ArrayList<>();
        for (int i = 0; i < this.data.size(); i++) {
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            mImageViews.add(imageView);
        }
    }
    //追加数据源
    public void addData( List<Banner_Entity.DataBean> data){
        if (data != null) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = mImageViews.get(position%mImageViews.size());
        Picasso.with(mContext).load(data.get(position%data.size()).getImage()).into(imageView);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView(mImageViews.get(position%mImageViews.size()));
    }
}
