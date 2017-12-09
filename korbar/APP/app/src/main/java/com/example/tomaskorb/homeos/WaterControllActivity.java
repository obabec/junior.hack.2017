package com.example.tomaskorb.homeos;

import android.app.Activity;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;

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

public class WaterControllActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_controll);

        new AsyncGetLightTasks().execute();


        ((Switch)findViewById(R.id.Switch1)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {
                    ((CheckBox)findViewById(R.id.checkBox1)).setChecked(true);
                    new AsyncLightTasks().execute("7","1");
                }
                else
                {
                    ((CheckBox)findViewById(R.id.checkBox1)).setChecked(false);
                    new AsyncLightTasks().execute("7","0");
                }
            }
        });

        ((Switch)findViewById(R.id.Switch2)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {
                    ((CheckBox)findViewById(R.id.checkBox2)).setChecked(true);
                    new AsyncLightTasks().execute("8","1");
                }
                else
                {
                    ((CheckBox)findViewById(R.id.checkBox2)).setChecked(false);
                    new AsyncLightTasks().execute("8","0");
                }
            }
        });
        ((Switch)findViewById(R.id.Switch3)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {
                    ((CheckBox)findViewById(R.id.checkBox3)).setChecked(true);
                    new AsyncLightTasks().execute("9","1");
                }
                else
                {
                    ((CheckBox)findViewById(R.id.checkBox3)).setChecked(false);
                    new AsyncLightTasks().execute("9","0");
                }
            }
        });
        ((Switch)findViewById(R.id.Switch4)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {
                    ((CheckBox)findViewById(R.id.checkBox4)).setChecked(true);
                    new AsyncLightTasks().execute("10","1");
                }
                else
                {
                    ((CheckBox)findViewById(R.id.checkBox4)).setChecked(false);
                    new AsyncLightTasks().execute("10","0");
                }
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
                obj2 = json2array.getJSONObject(6);

                ((CheckBox)findViewById(R.id.checkBox1)).setChecked((obj2.getInt("argument")==1?true:false));
                ((Switch)findViewById(R.id.Switch1)).setChecked((obj2.getInt("argument")==1?true:false));


                obj2 = json2array.getJSONObject(7);
                ((CheckBox)findViewById(R.id.checkBox2)).setChecked((obj2.getInt("argument")==1?true:false));
                ((Switch)findViewById(R.id.Switch2)).setChecked((obj2.getInt("argument")==1?true:false));



                obj2 = json2array.getJSONObject(8);
                ((CheckBox)findViewById(R.id.checkBox3)).setChecked((obj2.getInt("argument")==1?true:false));
                ((Switch)findViewById(R.id.Switch3)).setChecked((obj2.getInt("argument")==1?true:false));



                obj2 = json2array.getJSONObject(9);
                ((CheckBox)findViewById(R.id.checkBox4)).setChecked((obj2.getInt("argument")==1?true:false));
                ((Switch)findViewById(R.id.Switch4)).setChecked((obj2.getInt("argument")==1?true:false));

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
