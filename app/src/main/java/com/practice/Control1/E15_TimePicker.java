package com.practice.Control1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

import com.practice.R;

public class E15_TimePicker extends AppCompatActivity {


    TimePicker tp;
    TextView label;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e15_time_picker);


        tp = findViewById(R.id.E15_tp);
        label = findViewById(R.id.E15_lbl);


        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                String s="";

                s = String.valueOf(i)+" : "+String.valueOf(i1);
                label.setText(s);

            }
        });
    }
}