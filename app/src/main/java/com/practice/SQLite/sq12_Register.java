package com.practice.SQLite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.practice.R;

public class sq12_Register extends AppCompatActivity {

    EditText name, mobile, email, pass;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sq12_register);

        name = findViewById(R.id.sq12_txt_name);
        mobile = findViewById(R.id.sq12_txt_mobile);
        email = findViewById(R.id.sq12_txt_emailid);
        pass = findViewById(R.id.sq12_txt_pass);

        db = openOrCreateDatabase("db_Mudit", MODE_PRIVATE, null);
        //db.execSQL("DROP TABLE tbl_Register ");
        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_Register (RegId Integer PRIMARY KEY AUTOINCREMENT, Name varchar(200), Mobile varchar(20), Email varchar(30),  Password varchar(30))");

    }

    public void sq12_submit_btn(View view) {

        String qry, aname, amobile, aemail, apass;
        aname = name.getText().toString();
        amobile = mobile.getText().toString();
        aemail = email.getText().toString();
        apass = pass.getText().toString();

        int n;
        Cursor cur;


        qry = "SELECT * FROM tbl_Register WHERE Mobile = '" + amobile + "'";
        cur = db.rawQuery(qry, null);

        cur.moveToLast();
        n = cur.getCount();
        cur.moveToFirst();

        if (n >= 1)
            Toast.makeText(this, "Mobile is already registered", Toast.LENGTH_SHORT).show();
        else {
            qry = "INSERT INTO tbl_Register (Name, Mobile, Email, Password) VALUES ('" + aname + "','" + amobile + "','" + aemail + "','" + apass + "')";
            db.execSQL(qry);

            name.setText("");
            mobile.setText("");
            email.setText("");
            pass.setText("");

            Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
        }
    }

    public void sq12_loginbutton(View view) {
        startActivity(new Intent(this, sq13_Login.class));
    }

}