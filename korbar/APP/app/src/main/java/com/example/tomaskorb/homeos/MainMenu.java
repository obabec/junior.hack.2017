package com.example.tomaskorb.homeos;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;

public class MainMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.android_icon)
                        .setContentTitle("Your house notification")
                        .setContentText("I think that in living room is cold, would you like me to put the heating on?")
                        .setDefaults(Notification.DEFAULT_SOUND);

        Intent intnt = new Intent(MainMenu.this,HeatingActivity.class);
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        this,
                        0,
                        intnt,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );


        mBuilder.setContentIntent(resultPendingIntent);

        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

       // mNotifyMgr.notify(1,mBuilder.build());

    }

    public void StartLightControll(View v)
    {
        Intent intnt = new Intent(MainMenu.this,LightControllActivity.class);
        startActivity(intnt);
    }

    public void StartLockControll(View v)
    {
        Intent intnt = new Intent(MainMenu.this,LockControllActivity.class);
        startActivity(intnt);
    }

    public void StartWaterControll(View v)
    {
        Intent intnt = new Intent(MainMenu.this,WaterControllActivity.class);
        startActivity(intnt);
    }

    public void StartHeatingControll(View v)
    {
        Intent intnt = new Intent(MainMenu.this,HeatingActivity.class);
        startActivity(intnt);
    }

    public void StartPayments(View v)
    {
        Intent intnt = new Intent(MainMenu.this,PaymentsControll.class);
        startActivity(intnt);
    }





}
