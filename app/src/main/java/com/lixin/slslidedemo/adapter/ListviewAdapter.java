package com.lixin.slslidedemo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lixin.slslidedemo.R;


/**
 * Created by lixin on 2017/1/18.
 */

public class ListviewAdapter extends BaseAdapter {


    private Context mContext;

    public ListviewAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return 15;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.view_list_item, parent, false);
            viewHolder.tv = (TextView) convertView.findViewById(R.id.list_item_tv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if(position == 5){
            viewHolder.tv.setBackgroundColor(Color.GREEN);
        }else{
            viewHolder.tv.setBackgroundColor(Color.DKGRAY);
        }

        return convertView;
    }

    private static class ViewHolder {
        public TextView tv;

    }
}
