package com.games.cblue.my.a3dgame.com.games.cblue.my.a3dgame.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by my on 2016/7/6.
 */
public class DownloadService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("aaa","数据下载Service");
        return super.onStartCommand(intent, flags, startId);
    }


}
