package com.example.elshiekho.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.time.Duration;

public class MyService extends Service {

    private final IBinder iBinder = new MyLocalBinder();
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("adsasd","bound");
        return iBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        final MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.notif);
        Toast.makeText(getApplicationContext(),"ya rab el7amdolelah", Toast.LENGTH_LONG).show();
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {

        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    public class MyLocalBinder extends Binder {
        MyService getmyService() {
            return MyService.this;
        }
    }
}
