package com.example.deronhuang.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by deronhuang on 2018/6/1.
 */

public class AIDLService extends Service {


    AIDL_Service.Stub mBinder = new AIDL_Service.Stub() {
        @Override
        public void AIDL_Service_Base() throws RemoteException {
            Log.i("AIDLService","AIDL_Service_Base");
        }

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }
    };

    @Override
    public void onCreate() {
        Log.i("AIDLService","onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("AIDLService","onStratCommad");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("AIDLService","onDestroy");
        super.onDestroy();
    }

    @Override
    public void onRebind(Intent intent) {
        Log.i("AIDLService","onRebind");
        super.onRebind(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("AIDLService","onBinder");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("AIDLService","onUnbind");
        return super.onUnbind(intent);
    }
}
