package com.example.tomaskorb.homeos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }


    public void StartLightControll(View v)
    {
        Intent intnt = new Intent(MainMenu.this,LightControllActivity.class);
        startActivity(intnt);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }

    public void StartLockControll(View v)
    {
        Intent intnt = new Intent(MainMenu.this,LockControllActivity.class);
        startActivity(intnt);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }





}
