package com.lianxi.zy.myrookie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.lianxi.zy.myrookie.R;

public class LogActivity extends AppCompatActivity {
    int reclen=2;
    Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_log);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //调用一次数字减一
                reclen--;
                if(reclen<0)
                {
                    //三秒后跳转页面
                    Intent intent=new Intent(LogActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
                //设置一秒调用一次
                handler.postDelayed(this,1000);
            }
        },1000);
    }
}
