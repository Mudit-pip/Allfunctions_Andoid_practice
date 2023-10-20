package com.practice.SQLite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.practice.R;

public class sq3_Spinner extends AppCompatActivity {

    Spinner spn;
    SQLiteDatabase dtb;
    String[] strg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sq3_spinner);

        spn = findViewById(R.id.sq3_spinner);

        dtb = openOrCreateDatabase("db_Mudit", MODE_PRIVATE,null);
        dtb.execSQL("CREATE TABLE IF NOT EXISTS tbl_Student (Name varchar(200))");

        listfiller();
    }

    public void listfiller(){
        String abc;
        int n;
        Cursor cur;

        abc = "SELECT * FROM tbl_Student";
        cur = dtb.rawQuery(abc, null);

        cur.moveToLast();
        n = cur.getCount();
        cur.moveToFirst();

        strg = new String[n];

        for(int i = 0; i<n;i++){
            strg[i]=cur.getString(0);
            cur.moveToNext();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, strg);
        spn.setAdapter(adapter);
    }
}