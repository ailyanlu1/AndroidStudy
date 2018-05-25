package com.example.deronhuang.myservice;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txview = (TextView)findViewById(R.id.text_view);
        txview.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.text_view:
                Intent starSrv = new Intent(this,MyService.class);
                startService(starSrv);
                break;
            default:
                break;
        }
    }
}
