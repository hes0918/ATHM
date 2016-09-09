package com.lanou3g.dllo.athm.controler.activity;


import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lanou3g.dllo.athm.R;
import com.lanou3g.dllo.athm.controler.fragment.FindFragment;
import com.lanou3g.dllo.athm.controler.fragment.FindcarFragment;
import com.lanou3g.dllo.athm.controler.fragment.ForumFragment;
import com.lanou3g.dllo.athm.controler.fragment.MeFragment;
import com.lanou3g.dllo.athm.controler.fragment.RecommendFragment;

public class MainActivity extends AbsBaseActivity {
   //定义radioGroup
    private RadioGroup radioGroup;
    //定义五个标题栏Fragment
    private RecommendFragment recommendFragment;
    private ForumFragment forumFragment;
    private FindcarFragment findcarFragment;
    private FindFragment findFragment;
    private MeFragment meFragment;

    @Override
    protected int setLayout() {
        //绑定布局
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        //初始化组件
    radioGroup = (RadioGroup) findViewById(R.id.home_radio_group);
        recommendFragment = new RecommendFragment();
        forumFragment = new ForumFragment();
        findcarFragment = new FindcarFragment();
        findFragment = new FindFragment();
        meFragment = new MeFragment();
    }

    @Override
    protected void initDatas() {
        //点击事件
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //碎片管理者
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                switch (checkedId){
                    case R.id.recommend_btn://推荐
                        transaction.replace(R.id.main_home_frgment_view,recommendFragment);
                        break;
                    case R.id.forum_btn://论坛
                        transaction.replace(R.id.main_home_frgment_view,forumFragment);
                        break;
                    case R.id.findcar_btn://发现
                        transaction.replace(R.id.main_home_frgment_view,findcarFragment);
                        break;
                    case R.id.find_btn://查找
                        transaction.replace(R.id.main_home_frgment_view,findFragment);
                        break;
                    case R.id.me_btn://我
                        transaction.replace(R.id.main_home_frgment_view,meFragment);
                        break;
                }
                transaction.commit();
            }
        });
        //默认选中方法
        radioGroup.check(R.id.recommend_btn);



    }




}
