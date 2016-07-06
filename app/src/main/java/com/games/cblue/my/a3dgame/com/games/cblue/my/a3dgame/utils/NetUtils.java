package com.games.cblue.my.a3dgame.com.games.cblue.my.a3dgame.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by my on 2016/7/6.
 * 连接网络
 */
public class NetUtils {

    public static boolean netConnect(Activity activity) {
        boolean flag = false;
        //得到链接的管理对象
        ConnectivityManager connectivityManager = (ConnectivityManager) activity.getApplicationContext().
                getSystemService(Context.CONNECTIVITY_SERVICE);
        //如果链接的管理对象为空，直接返回
        if (connectivityManager == null) {
            return flag;
        }
        //根据链接的管理对象得到网络的信息对象
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        //如果链接的信息对象不为空，或链接的信息对象是活动的，说明网络链接成功
        if (networkInfo != null || networkInfo.isAvailable()) {
            flag = true;
        }

        return flag;
    }

}
