package com.practice.SQLite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.practice.R;

import java.lang.reflect.Array;

public class sq5_AutoCompleteText extends AppCompatActivity {

    AutoCompleteTextView act;
    SQLiteDatabase dtb;

    String[] name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sq5_auto_complete_text);

        act = findViewById(R.id.sq5_autocompletetext);

        dtb = openOrCreateDatabase("db_Mudit", MODE_PRIVATE,null);
        dtb.execSQL("CREATE TABLE IF NOT EXISTS tbl_Student (Name varchar(200))");

        filler();

    }

    public void filler(){
        String abc;
        Cursor cur;

        abc = "SELECT * FROM tbl_Student";
        cur = dtb.rawQuery(abc, null);

        cur.moveToLast();
        int n = cur.getCount();
        cur.moveToFirst();
        name = new String[n];

        for(int i =0; i<n;i++){
            name[i] = cur.getString(0);
            cur.moveToNext();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, name);
        act.setAdapter(adapter);
        act.setThreshold(1);
    }
}