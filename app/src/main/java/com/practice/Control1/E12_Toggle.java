package com.practice.Control1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.practice.R;

public class E12_Toggle extends AppCompatActivity {
ToggleButton tg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e12_toggle);

        tg=findViewById(R.id.E12_tg);

        tg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b==true){
                    Toast.makeText(E12_Toggle.this, "1", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(E12_Toggle.this, "0", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}