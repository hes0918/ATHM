package com.lanou3g.dllo.athm.controler.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import com.lanou3g.dllo.athm.controler.fragment.AbsBaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 */
public class RecmdPagerAdapter extends FragmentPagerAdapter {


    private List<AbsBaseFragment> fragments = new ArrayList<>();

    public void setFragments(List<AbsBaseFragment> fragments) {
        this.fragments = fragments;
        notifyDataSetChanged();
    }

    public RecmdPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public AbsBaseFragment getItem(int position) {
        return fragments == null ? null : fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }

}
