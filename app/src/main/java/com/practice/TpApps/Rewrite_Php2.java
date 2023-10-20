package com.practice.TpApps;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import com.practice.R;

public class Rewrite_Php2 extends AppCompatActivity {
ListView lst;
String[] arName;
String url = "http://PHPAPI.anantanantsports.com/getcategoryList.php";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewrite_php2);

        lst = findViewById(R.id.Rewrite_php2_list);

    }
}