package com.lanou3g.dllo.athm.controler.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by dllo on 16/9/8.
 */
public abstract class AbsBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局
        setContentView(setLayout());
        //需要初始化组件
        initView();
        //初始化数据
        initDatas();
    }
     //设置布局 返回值是R.layout.XX
    protected  abstract  int setLayout();

    //初始化组件
    protected  abstract void  initView();

    //初始化数据
    protected  abstract void  initDatas();

    //简化findViewById
    protected  <T extends View>  T byView(int resId) {
        return (T) findViewById(resId);
    }

    //跳转不传值
    protected  void  go(Context from,Class<? extends AppCompatActivity> to){
        startActivity(new Intent(from,to));
    }

     // 跳转传值
     // Bundle:轻量级存储类
     // 存储一些Key-value(键值对)形式的数据

    protected void  go(Context from,Class<? extends AppCompatActivity> to,Bundle extras){
        Intent intent = new Intent(from , to);
        intent.putExtras(extras);
        startActivity(intent);
    }



}
