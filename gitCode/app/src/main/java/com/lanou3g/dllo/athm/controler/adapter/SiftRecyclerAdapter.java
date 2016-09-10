package com.lanou3g.dllo.athm.controler.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lanou3g.dllo.athm.R;
import com.lanou3g.dllo.athm.utils.OnRvItemClick;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 */
public class SiftRecyclerAdapter extends RecyclerView.Adapter<SiftRecyclerAdapter.MyViewHolder> {
    /**
     * 写适配器的步骤
     * 1.先创建内部类:组件缓存类
     * 要求 extends RecyclerView.ViewHolder
     * 2.在适配器的继承关系中
     * 适配器外部类继承extends RecyclerView.Adapter <组件缓存类>
     * (外部类想引用内部类 里面要填写MainAdapter.内部类名)
     */
    private Context context;
    private List<String> datas;

    //定义点击接口对象
    private OnRvItemClick onRvItemClick;

    //提供set方法
    public void setOnRvItemClick(OnRvItemClick onRvItemClick) {
        this.onRvItemClick = onRvItemClick;
    }

    public SiftRecyclerAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<String> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }


    //初始化缓存类
    //生成组件缓存类 缓存组件
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //布局初始化  从context获得一个布局加载器 加载布局 因为加载布局的方法是Activity才可以 所以利用context
        View view = LayoutInflater.from(context).inflate(R.layout.item_sift_recycler, parent, false);
        //把布局里面的数据赋值缓存类里面
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    //Bind的意思是绑定
    //为组件缓存类中的组件绑定内容
    //设置行布局视图的内容
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        //设置内容
        holder.tv.setText(datas.get(position));
        //设置itemView(convertView)的点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断自定义点击接口不为null执行
                if (onRvItemClick != null) {
                    //获取当前行布局的position
                    int p = holder.getLayoutPosition();
                    //获取当前行布局的数据
                    String str = datas.get(position);
                    //将数据存储到接口对象中
                    //回调接口方法-发出命令-执行setOnRvItemClick方法
                    onRvItemClick.onRvItemClickListener(p, str);
                }
            }
        });
    }



    @Override
    public int getItemCount() {
        return datas != null && datas.size() > 0 ? datas.size() : 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        //定义
        TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            //初始化
            tv = (TextView) itemView.findViewById(R.id.sift_title_tv);
        }
    }
}
