package com.practice.ToDo2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.practice.R;

public class v1_todo_main extends AppCompatActivity {

    ListView list;
    SQLiteDatabase db;
    SearchView sv;
    String typedinSearch="";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v1_todo_main);

        list = findViewById(R.id.v1_todo_list);
        sv = findViewById(R.id.v1_todo_search);

        SharedPreferences pref = getSharedPreferences("pref_listnumber", MODE_PRIVATE);
        int listnumber = pref.getInt("lnumber",0);


        db = openOrCreateDatabase("db_todo_list"+listnumber, MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_listitems (Id Integer Primary Key AUTOINCREMENT, listitems varchar(300))");

        showlist();

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                typedinSearch = newText;
                showlist();
                return false;
            }
        });

    }

    public void v1_addToList_btn(View view) {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Add List Items");

        EditText ed = new EditText(this);
        ed.setHint("Enter Items Here...");
        alert.setView(ed);
        alert.setCancelable(false);


        alert.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (ed.getText().toString().trim().length() == 0) {
                    Toast.makeText(v1_todo_main.this, "No item added ", Toast.LENGTH_SHORT).show();
                } else {

                    String qry;
                    qry = "INSERT INTO tbl_listitems (listitems) VALUES ('" + ed.getText().toString().trim() + "')";
                    db.execSQL(qry);

                    showlist();

                    Toast.makeText(v1_todo_main.this, "Added", Toast.LENGTH_SHORT).show();
                }

            }
        });


        alert.setNeutralButton("Cancel", null);
        alert.create().show();
    }

    @SuppressLint("Range")
    public void showlist() {
        String qry;
        Cursor cur;
        int n;
        String[] listitemsString, IdString;

        qry = "SELECT * FROM tbl_listitems WHERE listitems like '%"+ typedinSearch +"%'";
        cur = db.rawQuery(qry, null);


        cur.moveToLast();
        n = cur.getCount();
        cur.moveToFirst();

        listitemsString = new String[n];
        IdString = new String[n];

        for (int i = 0; i < n; i++) {
            listitemsString[i] = cur.getString(cur.getColumnIndex("listitems"));
            IdString[i] = cur.getString(cur.getColumnIndex("Id"));
            cur.moveToNext();
        }

        newAdapter adapter = new newAdapter(this, listitemsString, IdString);
        list.setAdapter(adapter);


    }

    public void v1_todo_back(View view) {
        startActivity(new Intent(this, v2_Home_todo.class));
        finish();

    }

    public class newAdapter extends ArrayAdapter<String> {
        Context context;
        String[] arlistitems, arId;
        public newAdapter(Context context, String[] arlistitems, String[] arId) {
            super(context, R.layout.layout_list_v1_todo, R.id.layout_v1_todo_lbl, arlistitems);
            this.arlistitems = arlistitems;
            this.arId = arId;
            this.context = context;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View row = convertView;
            vholder vh;

            if(row == null){
                LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.layout_list_v1_todo, parent,false);

                vh = new vholder(row);
                row.setTag(vh);
            } else{
                vh = (vholder)row.getTag();
            }

            vh.txt_List.setText(arlistitems[position]);

            vh.deleteimg.setTag(arId[position]);
            vh.deleteimg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    AlertDialog.Builder alert = new AlertDialog.Builder(context);
                    alert.setTitle("confirmation");
                    alert.setCancelable(false);
                    alert.setMessage("Are you sure you want to delete");
                    alert.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String qry,s;
                            s = ((ImageView)view).getTag().toString();

                            qry = "DELETE FROM tbl_listitems WHERE Id ='"+s+"'";
                            db.execSQL(qry);
                            showlist();
                            Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                        }
                    });

                    alert.setNeutralButton("Cancel", null);
                    alert.create().show();
                }
            });

            vh.editimg.setTag(arId[position]+"~"+arlistitems[position]);
            vh.editimg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = ((ImageView)view).getTag().toString();
                    String[] f = s.split("~");
                    editlist(f[0], f[1]);
                }
            });


            return row;
        }

        public void editlist(String id, String item){
            AlertDialog.Builder alert = new AlertDialog.Builder(context);
            alert.setTitle("Edit item");
            EditText ed = new EditText(context);
            ed.setText(item);
            alert.setView(ed);


            alert.setPositiveButton("Change Text", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String qry;
                    qry="UPDATE tbl_listitems SET listitems = '"+ ed.getText().toString() +"' WHERE Id = '"+ id +"'";
                    db.execSQL(qry);
                    showlist();
                }
            });

            alert.setNeutralButton("Cancel", null);
            alert.create().show();



        }

    }



    public class vholder{
        TextView txt_List;
        ImageView editimg,deleteimg;

        public vholder(View r) {
            txt_List = r.findViewById(R.id.layout_v1_todo_lbl);
            editimg = r.findViewById(R.id.layout_v1_todo_img_edit);
            deleteimg = r.findViewById(R.id.layout_v1_todo_img_delete);
        }
    }
}