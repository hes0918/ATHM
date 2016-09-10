package com.lanou3g.dllo.athm.controler.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lanou3g.dllo.athm.R;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 */
public class ForumDialogAdapter extends BaseAdapter {
    private List<String> datas;
    private Context context;

    public ForumDialogAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<String> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        //如果数据不为null并且个数大于0
        //ListView的行数就是数据集合的大小,否则为0行

        return  datas != null&& datas.size()> 0? datas.size(): 0;
    }

    @Override
    public Object getItem(int position) {
        return datas != null&&datas.size()>0? datas.get(position):null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //定义组件缓存类
        ViewHolder viewHolder = null;
        //第一次生成行布局;判断如果是null就加载
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item_forum_dialog,parent,false);
            //把加载出来的View传入缓存类去findViewById
            viewHolder = new ViewHolder(convertView);
            //Object的方法, setTag 保存某个属性
            //将viewHolder临时挂载在convertView上保存
            convertView.setTag(viewHolder);
        }else {
            //不是第一次生成行布局,开始复用
            viewHolder = (ViewHolder)convertView.getTag();

        }
        viewHolder.titleTv.setText("全部");

        return convertView;
    }
    class ViewHolder{
        TextView titleTv;
        public ViewHolder(View v){
            titleTv = (TextView) v.findViewById(R.id.item_dialog_tv);
        }
    }
}
