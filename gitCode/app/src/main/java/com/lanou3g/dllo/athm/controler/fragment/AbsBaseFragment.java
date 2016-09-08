package com.lanou3g.dllo.athm.controler.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lanou3g.dllo.athm.controler.activity.AbsBaseActivity;

/**
 * Created by dllo on 16/9/8.
 */
public abstract class AbsBaseFragment extends Fragment {
    protected Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(setLayout(),container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //初始化组件
        initView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //使用数据
        initDatas();
    }
    //绑定布局
    protected  abstract  int setLayout();
    //初始化组件
    protected  abstract  void initView();
    //初始化数据
    protected  abstract  void initDatas();
    //简化findViewById
    protected  <T extends View> T byview(int resId){
        return (T) getView().findViewById(resId);
    }
    //跳转
    protected  void go(Class<? extends AbsBaseActivity> to){
        context.startActivity(new Intent(context, to));
    }
    //跳转传值
    protected  void go(Class<? extends AbsBaseActivity> to,Bundle bundle){
        Intent intent = new Intent(context,to);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }



}
