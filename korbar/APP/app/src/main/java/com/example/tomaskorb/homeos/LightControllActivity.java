package com.example.tomaskorb.homeos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class LightControllActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_controll);

        ((SeekBar)findViewById(R.id.Light1BrightnessController)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {

                ((LightImageView)findViewById(R.id.Light1Brightness)).PercentOfLight = progress;
                ((LightImageView)findViewById(R.id.Light1Brightness)).RedrawLightness();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });







    }



}
