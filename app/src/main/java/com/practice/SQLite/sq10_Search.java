package com.practice.SQLite;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.practice.R;

import java.sql.Array;

public class sq10_Search extends AppCompatActivity {

    ListView list;
    SQLiteDatabase db;
    EditText txtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sq10_search);

        list = findViewById(R.id.sq10_list);
        txtSearch = findViewById(R.id.Sq10_txt_Search);

        db = openOrCreateDatabase("db_Mudit", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_StudentNew (RollNo Integer,Name varchar(200),Mobile varchar(200))");


    }

    @SuppressLint("Range")
    public void fill() {
        String strSearch, que;
        String[] Rollno;
        String[] name, mobileno;
        Cursor cur;


        strSearch = txtSearch.getText().toString();

        que = "SELECT * FROM tbl_StudentNew where Name like '%" + strSearch + "%' or Mobile like '%" + strSearch + "%'";
        cur = db.rawQuery(que, null);

        cur.moveToLast();
        int n = cur.getCount();
        cur.moveToFirst();

        Rollno = new String[n];
        name = new String[n];
        mobileno = new String[n];

        for (int i = 0; i < n; i++) {

            Rollno[i] = cur.getString(cur.getColumnIndex("RollNo"));
            name[i] = cur.getString(cur.getColumnIndex("Name"));
            mobileno[i] = cur.getString(cur.getColumnIndex("Mobile"));
            cur.moveToNext();

        }

        mudit adapter = new mudit(this, name, Rollno, mobileno);
        list.setAdapter(adapter);

    }

    public void Sq10_btn_Search(View view) {
        fill();
    }

    public class mudit extends ArrayAdapter<String> {

        String[] arRoll, arname, armobile;
        Context mycontext;

        public mudit(@NonNull Context context, String[] arname, String[] arroll, String[] armobile) {
            super(context, R.layout.layout_for_multi_sqlreader, R.id.sq9_laout_txt1, arname);
            this.mycontext = context;
            this.arname = arname;
            this.arRoll = arroll;
            this.armobile = armobile;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View row = convertView;

            if (row == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(mycontext.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.layout_for_multi_sqlreader, parent, false);
            }

            varholder varholder = new varholder(row);
            varholder.txt1.setText(arname[position]);
            varholder.txt2.setText(armobile[position]);
            varholder.txt3.setText(arRoll[position]);

            return row;
        }
    }

    public class varholder {
        TextView txt1, txt2, txt3;

        public varholder(View r) {
            txt1 = r.findViewById(R.id.sq9_laout_txt1);
            txt2 = r.findViewById(R.id.sq9_laout_txt2);
            txt3 = r.findViewById(R.id.sq9_laout_txt3);
        }
    }
}