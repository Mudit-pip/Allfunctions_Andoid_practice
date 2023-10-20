package com.practice.TpApps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.practice.R;

import java.util.ArrayList;

public class tp3_OpeningOtherApps extends AppCompatActivity {

    EditText text;
    ListView listview;

    ArrayList<String> list = new ArrayList<>();

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp3_opening_other_apps);

        text = findViewById(R.id.tp3_txt);
        listview = findViewById(R.id.tp3_list);

        db = openOrCreateDatabase("db_newdb_tb",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_list (items varchar(200))");

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = ((TextView)view).getText().toString();
                Uri webpage = Uri.parse("https://"+item);
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(webIntent);
            }
        });

    }

    public void tp3_btn(View view) {

        String qry,readqry;
        Cursor cur;
        int n;
        String[] listitems;

        qry = "INSERT INTO tbl_list (items) VALUES ('"+ text.getText().toString() +"')";
        db.execSQL(qry);
        list.add(text.getText().toString());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list);
        listview.setAdapter(adapter);

        readqry ="SELECT * FROM tlb_list";
        cur = db.rawQuery(readqry,null);

        cur.moveToLast();
        n = cur.getCount();
        cur.moveToFirst();

        listitems = new String[n];






    }
}