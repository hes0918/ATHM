package com.lanou3g.dllo.athm.controler.fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import com.lanou3g.dllo.athm.R;
import com.lanou3g.dllo.athm.controler.adapter.RecmdPagerAdapter;
import com.lanou3g.dllo.athm.controler.fragment.recomdfrgmet.ActorFragment;
import com.lanou3g.dllo.athm.controler.fragment.recomdfrgmet.BulletinFragment;
import com.lanou3g.dllo.athm.controler.fragment.recomdfrgmet.NewestFrgment;
import com.lanou3g.dllo.athm.controler.fragment.recomdfrgmet.VideoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 */
public class RecommendFragment extends AbsBaseFragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<AbsBaseFragment> fragments;
    private RecmdPagerAdapter adapter ;


    @Override
    protected int setLayout() {
        return R.layout.recommend_frgment;
    }

    @Override
    protected void initView() {
        tabLayout = byview(R.id.recommend_tab);
        viewPager = byview(R.id.recommend_vp);

    }

   @Override
   protected void initDatas() {
       fragments = new ArrayList<>();
       fragments.add(new NewestFrgment());
       fragments.add(new ActorFragment());
       fragments.add(new BulletinFragment());
       fragments.add(new VideoFragment());
       adapter = new RecmdPagerAdapter(getChildFragmentManager());
       adapter.setFragments(fragments);
//        绑定适配器
        viewPager.setAdapter(adapter);
//        viewPager和tablayout联动
        tabLayout.setupWithViewPager(viewPager);
        //设置标签长什么样
        tabLayout.getTabAt(0).setText("最新");
        tabLayout.getTabAt(1).setText("优创+");
        tabLayout.getTabAt(2).setText("快报");
        tabLayout.getTabAt(3).setText("视频");

    }


}
