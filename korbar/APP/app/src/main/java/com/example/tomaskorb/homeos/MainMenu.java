package com.example.tomaskorb.homeos;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                new AsyncGetLightTasks().execute();

            }
        }.start();

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

    private class AsyncGetLightTasks extends AsyncTask<String, String, String>
    {

        HttpURLConnection conn;
        URL url = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }
        @Override
        protected String doInBackground(String... params) {
            try {

                url = new URL("http://10.10.5.234/api/api/?action=events");

            } catch (MalformedURLException e) {

                e.printStackTrace();
                Log.e("hlaska","Spatne url");
                return "exception";

            }
            try {

                conn = (HttpURLConnection)url.openConnection();
                conn.setReadTimeout(10000);
                conn.setConnectTimeout(10000);
                conn.setRequestMethod("POST");


                conn.setDoInput(true);
                conn.setDoOutput(true);


                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("id", " ")
                        .appendQueryParameter("value", " ")
                        ;
                String query = builder.build().getEncodedQuery();


                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();
                conn.connect();

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                Log.e("hlaska","Nemozno se pripojit");
                return "exception";
            }

            try {

                int response_code = conn.getResponseCode();


                if (response_code == HttpURLConnection.HTTP_OK) {
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }


                    return(result.toString());

                }else{
                    return("unsuccessful");
                }

            } catch (IOException e) {
                // e.printStackTrace();
                Log.e("Chyba",e.getMessage());
                return "exception";
            } finally {
                conn.disconnect();
            }
        }

        @Override
        protected void onPostExecute(String result)
        {
            try
            {
                JSONObject obj = new JSONObject(result);
                JSONArray pole = obj.getJSONArray("data");
                JSONArray pole2 = pole.getJSONArray(0);
                Log.e("pausda","asdasd");
                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(MainMenu.this)
                                .setSmallIcon(R.drawable.android_icon)
                                .setContentTitle("Temperature notification")
                                .setContentText("Isnt " + pole2.getJSONObject(0).getInt("argument")+"°C low for you? Click for change!")
                                .setDefaults(Notification.DEFAULT_SOUND);

                Intent intnt = new Intent(MainMenu.this,HeatingActivity.class);
                PendingIntent resultPendingIntent =
                        PendingIntent.getActivity(
                                MainMenu.this,
                                0,
                                intnt,
                                PendingIntent.FLAG_UPDATE_CURRENT
                        );


                mBuilder.setContentIntent(resultPendingIntent);

                NotificationManager mNotifyMgr =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                mNotifyMgr.notify(1,mBuilder.build());


            }
            catch (Exception e)
            {
                Log.e("Chyba",e.getMessage());
            }


            Log.e("pausda","asdasd");
        }

    }



}
