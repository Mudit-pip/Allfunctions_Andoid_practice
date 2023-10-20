package com.practice.Control1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.AutoText;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import com.practice.R;

public class E29_AutoText extends AppCompatActivity {

    AutoCompleteTextView atxt;
    String[] comp = {"a", "ab", "abc","abcd","abcde"};

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e29_auto_text);

        atxt = findViewById(R.id.E29_lst);

        ArrayAdapter<String> adpt = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,comp);
        atxt.setAdapter(adpt);
        atxt.setThreshold(1);
    }
}