package com.practice.SQLite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.practice.R;

import java.lang.reflect.Array;

public class Rough_for_listView extends AppCompatActivity {


    SQLiteDatabase db;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rough_for_list_view);

        lst = findViewById(R.id.rough_list);


        db = openOrCreateDatabase("db_Mudit1", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_Register (RegId Integer PRIMARY KEY AUTOINCREMENT, Name varchar(200), Mobile varchar(20), Email varchar(30),  Password varchar(30))");

        filllist();
    }

    @SuppressLint("Range")
    public void filllist(){

        Cursor cur;
        String qry;
        int n;


        qry = "SELECT * FROM tbl_Register";
        cur = db.rawQuery(qry,null);

        cur.moveToLast();
        n = cur.getCount();
        cur.moveToFirst();

        String[] list = new String[n];

        for(int i = 0; i<n;i++){
            list[i] = cur.getString(cur.getColumnIndex("Mobile"));
            cur.moveToNext();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
        lst.setAdapter(adapter);



    }
}