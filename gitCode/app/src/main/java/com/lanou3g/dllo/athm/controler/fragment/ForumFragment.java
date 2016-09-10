package com.lanou3g.dllo.athm.controler.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.lanou3g.dllo.athm.R;
import com.lanou3g.dllo.athm.controler.adapter.ForumPagerAdapter;
import com.lanou3g.dllo.athm.controler.adapter.RecmdPagerAdapter;
import com.lanou3g.dllo.athm.controler.fragment.forumfragment.HotpasteFragment;
import com.lanou3g.dllo.athm.controler.fragment.forumfragment.SiftRecommendFragment;
import com.lanou3g.dllo.athm.controler.fragment.recomdfrgmet.NewsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 */
public class ForumFragment extends AbsBaseFragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<AbsBaseFragment> fragments;
    private ForumPagerAdapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.forum_fragment;
    }

    @Override
    protected void initView() {
        tabLayout = byview(R.id.forum_tab);
        viewPager = byview(R.id.forum_vp);
    }

    @Override
    protected void initDatas() {
        fragments = new ArrayList<>();
        fragments.add(new SiftRecommendFragment());
        fragments.add(new HotpasteFragment());
        fragments.add(new HotpasteFragment());
        adapter = new ForumPagerAdapter(getChildFragmentManager());
        adapter.setForumFragments(fragments);
//        绑定适配器
        viewPager.setAdapter(adapter);
//        viewPager和tablayout联动
        tabLayout.setupWithViewPager(viewPager);
        //设置标签长什么样
        tabLayout.getTabAt(0).setText("精选推荐");
        tabLayout.getTabAt(1).setText("热帖");
        tabLayout.getTabAt(2).setText("常用论坛");

    }
}
