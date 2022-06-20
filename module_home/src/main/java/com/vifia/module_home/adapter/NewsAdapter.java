package com.vifia.module_home.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.vifia.module_home.R;
import com.vifia.module_home.bean.News;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {
    private int item_layout_id;
    public NewsAdapter(Context context, int resource, List objects) {
        super(context, resource,objects);
        item_layout_id=resource;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=null;
        final  ViewHolder holder;
        if(convertView==null){//回收站为空\
            /**
             * LayoutInflater.from()得到布局填充器对象
             * getContext()获取当前上下文
             * inflate() 加载填充布局
             */
            view= LayoutInflater.from(getContext())
                    .inflate(item_layout_id,parent,false);
            holder=new ViewHolder(view);
            view.setTag(holder);

        }else {//显示后续的列表项
            view=convertView;
            holder= (ViewHolder) view.getTag();
        }
        News itemData=getItem(position);
        holder.title.setText(itemData.getTitle());
        holder.date.setText(itemData.getDate());
        holder.source.setText(itemData.getSource());
        return view;
    }
    class  ViewHolder{
        TextView title;
        TextView date;
        TextView source;

        public ViewHolder(View view) {
            title=(TextView) view.findViewById(R.id.title);
            date=(TextView)view.findViewById(R.id.date);
            source=(TextView)view.findViewById(R.id.source);
        }
    }
}
