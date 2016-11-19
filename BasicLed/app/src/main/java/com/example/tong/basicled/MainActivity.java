package com.example.tong.basicled;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private SeekBar seekBar_red;
    private SeekBar seekBar_green;
    private SeekBar seekBar_blue;
    private Button clock_btn;
    private TextView red_scale,blue_scale,green_scale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar_blue = (SeekBar) findViewById(R.id.seek_blu);
        seekBar_green = (SeekBar) findViewById(R.id.seek_gre);
        seekBar_red = (SeekBar) findViewById(R.id.seek_red);
        red_scale = (TextView) findViewById(R.id.red_scale);
        blue_scale = (TextView) findViewById(R.id.blu_scale);
        green_scale = (TextView) findViewById(R.id.gre_scale);
        clock_btn = (Button) findViewById(R.id.clock_btn);
        seekBar_blue.setOnSeekBarChangeListener(this);
        seekBar_red.setOnSeekBarChangeListener(this);
        seekBar_green.setOnSeekBarChangeListener(this);
        clock_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Alarm.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch (seekBar.getId()){
            case R.id.seek_red:
                red_scale.setText(i+"%");
                break;
            case R.id.seek_gre:
                green_scale.setText(i+"%");
                break;
            case R.id.seek_blu:
                blue_scale.setText(i+"%");
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
