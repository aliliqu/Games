package com.games.cblue.my.a3dgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Toast;

import com.games.cblue.my.a3dgame.com.games.cblue.my.a3dgame.service.DownloadService;
import com.games.cblue.my.a3dgame.com.games.cblue.my.a3dgame.utils.NetUtils;

import pl.droidsonroids.gif.GifImageView;

public class WelcomeActivity extends AppCompatActivity {
    //声明GIF动画
    GifImageView gifImageView;
    //声明动画
    Animation animation;
    //判断网络是否打开
    boolean netOPen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        gifImageView= (GifImageView) findViewById(R.id.activity_welcome);
        animation=new AlphaAnimation(0,1.0f);
        //设置时间
        animation.setDuration(3000);
        //启动
        gifImageView.startAnimation(animation);
        //给动画添监听
        animation.setAnimationListener(new Animation.AnimationListener() {

            //动画开始
            @Override
            public void onAnimationStart(Animation animation) {
                netOPen= NetUtils.netConnect(WelcomeActivity.this);
                if (netOPen){
                    //开始Service 下载数据
                    Intent downloadServiceintent=new Intent(WelcomeActivity.this,DownloadService.class);
                    startService(downloadServiceintent);
                }

            }
            //动画结束
            @Override
            public void onAnimationEnd(Animation animation) {
                if (!netOPen){
                    Toast.makeText(WelcomeActivity.this,"请连接你的网络！",Toast.LENGTH_LONG).show();

                }
                //判断是否是第一次登录
                isFristLogin();
            }
            //动画重复的时候
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });



    }

    public void isFristLogin() {
        SharedPreferences sharedPreferences=getSharedPreferences("isFirstLogin",MODE_PRIVATE);
        boolean isLogin=sharedPreferences.getBoolean("isLogin",false);
        //如果第一次登录就跳转到引到页面，否则的话跳转到主界面
        if(!isLogin){
            Intent guideIntent=new Intent(WelcomeActivity.this,GuideActivity.class);
            startActivity(guideIntent);
            finish();
        }else {
            Intent mainIntent=new Intent(WelcomeActivity.this,MainActivity.class);
            startActivity(mainIntent);
            finish();
        }


    }
}
