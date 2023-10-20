package com.practice.SQLite;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.practice.R;

public class sq11_AdvanceSearch extends AppCompatActivity {
    EditText txtName, txtMobile, txtId;

    ListView list;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sq11_advance_search);

        list = findViewById(R.id.sq11_list);

        txtId = findViewById(R.id.Sq11_txt_ID);
        txtName = findViewById(R.id.Sq11_txt_Name);
        txtMobile = findViewById(R.id.Sq11_txt_Mobile);

        db = openOrCreateDatabase("db_Mudit", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_StudentNew (RollNo Integer,Name varchar(200),Mobile varchar(200))");

    }

    public void Sq11_btn_Search(View view) {
        fill();
    }

    @SuppressLint("Range")
    public void fill() {
        String que, strName, strMobile, strId;
        String[] Rollno;
        String[] name, mobileno;
        Cursor cur;

        strName = txtName.getText().toString();
        strMobile = txtMobile.getText().toString();
        strId = txtId.getText().toString();

        que = "SELECT * FROM tbl_StudentNew WHERE RollNo > 0 ";

        if (strName.trim().length() > 0)
            que = que + " and Name like '%"+strName+"%'";

        if (strMobile.trim().length() > 0)
            que = que + " and Mobile like '%"+strMobile+"%'";

        if (strId.trim().length() > 0)
            que = que + " and RollNo like '%"+strId+"%'";

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