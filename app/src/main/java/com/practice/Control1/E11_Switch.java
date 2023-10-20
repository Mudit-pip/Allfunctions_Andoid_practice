package com.practice.Control1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.practice.R;

public class E11_Switch extends AppCompatActivity {
    Switch sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e11_switch);

        sw=findViewById(R.id.E11_sw);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b==true)
                    Toast.makeText(E11_Switch.this, "YESYES", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(E11_Switch.this, "NoNo", Toast.LENGTH_SHORT).show();
            }
        });
    }
}