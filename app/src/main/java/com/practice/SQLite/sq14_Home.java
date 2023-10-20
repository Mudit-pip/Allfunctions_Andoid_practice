package com.practice.SQLite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.practice.R;

public class sq14_Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sq14_home);

        SharedPreferences pref = getSharedPreferences("pref_isSaved", MODE_PRIVATE);
        Boolean isSave=pref.getBoolean("IsSaved",false);

        if(isSave==false)
            startActivity(new Intent(this, sq13_Login.class));

    }

    public void sq14_EditProfile(View view) {
        startActivity(new Intent(this, sq15_EditProfile.class));
    }

    public void sq14_ChangePassword(View view) {
        startActivity(new Intent(this, sq16_ChangePassword.class));
    }

    public void sq14_Logout(View view) {
        SharedPreferences pref = getSharedPreferences("pref_isSaved1", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove("RegId");
        editor.remove("IsSaved");
        editor.commit();

        startActivity(new Intent(this, sq13_Login.class));
    }
}