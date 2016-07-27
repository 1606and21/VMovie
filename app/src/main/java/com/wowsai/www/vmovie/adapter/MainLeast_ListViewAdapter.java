package com.wowsai.www.vmovie.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wowsai.www.vmovie.R;
import com.wowsai.www.vmovie.bean.LeastEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class MainLeast_ListViewAdapter extends MyBaseListViewAdapter<LeastEntity.DataBean> {

    private static final String TAG = MainLeast_ListViewAdapter.class.getSimpleName();

    public MainLeast_ListViewAdapter(Context context, List<LeastEntity.DataBean> data) {
        super(context, data);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
            MyViewHolder viewHolder = null;
        if (view != null) {
            viewHolder = (MyViewHolder) view.getTag();
        }else{
            view = inflater.inflate(R.layout.least_item,viewGroup,false);
            viewHolder = new MyViewHolder();
            viewHolder.typeAndTime = (TextView) view.findViewById(R.id.tv_type_time);
            viewHolder.mImageView = (ImageView) view.findViewById(R.id.iv_least_item);
            viewHolder.name = (TextView) view.findViewById(R.id.tv_name);
            view.setTag(viewHolder);
        }
        //绑定数据
        Log.d(TAG, "=====getView: "+data.size());
        LeastEntity.DataBean dataBean = (LeastEntity.DataBean) data.get(i);
        if (dataBean != null) {
            //加载图片
            Picasso.with(mContext).load(dataBean.getImage()).into(viewHolder.mImageView);
            viewHolder.name.setText(dataBean.getTitle());
            String duration = dataBean.getDuration();
            List<LeastEntity.DataBean.CatesBean> cates = dataBean.getCates();
            if (cates != null) {
                String catename = cates.get(0).getCatename();
                viewHolder.typeAndTime.setText(catename+"/"+changeTimeType(duration));
            }
        }
        return view;
    }
    static class MyViewHolder {
        ImageView mImageView;
        TextView name,typeAndTime;
    }
    public String changeTimeType(String time){
        int i = Integer.parseInt(time);
        return i/60+"'"+i%60+"''";
    }
}
