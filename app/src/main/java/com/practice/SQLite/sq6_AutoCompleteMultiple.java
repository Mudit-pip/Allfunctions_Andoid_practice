package com.practice.SQLite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MultiAutoCompleteTextView;

import com.practice.R;

public class sq6_AutoCompleteMultiple extends AppCompatActivity {

    MultiAutoCompleteTextView mact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sq6_auto_complete_multiple);

        mact = findViewById(R.id.sq6_multitext);


    }
}