package com.practice.Control2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.practice.R;

public class E39_SharedPrefrences extends AppCompatActivity {
    EditText txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e39_shared_prefrences);

        txtName = findViewById(R.id.E39_txt);

    }

    public void E39_fun_Show(View view) {
        SharedPreferences pref = getSharedPreferences("pref_Mudit", MODE_PRIVATE);
        boolean b = pref.getBoolean("IsSaved", false);
        String s = Boolean.toString(b);

        Toast.makeText(this, pref.getString("Name","Nahi Mila ") + "  "+s, Toast.LENGTH_SHORT).show();
        }

    public void E39_fun_Delete(View view) {
        SharedPreferences pref = getSharedPreferences("pref_Mudit", MODE_PRIVATE);
        SharedPreferences.Editor editor= pref.edit();

        editor.remove("Name");
        editor.remove("IsSaved");

        editor.commit();

    }

    public void E39_fun_Add(View view) {
        SharedPreferences pref = getSharedPreferences("pref_Mudit", MODE_PRIVATE);
        SharedPreferences.Editor editor= pref.edit();

        editor.putString("Name",txtName.getText().toString());
        editor.putBoolean("IsSaved",true);

        editor.commit();

    }
}