package com.practice.SQLite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.GridView;

import com.practice.R;

public class sq7_GridView extends AppCompatActivity {

    GridView grid;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sq7_grid_view);

        grid = findViewById(R.id.sq7_grid);

        db=openOrCreateDatabase("mytododatabase",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS listitems (col1 varchar(300))");

        showgrid();

    }

    public  void showgrid(){

        Cursor cur;
        String text;
        text = "SELECT * FROM listitems";
        cur = db.rawQuery(text,null);

        cur.moveToLast();
        int n = cur.getCount();
        cur.moveToFirst();

        String[] names = new String[n];

        for(int i = 0 ; i<n;i++){
//            names[i] =
        }

    }
}