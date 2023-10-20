package com.practice.Control1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.practice.R;

public class E25_spinner extends AppCompatActivity {
    Spinner spn;
    String[] arCity = {"abc", "sdf", "sdfs", "sdfsfdsf"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e25_spinner);

        spn = findViewById(R.id.E25_spn);

        ArrayAdapter<String> adpt=new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,arCity);
        spn.setAdapter(adpt);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String s = ((TextView)view).getText().toString();
                Toast.makeText(E25_spinner.this, s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(E25_spinner.this, "sfsfsfsfdf", Toast.LENGTH_SHORT).show();
            }
        });
    }
}