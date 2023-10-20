package com.practice.Control1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import com.practice.R;

public class E13_DatePicker extends AppCompatActivity {
DatePicker dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e13_date_picker);

        dp=findViewById(R.id.E13_dp);

        dp.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int sYear, int sMonth, int sDay) {
                String s;

                s=String.valueOf(sDay)+":"+String.valueOf(sMonth)+":"+String.valueOf(sYear);
                Toast.makeText(E13_DatePicker.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}