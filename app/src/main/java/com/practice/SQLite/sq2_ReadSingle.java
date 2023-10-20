package com.practice.SQLite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.practice.R;

public class sq2_ReadSingle extends AppCompatActivity {
ListView lst;
    SQLiteDatabase db;
    String arName[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sq2_reat_single);

        lst=findViewById(R.id.Sq2_lst);

        db=openOrCreateDatabase("db_Mudit",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_Student (Name varchar(200))");

        fillList();
    }

    private void fillList()
    {
        String qry="";
        Cursor cur;
        int n,i;

        qry="SELECT * FROM tbl_Student ";

        cur=db.rawQuery(qry,null);

        cur.moveToLast();
        n=cur.getCount();
        cur.moveToFirst();
        arName= new String[n];

        for(i=0;i<n;i++)
        {
            arName[i]=cur.getString(0);
            cur.moveToNext();
        }

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arName);
        lst.setAdapter(adapt);


        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = ((TextView)view).getText().toString();
                Toast.makeText(sq2_ReadSingle.this, s, Toast.LENGTH_SHORT).show();
            }
        });



    }

}