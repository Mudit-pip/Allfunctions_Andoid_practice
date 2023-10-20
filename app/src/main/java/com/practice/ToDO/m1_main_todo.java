package com.practice.ToDO;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.practice.Control2.E32_ListViewMulti;
import com.practice.R;

public class m1_main_todo extends AppCompatActivity {
    SearchView txtSearch;
    ListView lstTask;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m1_main_todo);

        txtSearch = findViewById(R.id.M1_txt_Search);
        lstTask = findViewById(R.id.M1_lst_Task);

        db = openOrCreateDatabase("mytododatabase", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_Task (Id1 Integer Primary Key AUTOINCREMENT, Task  varchar(300))");

        showlist();
    }

    public void M1_btn_Add(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("ADD ITEM IN LIST");
        EditText txtTask = new EditText(this);
        txtTask.setHint("Enter Item to ADD");
        alert.setView(txtTask);
        alert.setCancelable(false);

        alert.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                // items.add(userinput.getText().toString());

//                ArrayAdapter<String> adapter = new ArrayAdapter<>(tdolist.this, R.layout.list_design, R.id.listdesign_txt,items);
//                list.setAdapter(adapter);

                String a = "INSERT INTO tbl_Task (Task) VALUES ('" + txtTask.getText().toString() + "')";
                db.execSQL(a);

                Toast.makeText(m1_main_todo.this, "Item Added", Toast.LENGTH_SHORT).show();
                showlist();
            }
        });

        alert.setNeutralButton("Cancel", null);
        alert.create().show();

    }

    @SuppressLint("Range")
    public void showlist() {
        String[] arTask, arId;
        Cursor cur;

        String que = "SELECT * FROM tbl_Task";
        cur = db.rawQuery(que, null);

        cur.moveToLast();
        int n = cur.getCount();
        cur.moveToFirst();

        arTask = new String[n];
        arId = new String[n];

        for (int i = 0; i < n; i++) {
            arTask[i] = cur.getString(cur.getColumnIndex("Task"));
            arId[i] = cur.getString(cur.getColumnIndex("Id1"));

            cur.moveToNext();
        }

        mudit adpt=new mudit(this, arTask,arId);
        lstTask.setAdapter(adpt);
    }

    public class mudit extends ArrayAdapter<String> {
        String[] mTask;
        String[] mTaskId;
        Context mContext;

        public mudit(Context context, String[] arTask, String[] arTaskId) {
            super(context, R.layout.activity_m1_main_todo_row, R.id.M1_lbl_Task, arTask);

            mTask = arTask;
            mTaskId = arTaskId;
            mContext = context;
        }


        @SuppressLint("ResourceAsColor")
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View row = convertView;
            VHolder vholder;

            if (row == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.activity_m1_main_todo_row, parent, false);

                vholder = new VHolder(row);
                row.setTag(vholder);
            } else {
                vholder = (VHolder) row.getTag();
            }

//            if (position % 2 == 0) {
//                vholder.ll.setBackgroundColor(getColor(R.color.red));

//            } else {
//                vholder.ll.setBackgroundColor(getColor(R.color.blue));
//            }

            vholder.txtTask.setText(mTask[position]);


            vholder.btnDelete.setTag(mTaskId[position]);
            vholder.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s=((ImageView)view).getTag().toString();

                    String qry;

                    qry ="DELETE  FROM tbl_Task WHERE Id1 = '"+ s +"'";
                    db.execSQL(qry);
                    showlist();
                    Toast.makeText(mContext, "done", Toast.LENGTH_SHORT).show();
                }
            });

            vholder.btnEdit.setTag(mTaskId[position]+"~"+mTask[position]);
            vholder.btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String rec=((ImageView)view).getTag().toString();

                    String[] arRec=rec.split("~");

                    Intent ii=new Intent(m1_main_todo.this, m2_main_todoedit.class);
                    ii.putExtra("Id",arRec[0]);
                    ii.putExtra("Task",arRec[1]);
                    startActivity(ii);

                    //EditTask(arRec[1], arRec[0]);

                }
            });


            return row;
        }

        public void EditTask(String ttask, String tId) {
            AlertDialog.Builder alert = new AlertDialog.Builder( m1_main_todo.this);
            alert.setTitle("Edit ITEM IN LIST");

            EditText txtTask = new EditText(m1_main_todo.this);

            txtTask.setHint("Enter Item to Update");
            txtTask.setText(ttask);

            alert.setView(txtTask);
            alert.setCancelable(false);

            alert.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String a = "UPDATE tbl_Task SET Task='" + txtTask.getText().toString() + "' WHERE ID1="+tId;
                    db.execSQL(a);

                    Toast.makeText(m1_main_todo.this, "Item Updated", Toast.LENGTH_SHORT).show();
                    showlist();
                }
            });

            alert.setNeutralButton("Cancel", null);
            alert.create().show();

        }


    }

    public class VHolder {
        TextView txtTask;
        ImageView btnEdit, btnDelete;
        public VHolder(View r) {

            txtTask = r.findViewById(R.id.M1_lbl_Task);
            btnEdit = r.findViewById(R.id.M1_btn_Edit);
            btnDelete = r.findViewById(R.id.M1_btn_Delete);
        }

    }

}