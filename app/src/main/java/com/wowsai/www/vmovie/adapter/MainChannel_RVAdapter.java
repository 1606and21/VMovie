package com.wowsai.www.vmovie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wowsai.www.vmovie.R;
import com.wowsai.www.vmovie.bean.ChannelEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class MainChannel_RVAdapter extends MyBaseRVAdapter<ChannelEntity.DataBean>{


    public MainChannel_RVAdapter(Context context, List<ChannelEntity.DataBean> data) {
        super(context, data);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.channel_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ChannelEntity.DataBean dataBean = (ChannelEntity.DataBean) data.get(position);
        MyViewHolder viewHolder = ((MyViewHolder) holder);
        if (dataBean != null) {
            Picasso.with(mContext).load(dataBean.getIcon()).into(viewHolder.mImageView);
            viewHolder.mTextView.setText("#"+dataBean.getCatename()+"#");
        }
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView mImageView;
        TextView mTextView;
        public MyViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_channel_item);
            mTextView = (TextView) itemView.findViewById(R.id.tv_channel_item);
        }
    }
}
