package com.example.mina.newstoday.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.mina.newstoday.R;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
       Thread thread=new Thread(){
           @Override
           public void run() {
               try {
                   sleep(2000);
                   Intent intent=new Intent(splashScreen.this,MainActivity.class);
                   startActivity(intent);
                   finish();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       };
       thread.start();
    }

}
