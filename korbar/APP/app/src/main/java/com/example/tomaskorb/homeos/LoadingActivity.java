package com.example.tomaskorb.homeos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class LoadingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        Glide.with(this).asGif().load(R.drawable.home_os_mobile).into((ImageView)findViewById(R.id.GifViewer));

        new CountDownTimer(6000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                Intent Zamer = new Intent(LoadingActivity.this,MainMenu.class);
                startActivity(Zamer);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        }.start();

    }
}
