package com.example.deronhuang.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

import java.io.FileDescriptor;

public class MyService extends Service {

    private MyBinder mBinder = new MyBinder();

    public MyService() {

    }

    @Override
    public void onCreate() {
        Log.i("Service","Service onCreate.");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("Service","Service onStartCommand : startId="+startId);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("Service","onDestroy");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("Service","onUnbind");
        return super.onUnbind(intent);
    }

    class MyBinder extends Binder {
        public void service_connect_activity(){
            Log.i("MyBinder","Service关联了Activity,并在Activity执行了Service的方法");
        }
    }
}
