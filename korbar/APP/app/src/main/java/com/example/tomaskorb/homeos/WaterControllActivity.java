package com.example.tomaskorb.homeos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;

public class WaterControllActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_controll);

        ((Switch)findViewById(R.id.Switch1)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {
                    ((CheckBox)findViewById(R.id.checkBox1)).setChecked(true);
                }
                else
                {
                    ((CheckBox)findViewById(R.id.checkBox1)).setChecked(false);
                }
            }
        });

        ((Switch)findViewById(R.id.Switch2)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {
                    ((CheckBox)findViewById(R.id.checkBox2)).setChecked(true);
                }
                else
                {
                    ((CheckBox)findViewById(R.id.checkBox2)).setChecked(false);
                }
            }
        });
        ((Switch)findViewById(R.id.Switch3)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {
                    ((CheckBox)findViewById(R.id.checkBox3)).setChecked(true);
                }
                else
                {
                    ((CheckBox)findViewById(R.id.checkBox3)).setChecked(false);
                }
            }
        });
        ((Switch)findViewById(R.id.Switch4)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {
                    ((CheckBox)findViewById(R.id.checkBox4)).setChecked(true);
                }
                else
                {
                    ((CheckBox)findViewById(R.id.checkBox4)).setChecked(false);
                }
            }
        });
    }





}
