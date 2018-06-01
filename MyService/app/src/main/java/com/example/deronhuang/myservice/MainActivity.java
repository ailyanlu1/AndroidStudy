package com.example.deronhuang.myservice;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    private Button star;
    private Button stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        star = (Button)findViewById(R.id.starService);
        stop = (Button)findViewById(R.id.stopService);

        star.setOnClickListener(this);
        stop.setOnClickListener(this);
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
            default:
                break;
        }
    }
}
