package com.threadpool.deronhuang.threadpool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button startBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (Button)findViewById(R.id.start);
        startBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.start:
                TestThreadPool();
                break;
            default:
                break;
        }
    }

    public void TestThreadPool() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,20, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(5));

        for(int i = 0 ; i < 15 ; ++i){
            MyTask task = new MyTask(i);
            executor.execute(task);
            Log.i("MyTask","线程池里面的线程数目：" + executor.getPoolSize() + ",队列里面等待的任务数目："+executor.getQueue().size() + ",已经执行完的任务数目："+executor.getCompletedTaskCount());
        }

    }

    public class MyTask implements Runnable{

        private int taskNum;

        public MyTask(int num) {
            taskNum = num;
        }

        @Override
        public void run() {
            Log.i("MyTask","正在执行 task = " + taskNum);
            try {
                Thread.currentThread().sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            Log.i("MyTask","任务执行完毕 task = " + taskNum);
        }
    }
}
