package com.practice.SQLite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.practice.R;

public class sq13_Login extends AppCompatActivity {

    EditText Mobile, Password;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sq13_login);

        Mobile = findViewById(R.id.sq13_txt_mobile);
        Password = findViewById(R.id.sq13_txt_pass);

        db = openOrCreateDatabase("db_Mudit", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_Register (RegId Integer PRIMARY KEY AUTOINCREMENT, Name varchar(200), Mobile varchar(20), Email varchar(30),  Password varchar(30))");


    }

    public void sq13_submit_btn(View view) {
        fun();
    }

    @SuppressLint("Range")
    public void fun() {
        String que, Usermobile, UserPass;
        Cursor cur;
        int n;

        Usermobile = Mobile.getText().toString();
        UserPass = Password.getText().toString();

        que = "SELECT * FROM tbl_Register WHERE Mobile = '" + Usermobile + "' AND Password ='" + UserPass + "'";
        cur = db.rawQuery(que, null);

        cur.moveToLast();
        n = cur.getCount();
        cur.moveToFirst();

        if (n == 1) {
            Toast.makeText(this, "Corect", Toast.LENGTH_SHORT).show();

            SharedPreferences pref = getSharedPreferences("pref_isSaved", MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("RegId", cur.getString(cur.getColumnIndex("RegId")));
            editor.putBoolean("IsSaved", true);
            editor.commit();

            startActivity(new Intent(this, sq14_Home.class));
        } else {
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public void sq13_btnForNewRegister(View view) {
        startActivity(new Intent(this, sq12_Register.class));
    }
}