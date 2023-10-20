package com.practice.PHPApi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.practice.R;

public class PhpM6_Logout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_php_m6_logout);

        SharedPreferences pref=getSharedPreferences("PrefPHP",MODE_PRIVATE);
        SharedPreferences.Editor editor= pref.edit();
        editor.putBoolean("IsLogin",false);


        startActivity(new Intent(this, PhpM2_Login.class));

        editor.commit();

    }
}