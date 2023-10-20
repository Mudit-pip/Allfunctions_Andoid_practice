package com.practice.SQLite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.practice.R;

public class sq15_EditProfile extends AppCompatActivity {

    EditText newName, newEmail;
    SQLiteDatabase db;

    String mName, mEmail, qur, Id;
    Cursor cur;
    int n;

    @SuppressLint({"MissingInflatedId", "Range"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sq15_edit_profile);

        newName = findViewById(R.id.sq15_txt_editName);
        newEmail = findViewById(R.id.sq15_txt_editEmail);

        db = openOrCreateDatabase("db_Mudit", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_Register (RegId Integer PRIMARY KEY AUTOINCREMENT, Name varchar(200), Mobile varchar(20), Email varchar(30),  Password varchar(30))");


        SharedPreferences pref = getSharedPreferences("pref_isSaved", MODE_PRIVATE);
        Id = pref.getString("RegId", "0");

        qur = "SELECT * FROM tbl_Register where RegId = '"+Id+"'";
        cur = db.rawQuery(qur, null);

        cur.moveToLast();
        n = cur.getCount();
        cur.moveToFirst();

        Toast.makeText(this, ""+n, Toast.LENGTH_SHORT).show();

        mName = cur.getString(cur.getColumnIndex("Name"));
        mEmail = cur.getString(cur.getColumnIndex("Email"));


        newName.setText(mName);
        newEmail.setText(mEmail);
    }


    public void sq15_submit(View view) {

        if (newName.getText().toString().equals(mName) && newEmail.getText().toString().equals(mEmail)) {
            Toast.makeText(this, "Please Change pre Defined Email/Name", Toast.LENGTH_SHORT).show();
        } else if (newName.getText().toString().trim().length() == 0 || newEmail.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "Please Enter Email & Name", Toast.LENGTH_SHORT).show();
        } else {
            qur = "UPDATE tbl_Register SET Name = '" + newName.getText().toString() + "',  Email = '" + newEmail.getText().toString() + "' WHERE  RegId =  '"+Id+"'";
            db.execSQL(qur);
            Toast.makeText(this, "Changed", Toast.LENGTH_SHORT).show();
        }
    }
}