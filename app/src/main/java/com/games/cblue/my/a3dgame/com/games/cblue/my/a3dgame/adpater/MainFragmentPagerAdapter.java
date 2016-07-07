package com.games.cblue.my.a3dgame.com.games.cblue.my.a3dgame.adpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by my on 2016/7/7.
 */
public class MainFragmentPagerAdapter extends FragmentPagerAdapter{
    //碎片适配器
    private List<Fragment> fragments;
    public MainFragmentPagerAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.fragments=fragments;
    }
    //初始化position位置的界面
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    //获取当前窗体界面数
    @Override
    public int getCount() {
        return fragments.size();
    }
}
