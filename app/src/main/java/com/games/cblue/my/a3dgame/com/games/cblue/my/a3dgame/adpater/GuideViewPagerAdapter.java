package com.games.cblue.my.a3dgame.com.games.cblue.my.a3dgame.adpater;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by my on 2016/7/6.
 */
public class GuideViewPagerAdapter extends PagerAdapter {

    private List<View> views;
    public GuideViewPagerAdapter(List<View> views) {
        this.views=views;
    }

    //初始化position位置的界面
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //添加 条目
        container.addView(views.get(position));

        return views.get(position);
    }

    //销毁position位置的界面
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //删除条目
        container.removeView(views.get(position));
    }

    //获取当前窗体界面数
    @Override
    public int getCount() {
        return views.size();
    }

    //判断是否由对象生成界面
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
