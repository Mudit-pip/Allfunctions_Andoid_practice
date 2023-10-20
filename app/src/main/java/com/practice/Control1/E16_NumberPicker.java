package com.practice.Control1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.practice.R;

public class E16_NumberPicker extends AppCompatActivity {
NumberPicker np;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e16_number_picker);

        np=findViewById(R.id.E16_np);

        np.setMinValue(20);
        np.setMaxValue(50);
        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                Toast.makeText(E16_NumberPicker.this, i+" :old----new: "+i1 , Toast.LENGTH_SHORT).show();
            }
        });
    }
}