package com.games.cblue.my.a3dgame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.games.cblue.my.a3dgame.com.games.cblue.my.a3dgame.adpater.MainFragmentPagerAdapter;
import com.games.cblue.my.a3dgame.fragment.ArticleFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener,ViewPager.OnPageChangeListener{

    //声明控件
    HorizontalScrollView horizontalScrollView_top;
    RadioGroup radioGroup_top;
    RadioButton rb01_top,rb02_top,rb03_top,rb04_top,rb05_top,rb06_top,rb07_top,rb08_top,rb09_top,rb10_top;
    ViewPager viewPager_center;
    RadioGroup radioGroup_bottom;
    RadioButton rb01_bottom,rb02_bottom,rb03_bottom;

    MainFragmentPagerAdapter mainFragmentPagerAdapter;
    List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化所有控件
        initView();
        //添加监听
        initListener();
        //初始化ViewPager中的控件
        initData();
    }

    private void initData() {
        fragments=new ArrayList<Fragment>();
        ArticleFragment f1=new ArticleFragment(1);
        ArticleFragment f2=new ArticleFragment(2);
        ArticleFragment f3=new ArticleFragment(3);
        ArticleFragment f4=new ArticleFragment(4);
        ArticleFragment f5=new ArticleFragment(5);
        ArticleFragment f6=new ArticleFragment(6);
        ArticleFragment f7=new ArticleFragment(7);
        ArticleFragment f8=new ArticleFragment(8);
        ArticleFragment f9=new ArticleFragment(9);
        ArticleFragment f10=new ArticleFragment(10);

        fragments.add(f1);
        fragments.add(f2);
        fragments.add(f3);
        fragments.add(f4);
        fragments.add(f5);
        fragments.add(f6);
        fragments.add(f7);
        fragments.add(f8);
        fragments.add(f9);
        fragments.add(f10);

        mainFragmentPagerAdapter=new MainFragmentPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager_center.setAdapter(mainFragmentPagerAdapter);


    }

    //初始化所有的监听
    private void initListener() {
        radioGroup_top.setOnCheckedChangeListener(this);
        radioGroup_bottom.setOnCheckedChangeListener(this);
        viewPager_center.addOnPageChangeListener(this);
    }

    //初始化所有控件
    private void initView() {
        horizontalScrollView_top= (HorizontalScrollView) findViewById(R.id.main_top_hsv);
        radioGroup_top= (RadioGroup) findViewById(R.id.main_top_rg);
        rb01_top= (RadioButton) findViewById(R.id.main_top_rb1);
        rb02_top= (RadioButton) findViewById(R.id.main_top_rb2);
        rb03_top= (RadioButton) findViewById(R.id.main_top_rb3);
        rb04_top= (RadioButton) findViewById(R.id.main_top_rb4);
        rb05_top= (RadioButton) findViewById(R.id.main_top_rb5);
        rb06_top= (RadioButton) findViewById(R.id.main_top_rb6);
        rb07_top= (RadioButton) findViewById(R.id.main_top_rb7);
        rb08_top= (RadioButton) findViewById(R.id.main_top_rb8);
        rb09_top= (RadioButton) findViewById(R.id.main_top_rb9);
        rb10_top= (RadioButton) findViewById(R.id.main_top_rb10);

        rb01_top.setChecked(true);

        viewPager_center= (ViewPager) findViewById(R.id.main_center_vp);
        radioGroup_bottom= (RadioGroup) findViewById(R.id.main_bottom_rg);
        rb01_bottom= (RadioButton) findViewById(R.id.main_bottom_rb1);
        rb02_bottom= (RadioButton) findViewById(R.id.main_bottom_rb2);
        rb03_bottom= (RadioButton) findViewById(R.id.main_bottom_rb3);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int chickedId) {
        switch (chickedId){
            case R.id.main_top_rb1:
                viewPager_center.setCurrentItem(0);
                Toast.makeText(MainActivity.this, "top rb01", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb2:
                viewPager_center.setCurrentItem(1);
                Toast.makeText(MainActivity.this, "top rb02", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb3:
                viewPager_center.setCurrentItem(2);
                Toast.makeText(MainActivity.this, "top rb03", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb4:
                viewPager_center.setCurrentItem(3);
                Toast.makeText(MainActivity.this, "top rb04", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb5:
                viewPager_center.setCurrentItem(4);
                Toast.makeText(MainActivity.this, "top rb05", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb6:
                viewPager_center.setCurrentItem(5);
                Toast.makeText(MainActivity.this, "top rb06", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb7:
                viewPager_center.setCurrentItem(6);
                Toast.makeText(MainActivity.this, "top rb07", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb8:
                viewPager_center.setCurrentItem(7);
                Toast.makeText(MainActivity.this, "top rb08", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb9:
                viewPager_center.setCurrentItem(8);
                Toast.makeText(MainActivity.this, "top rb09", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb10:
                viewPager_center.setCurrentItem(9);
                Toast.makeText(MainActivity.this, "top rb010", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_bottom_rb1:

                Toast.makeText(MainActivity.this, "bottom rb01", Toast.LENGTH_SHORT).show();
                horizontalScrollView_top.smoothScrollTo(0,0);
                break;
            case R.id.main_bottom_rb2:

                Toast.makeText(MainActivity.this, "bottom rb02", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_bottom_rb3:

                Toast.makeText(MainActivity.this, "bottom rb03", Toast.LENGTH_SHORT).show();
                break;
        }

    }



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    //选择的页面
    @Override
    public void onPageSelected(int position) {
        //顶部滚动条出现移动效果
        horizontalScrollView_top.setVisibility(View.VISIBLE);
        radioGroup_top.setVisibility(View.VISIBLE);

        //获得当前Viewpager对应的RadioButton

        RadioButton radioButton= (RadioButton) radioGroup_top.getChildAt(position);

        radioButton.setChecked(true);
        //让顶部的RadioButton随着ViewPager一起滚动
        int left=radioButton.getLeft();
        //向左移动
        horizontalScrollView_top.smoothScrollTo(left,0);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
