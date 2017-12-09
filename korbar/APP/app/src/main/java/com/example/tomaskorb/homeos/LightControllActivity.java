package com.example.tomaskorb.homeos;

import android.app.Activity;
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

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

public class LightControllActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_controll);

        new AsyncGetLightTasks().execute();







        ((SeekBar)findViewById(R.id.Light1BrightnessController)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {

                ((LightImageView)findViewById(R.id.Light1Brightness)).PercentOfLight = progress;
                ((LightImageView)findViewById(R.id.Light1Brightness)).RedrawLightness();
                new AsyncLightTasks().execute("1",String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ((SeekBar)findViewById(R.id.Light2BrightnessController)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {

                ((LightImageView)findViewById(R.id.Light2Brightness)).PercentOfLight = progress;
                ((LightImageView)findViewById(R.id.Light2Brightness)).RedrawLightness();
                new AsyncLightTasks().execute("2",String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ((SeekBar)findViewById(R.id.Light3BrightnessController)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {

                ((LightImageView)findViewById(R.id.Light3Brightness)).PercentOfLight = progress;
                ((LightImageView)findViewById(R.id.Light3Brightness)).RedrawLightness();
                new AsyncLightTasks().execute("3",String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ((SeekBar)findViewById(R.id.Light4BrightnessController)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {

                ((LightImageView)findViewById(R.id.Light4Brightness)).PercentOfLight = progress;
                ((LightImageView)findViewById(R.id.Light4Brightness)).RedrawLightness();
                new AsyncLightTasks().execute("4",String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private class AsyncLightTasks extends AsyncTask<String, String, String>
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

                url = new URL("http://10.10.5.234/api/api/light?id="+params[0]+"&value="+params[1]);

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
                        .appendQueryParameter("id", params[0])
                        .appendQueryParameter("value", params[1])
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
        protected void onPostExecute(String result) {
            Log.e("pausda","asdasd");
        }

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
                obj2 = json2array.getJSONObject(0);
                ((SeekBar)findViewById(R.id.Light1BrightnessController)).setProgress(obj2.getInt("argument"));
                ((LightImageView)findViewById(R.id.Light1Brightness)).PercentOfLight = obj2.getInt("argument");
                ((LightImageView)findViewById(R.id.Light1Brightness)).RedrawLightness();

                json2array = kappa.getJSONArray(1);
                obj2 = json2array.getJSONObject(0);
                ((SeekBar)findViewById(R.id.Light2BrightnessController)).setProgress(obj2.getInt("argument"));
                ((LightImageView)findViewById(R.id.Light2Brightness)).PercentOfLight = obj2.getInt("argument");
                ((LightImageView)findViewById(R.id.Light2Brightness)).RedrawLightness();

                json2array = kappa.getJSONArray(2);
                obj2 = json2array.getJSONObject(0);
                ((SeekBar)findViewById(R.id.Light3BrightnessController)).setProgress(obj2.getInt("argument"));
                ((LightImageView)findViewById(R.id.Light3Brightness)).PercentOfLight = obj2.getInt("argument");
                ((LightImageView)findViewById(R.id.Light3Brightness)).RedrawLightness();

                json2array = kappa.getJSONArray(3);
                obj2 = json2array.getJSONObject(0);
                ((SeekBar)findViewById(R.id.Light4BrightnessController)).setProgress(obj2.getInt("argument"));
                ((LightImageView)findViewById(R.id.Light4Brightness)).PercentOfLight = obj2.getInt("argument");
                ((LightImageView)findViewById(R.id.Light4Brightness)).RedrawLightness();

                Log.e("pause msg","asdas");



            }
            catch (Exception e)
            {
                Log.e("Chyba",e.getMessage());
            }

            Log.e("pausda","asdasd");
        }

    }





}
