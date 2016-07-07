package com.games.cblue.my.a3dgame.fragment;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.games.cblue.my.a3dgame.R;
import com.games.cblue.my.a3dgame.com.games.cblue.my.a3dgame.adpater.MainArticeFramentViewPagerAdapter;
import com.games.cblue.my.a3dgame.customview.MainArticleFragmentViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2016/7/7.
 */
public class ArticleFragment extends Fragment {
    //文章类型
    private int typeid;
        //自定义适配器
        MainArticeFramentViewPagerAdapter mainArticeFramentViewPagerAdapter;

    public ArticleFragment() {

    }

    //Annotation 注解
    @SuppressLint("ValidFragment")
    public ArticleFragment(int typeid) {
        this.typeid = typeid;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //获得Fragment中的整体布局
        View view = inflater.inflate(R.layout.activity_main_articlefragment, null);
        //获得Fragment中的ViewPager
        MainArticleFragmentViewPager mainArticleFragmentViewPager = (MainArticleFragmentViewPager) view.findViewById(R.id.main_articlefragment_viewpager);

        int imagesRsid[] = {R.drawable.default1, R.drawable.default2, R.drawable.default3};

        //初始化viewPager的数据   中间图片的
        List<ImageView> imageViews = new ArrayList<ImageView>();

        for (int i = 0; i < 3; i++) {
            //声明实例 中间图片的图片框
            ImageView imageView = new ImageView(getActivity());
            //设置图片缩放类型  铺满全屏
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            //将图片放入图片框中
            imageView.setImageResource(imagesRsid[i]);
            // 将图片框加入list集合
            imageViews.add(imageView);
        }
        mainArticeFramentViewPagerAdapter=new MainArticeFramentViewPagerAdapter(imageViews);
        mainArticleFragmentViewPager.setAdapter(mainArticeFramentViewPagerAdapter);

        TextView tv= (TextView) view.findViewById(R.id.activity_main_articlefragment_tv);
        tv.setText(typeid+"");

        return view;
    }
}































