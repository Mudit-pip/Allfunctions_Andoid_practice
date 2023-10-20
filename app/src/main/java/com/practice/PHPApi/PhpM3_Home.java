package com.practice.PHPApi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.practice.R;

public class PhpM3_Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_php_m3_home);

        SharedPreferences pref = getSharedPreferences("PrefPHP", MODE_PRIVATE);
        if (pref.getBoolean("IsLogin", false) == false) {
            startActivity(new Intent(this, PhpM2_Login.class));
        }

    }

    public void PhpM3_fun_EditProfile(View view) {
        startActivity(new Intent(this, PhpM4_EditProfile.class));

    }

    public void PhpM3_fun_ChangePassword(View view) {
        startActivity(new Intent(this, PhpM5_ChangePassword.class));
    }

    public void PhpM3_fun_Logout(View view) {
        SharedPreferences pref=getSharedPreferences("PrefPHP",MODE_PRIVATE);
        SharedPreferences.Editor editor= pref.edit();

        editor.putString("RegId","");
        editor.putBoolean("IsLogin",false);

        editor.commit();

        startActivity(new Intent(this, PhpM2_Login.class));
        finish();

    }

    public void PhpM3_fun_Products(View view) {
        startActivity(new Intent(this, PhpM7_Products.class));
    }


}