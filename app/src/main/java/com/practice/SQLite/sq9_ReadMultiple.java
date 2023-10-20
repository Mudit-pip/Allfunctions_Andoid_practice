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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.practice.Control2.E32_ListViewMulti;
import com.practice.R;

public class sq9_ReadMultiple extends AppCompatActivity {
    ListView list;
    String[] RollNo;
    String[] Name;
    String[] Mobile;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sq9_read_multiple);

        list = findViewById(R.id.Sq9_lst);


        db = openOrCreateDatabase("db_Mudit", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_StudentNew (RollNo Integer,Name varchar(200),Mobile varchar(200))");

        fillList();

    }

    @SuppressLint("Range")
    private void fillList() {
        String qry = "";
        Cursor cur;
        int n, i;

        qry = "SELECT * FROM tbl_StudentNew ";

        cur = db.rawQuery(qry, null);  ///

        cur.moveToLast();
        n = cur.getCount();
        cur.moveToFirst();
        Name = new String[n];
        RollNo = new String[n];
        Mobile = new String[n];

        for (i = 0; i < n; i++) {
            RollNo[i] = cur.getString(cur.getColumnIndex("RollNo"));
            Name[i] = cur.getString(cur.getColumnIndex("Name"));
            Mobile[i] = cur.getString(cur.getColumnIndex("Mobile"));
            cur.moveToNext();
        }

        mudit adpt = new mudit(this, Name, Mobile, RollNo);
        list.setAdapter(adpt);

    }


    public class mudit extends ArrayAdapter<String> {
        String[] mName;
        String[] mMobile;
        String[] mroll;
        Context mContext;

        public mudit(Context context, String[] arName, String[] arMobile, String[] arRoll) {
            super(context, R.layout.layout_for_multi_sqlreader, R.id.sq9_laout_txt1, arName);

            mName = arName;
            mMobile = arMobile;
            mContext = context;
            this.mroll = arRoll;

        }

        @SuppressLint("ResourceAsColor")
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View row = convertView;
            VHolder vholder;

            if (row == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.layout_for_multi_sqlreader, parent, false);

                vholder = new VHolder(row);
                row.setTag(vholder);
            } else {
                vholder = (VHolder) row.getTag();
            }

            vholder.txtName.setText(mName[position]);
            vholder.txtMobile.setText(mMobile[position]);
            vholder.txtRollno.setText(mroll[position]);
            vholder.btnDelete.setTag(mName[position]);

            vholder.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s=((ImageView)view).getTag().toString();

                    String qry;

                    qry ="DELETE  FROM tbl_StudentNew WHERE Name = '"+ s +"'";
                    db.execSQL(qry);
                    fillList();
                    Toast.makeText(mContext, s, Toast.LENGTH_SHORT).show();
                }
            });
            return row;
        }
    }

    public class VHolder {
        TextView txtName, txtMobile, txtRollno;
        ImageView btnDelete;

        public VHolder(View r) {

            txtName = r.findViewById(R.id.sq9_laout_txt1);
            txtMobile = r.findViewById(R.id.sq9_laout_txt2);
            txtRollno = r.findViewById(R.id.sq9_laout_txt3);
            btnDelete = r.findViewById(R.id.sq9_btn_Delete);
        }

    }
}