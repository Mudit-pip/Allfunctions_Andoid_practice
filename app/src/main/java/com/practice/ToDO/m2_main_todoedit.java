package com.practice.ToDO;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.practice.R;

public class m2_main_todoedit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m2_main_todoedit);


        Intent kk=getIntent();

        String id=kk.getStringExtra("Id");
        String task=kk.getStringExtra("Task");

        Toast.makeText(this, task, Toast.LENGTH_SHORT).show();



    }
}