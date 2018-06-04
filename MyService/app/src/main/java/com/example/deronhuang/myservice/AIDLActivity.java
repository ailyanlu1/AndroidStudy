package com.example.deronhuang.myservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class AIDLActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bindSvr;
    private Button unbindSvr;

    private AIDL_Service mBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mBinder = AIDL_Service.Stub.asInterface(service);
            try {
                mBinder.AIDL_Service_Base();
            }catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);

        bindSvr = (Button)findViewById(R.id.bindAIDLService);
        unbindSvr = (Button)findViewById(R.id.unbindAIDLService);

        bindSvr.setOnClickListener(this);
        unbindSvr.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bindAIDLService:
                Intent intent = new Intent("com.example.deronhuang.myservice.aidl");
                intent.setPackage("com.example.deronhuang.myservice");
                Boolean bindRes = bindService(intent,connection, Context.BIND_AUTO_CREATE);
                Log.i("AIDLActivity","BindAIDLService result = " + bindRes);
                break;
            case R.id.unbindAIDLService:
                unbindService(connection);
                Log.i("AIDLActivity","unbindAIDLService");
                break;
            default:
                break;
        }
    }
}
