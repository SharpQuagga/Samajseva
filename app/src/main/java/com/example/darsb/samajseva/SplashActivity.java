package com.example.darsb.samajseva;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        handler.sendEmptyMessageDelayed(101,3000);
        imageView =findViewById(R.id.imageView);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        imageView.startAnimation(animation);
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 101){
                Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };


}

