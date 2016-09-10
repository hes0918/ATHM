package com.lanou3g.dllo.athm.controler.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.lanou3g.dllo.athm.R;
import com.lanou3g.dllo.athm.controler.adapter.FindcarPagerAdapter;
import com.lanou3g.dllo.athm.controler.fragment.findcarfragment.BrandFragment;
import com.lanou3g.dllo.athm.controler.fragment.forumfragment.HotpasteFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 */
public class FindcarFragment extends AbsBaseFragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<AbsBaseFragment> fragments;
    private FindcarPagerAdapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.findcar_fragment;
    }

    @Override
    protected void initView() {
          tabLayout = byview(R.id.findcar_tab);
          viewPager = byview(R.id.findcar_vp);
    }

    @Override
    protected void initDatas() {
        fragments = new ArrayList<>();
        fragments.add(new BrandFragment());
        fragments.add(new BrandFragment());
        fragments.add(new BrandFragment());
        fragments.add(new BrandFragment());
        adapter = new FindcarPagerAdapter(getChildFragmentManager());
        adapter.setFindcarFragments(fragments);
        //        绑定适配器
        viewPager.setAdapter(adapter);
//        viewPager和tablayout联动
        tabLayout.setupWithViewPager(viewPager);
        //设置标签长什么样
        tabLayout.getTabAt(0).setText("品牌");
        tabLayout.getTabAt(1).setText("筛选");
        tabLayout.getTabAt(2).setText("降价");
        tabLayout.getTabAt(3).setText("找二手车");


    }
}
