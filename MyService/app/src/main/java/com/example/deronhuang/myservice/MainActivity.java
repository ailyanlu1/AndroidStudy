package com.example.deronhuang.myservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    private Button star;
    private Button stop;
    private Button bind;
    private Button unbind;

    private MyService.MyBinder mBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("ServiceConnection","onServiceConnection");
            mBinder = (MyService.MyBinder)service;
            mBinder.service_connect_activity();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("ServiceConnection","onServiceDisconnected，ComponentName="+name.toString());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        star = (Button)findViewById(R.id.starService);
        stop = (Button)findViewById(R.id.stopService);
        bind = (Button)findViewById(R.id.bindService);
        unbind = (Button)findViewById(R.id.unbindService);

        star.setOnClickListener(this);
        stop.setOnClickListener(this);
        bind.setOnClickListener(this);
        unbind.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.starService:
                Intent starSrv = new Intent(this,MyService.class);
                startService(starSrv);
                break;
            case R.id.stopService:
                Intent stopSvr =  new Intent(this,MyService.class);
                stopService(stopSvr);
                break;
            case R.id.bindService:
                Intent bindSvr = new Intent(this,MyService.class);
                bindService(bindSvr,connection,BIND_AUTO_CREATE);
                break;
            case R.id.unbindService:
                unbindService(connection);
                break;
            default:
                break;
        }
    }
}
