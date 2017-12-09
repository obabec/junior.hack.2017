package com.example.tomaskorb.homeos;

import android.app.Activity;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.SeekBar;
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

public class PaymentsControll extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments_controll);


        new AsyncGetLightTasks().execute();
        new AsyncGetWaterTasks().execute();

        final Handler handler = new Handler();
        final int delay = 2000; //milliseconds

        handler.postDelayed(new Runnable(){
            public void run(){

                new AsyncGetLightTasks().execute();
                new AsyncGetWaterTasks().execute();

                handler.postDelayed(this, delay);
            }
        }, delay);


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

                url = new URL("http://10.10.5.234/api/api/watt");

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
                JSONObject obj2 = pole.getJSONObject(0);
                ((TextView)findViewById(R.id.EnergyConsumptionTextView)).setText(String.valueOf(obj2.getDouble("output"))+" W/h");
                Log.e("pausda","asdasd");

            }
            catch (Exception e)
            {
                Log.e("Chyba",e.getMessage());
            }


            Log.e("pausda","asdasd");
        }

    }

    private class AsyncGetWaterTasks extends AsyncTask<String, String, String>
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

                url = new URL("http://10.10.5.234/api/api/read-lights");

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
                JSONArray json2array;
                JSONObject obj2;

                JSONObject obj = new JSONObject(result);
                JSONArray kappa = obj.getJSONArray("data");
                json2array = kappa.getJSONArray(0);
                obj2 = json2array.getJSONObject(11);
                ((TextView)findViewById(R.id.WaterConsumptionTextView)).setText(String.valueOf(obj2.getDouble("argument")/100)+" m3");


            }
            catch (Exception e)
            {
                Log.e("Chyba",e.getMessage());
            }

            Log.e("pausda","asdasd");
        }

    }


}
