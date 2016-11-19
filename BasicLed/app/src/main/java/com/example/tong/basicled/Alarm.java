package com.example.tong.basicled;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

/**
 * Created by tong on 2016/11/15.
 */
public class Alarm extends Activity{
    private Button btn_set_clock,btn_cancel;
    private Calendar cal;
    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm);
        cal = Calendar.getInstance();
        btn_cancel = (Button) findViewById(R.id.btn_cancel);
        btn_set_clock = (Button) findViewById(R.id.btn_set_clock);
        btn_set_clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TimePickerDialog(Alarm.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        btn_set_clock.setText(i+":"+i1);
                    }
                },cal.get(Calendar.HOUR_OF_DAY),cal.get(Calendar.MINUTE),true ).show();
            }
        });
    }
}
