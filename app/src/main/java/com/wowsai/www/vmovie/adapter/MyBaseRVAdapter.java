package com.wowsai.www.vmovie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public abstract class MyBaseRVAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context mContext;
    public List<T> data;
    public LayoutInflater inflater;
    public MyBaseRVAdapter(Context context,List<T> data){
        this.mContext = context;
        inflater = LayoutInflater.from(context);
        if (data != null) {
            this.data = data;
        }else
            this.data = new ArrayList<>();
    }
    //追加数据源
    public void addData(List<T> data){
        if (data != null) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }
    //刷新数据
    public void updateData(List<T> data){
        if (data != null) {
            this.data.addAll(0,data);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return data!=null?data.size():0;
    }
}
