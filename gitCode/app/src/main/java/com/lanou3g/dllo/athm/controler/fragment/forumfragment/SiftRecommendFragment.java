package com.lanou3g.dllo.athm.controler.fragment.forumfragment;


import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lanou3g.dllo.athm.R;
import com.lanou3g.dllo.athm.controler.adapter.ForumDialogAdapter;
import com.lanou3g.dllo.athm.controler.adapter.SiftRecyclerAdapter;
import com.lanou3g.dllo.athm.controler.fragment.AbsBaseFragment;
import com.lanou3g.dllo.athm.utils.OnRvItemClick;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 */
public class SiftRecommendFragment extends AbsBaseFragment {
    //定义标题栏的图片 点击弹出dialog
    private ImageView imageView;
    private AlertDialog alertDialog;

    private ListView listView;
    private List<String> datas;


    //定义RecyclerView
    private RecyclerView recyclerView;
    //定义占位布局的Fragment
    private SiftAllFragment siftAllFragment;
    //定义适配器
    private SiftRecyclerAdapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.forum_sift_fragment;
    }

    @Override
    protected void initView() {
        recyclerView = byview(R.id.sift_title_recycler);
        siftAllFragment = new SiftAllFragment();
        //初始化图片
        imageView = byview(R.id.forum_sift_image);


    }

    @Override
    protected void initDatas() {


        adapter = new SiftRecyclerAdapter(context);
        recyclerView.setAdapter(adapter);
        //RecyclerView 对比ListView多的是
        //1.需要设置布局管理器
        //  布局管理器一共有三种
        //  现在先来使用第一种 线性布局管理器 垂直和水平方向
        LinearLayoutManager llManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        //将布局管理者设置给RecyclerView
        recyclerView.setLayoutManager(llManager);
        //为RecyclerView设置数据
        List<String> data = new ArrayList<>();
        data.add("全部");
        data.add("媳妇当车模");
        data.add("美人\"记\"");
        data.add("论坛红人馆");
        data.add("论坛讲师");
        data.add("精挑细选");
        data.add("现身说法");
        data.add("高端阵地");
        data.add("电动车");
        data.add("汇买车");
        data.add("行车点评");
        data.add("超级试驾员");
        data.add("海外购车");
        data.add("经典老车");
        data.add("妹子选车");
        data.add("优惠购车");
        data.add("原创大片");
        data.add("顶配风采");
        data.add("改装有理");
        data.add("养车有道");
        data.add("首发阵营");
        data.add("新车直播");
        data.add("历史选题");
        data.add("摩友天地");
        data.add("蜜月之旅");
        data.add("甜蜜有礼");
        data.add("摄影课堂");
        data.add("车友聚会");
        data.add("单车部落");
        data.add("杂谈俱乐部");
        data.add("华北游记");
        data.add("西南游记");
        data.add("东北游记");
        data.add("西北游记");
        data.add("华中游记");
        data.add("华南游记");
        data.add("华东游记");
        data.add("港澳台游记");
        data.add("海外游记");
        data.add("沧海遗珠");
        adapter.setDatas(data);


        //为RecyclerView设置行布局点击事件
        adapter.setOnRvItemClick(new OnRvItemClick() {

            @Override
            public void onRvItemClickListener(int position, String str) {
                Toast.makeText(context, "position:" + position, Toast.LENGTH_SHORT).show();
                //碎片管理者
                FragmentManager manager = getChildFragmentManager();
                final FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.forum_sift_frame, siftAllFragment);
                transaction.commit();

            }

        });

        //点击图片弹出dialog
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示对话框
                //创建对话框的builder对象
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                //加载出对话框显示的View
                View view = LayoutInflater.from(context).inflate(R.layout.forum_dialog_login, null);
                listView = (ListView) view.findViewById(R.id.dialog_list_view);
                bulidDatas();

                ForumDialogAdapter adapter = new ForumDialogAdapter(context);

                adapter.setDatas(datas);

                listView.setAdapter(adapter);
                TextView dialogTv = (TextView) view.findViewById(R.id.dialog_close_tv);
                dialogTv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //让本对话框消失
                        alertDialog.dismiss();
                    }
                });
                //设置完成View,将其设置到Dialog中
                builder.setView(view);
                //显示的流程
                //创造类 create生成一个对话框
                alertDialog = builder.create();
                //对话框调show方法显示
                alertDialog.show();
            }

        });
        //构造listview假数据
        //创建适配器

    }


    private void bulidDatas() {
        datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            datas.add("全部" + i);
        }
    }
}
