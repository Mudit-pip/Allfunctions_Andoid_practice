package com.practice.Control1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

import com.practice.R;

public class E30_MultiAutoText extends AppCompatActivity {

    MultiAutoCompleteTextView mt;
    String[] comp = {"a", "ab", "abc","abcd","abcde"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e30_multi_auto_text);

        mt = findViewById(R.id.E30_autocomp);

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,comp);
        mt.setAdapter(adapt);
        mt.setThreshold(1);

        mt.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());


    }
}