package com.wowsai.www.vmovie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public abstract class MyBaseListViewAdapter<T> extends BaseAdapter {

    public Context mContext;
    public LayoutInflater inflater;
    public List<T> data;
    public MyBaseListViewAdapter(Context context,List<T> data){
        this.mContext = context;
        inflater = LayoutInflater.from(context);
        if (null != data) {
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
    public int getCount() {
        return data!=null?data.size():0;
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

}
