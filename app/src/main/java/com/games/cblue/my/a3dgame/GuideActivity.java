package com.games.cblue.my.a3dgame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.games.cblue.my.a3dgame.com.games.cblue.my.a3dgame.adpater.GuideViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    ViewPager guideViewPage;
    GuideViewPagerAdapter guideViewPagerAdapter;
    List<View> views;
    LayoutInflater layoutInflater;
    ImageView[] dots;
    //当前页面的索引
    int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        //初始化view
        initView();
        //初始化所有的点
        initDot();

    }
    //初始化所有的点
    private void initDot() {
        LinearLayout ll= (LinearLayout) findViewById(R.id.guide_dot_ll);
        dots=new ImageView[views.size()];
    //得到线性布局下面的所有点对象
        for (int i=0;i<views.size();i++){
            //用getChildAt（index）获取指定position的view
            dots[i]= (ImageView) ll.getChildAt(i);
            //对每一个点对象设置
            dots[i].setEnabled(true);
        }
        //初始化当前所在page的索引值
        currentIndex=0;
        //设置当前的page是白色
        dots[currentIndex].setEnabled(false);

    }

    //初始化View
    private void initView() {
        guideViewPage = (ViewPager) findViewById(R.id.guide_viewpager);

        views = new ArrayList<View>();

        layoutInflater = LayoutInflater.from(this);
        //将样式转化成view
        View view1 = layoutInflater.inflate(R.layout.activity_guide_page01, null);
        View view2 = layoutInflater.inflate(R.layout.activity_guide_page02, null);
        View view3 = layoutInflater.inflate(R.layout.activity_guide_page03, null);
        //将转化的view加入list集合
        views.add(view1);
        views.add(view2);
        views.add(view3);
        //声明自定义适配器
        guideViewPagerAdapter = new GuideViewPagerAdapter(views);
        //填充适配器
        guideViewPage.setAdapter(guideViewPagerAdapter);
        //添加监听
        guideViewPage.addOnPageChangeListener(this);


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    //页面选择
    @Override
    public void onPageSelected(int position) {
        //设置底部显示点的颜色
        if (position < 0 || position + 1 > views.size()) {
                return;
        }
        //设置当前位置为选中状态
        dots[position].setEnabled(false);
        //设置之前位置为非选中状态
        dots[currentIndex].setEnabled(true);
        currentIndex=position;

        //添加最后一个引导界面的button监听
        if(position==views.size()-1){
            Button btn= (Button) views.get(position).findViewById(R.id.guide_page3_btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //保存一个登陆的信息
                    setGuide();
                    //跳转
                    Intent mainintent=new Intent(GuideActivity.this,MainActivity.class);
                    Log.i("aaa","声明信息");
                    startActivity(mainintent);
                    Log.i("aaa","跳转完毕");
                    finish();
                }

            });


        }


    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    //保存一个登陆过的记录
    private void setGuide() {
        //轻量级数据存储技术 实例化SharedPreferences对象
        SharedPreferences sharedPreferences = getSharedPreferences("isFirstLogin", Context.MODE_PRIVATE);
        //实例化SharedPreferences.Editor 对象
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //用putxxx  方法保存
        editor.putBoolean("isFirst", false);
        //提交当前数据
        editor.commit();
        Log.i("aaa","信息保存完毕");
    }
}
