package com.practice.ToDo2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.practice.R;

import org.w3c.dom.Text;

@SuppressLint("Range")
public class v2_Home_todo extends AppCompatActivity {

    GridView grid;

    SQLiteDatabase db, kdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v2_home_todo);

        grid = findViewById(R.id.v2_home_gridview);


        db = openOrCreateDatabase("db_todo_main", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_home_lists (id Integer primary Key AutoIncrement, items varchar(300))");

        //database of actual list (which is v1todo)
        SharedPreferences pref = getSharedPreferences("pref_listnumber", MODE_PRIVATE);
        int listnumber = pref.getInt("lnumber", 0);

        if (listnumber != 0) {
            kdb = openOrCreateDatabase("db_todo_list" + listnumber, MODE_PRIVATE, null);
            kdb.execSQL("CREATE TABLE IF NOT EXISTS tbl_listitems (Id Integer Primary Key AUTOINCREMENT, listitems varchar(300))");
        }


        showlist();


    }

    public void v2_AddNotes(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Add List");
        EditText ed = new EditText(this);
        ed.setHint("Add Name For List");
        alert.setView(ed);
        alert.setCancelable(false);
        alert.setNeutralButton("Cancel", null);


        alert.setPositiveButton("Create List", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String qry;
                qry = "Insert into tbl_home_lists (items) Values ('" + ed.getText().toString() + "')";
                db.execSQL(qry);
                showlist();
            }
        });

        alert.create().show();
    }

    public void showlist() {
        String[] items, ids;
        Cursor cur;
        String qry;
        int n;

        qry = "SELECT * FROM tbl_home_lists";
        cur = db.rawQuery(qry, null);

        cur.moveToLast();
        n = cur.getCount();
        cur.moveToFirst();

        items = new String[n];
        ids = new String[n];

        for (int i = 0; i < n; i++) {
            items[i] = cur.getString(cur.getColumnIndex("items"));
            ids[i] = cur.getString(cur.getColumnIndex("id"));
            cur.moveToNext();
        }


        myadapter adapter = new myadapter(this, items, ids);
        grid.setAdapter(adapter);


    }

    public class myadapter extends ArrayAdapter<String> {
        Context context;
        String items[], ids[];

        public myadapter(Context context, String[] items, String[] ids) {
            super(context, R.layout.layout_v2_forhome, R.id.layout_v2_text, items);
            this.context = context;
            this.items = items;
            this.ids = ids;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View row = convertView;
            vholder vh;

            if (row == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.layout_v2_forhome, parent, false);

                vh = new vholder(row);
                row.setTag(vh);
            } else {
                vh = (vholder) row.getTag();
            }

            vh.txt1.setText(items[position]);

            vh.lay.setTag(ids[position]);
            vh.lay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int i = Integer.parseInt(((LinearLayout) view).getTag().toString());
                    SharedPreferences pref = getSharedPreferences("pref_listnumber", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putInt("lnumber", i);
                    editor.commit();

                    //Toast.makeText(context, i+"", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(context, v1_todo_main.class));
                    finish();
                }
            });

            vh.delimg.setTag(ids[position]);
            vh.delimg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int s = Integer.parseInt(((ImageView) view).getTag().toString());
                    String qry;
                    qry = "DELETE FROM tbl_home_lists WHERE id =" + s;
                    db.execSQL(qry);

                    qry = "DELETE FROM tbl_listitems";
                    kdb.execSQL(qry);
                    showlist();
                }
            });

            vh.editimg.setTag(ids[position] + "~" + items[position]);
            vh.editimg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = ((ImageView) view).getTag().toString();
                    String[] f = s.split("~");

                    AlertDialog.Builder alert = new AlertDialog.Builder(context);
                    alert.setTitle("Change List Name");
                    EditText ed = new EditText(context);
                    ed.setText(f[1]);
                    ed.setHint("Enter new List Name");
                    alert.setView(ed);

                    alert.setPositiveButton("Change List Name", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String qry;
                            qry = "UPDATE tbl_home_lists SET items = '" + ed.getText().toString() + "' WHERE id = '"+ f[0] +"'";
                            db.execSQL(qry);
                            showlist();
                        }
                    });



                    alert.create().show();

                }
            });


            return row;
        }
    }

    public class vholder {
        TextView txt1;
        LinearLayout lay;

        ImageView editimg, delimg;

        public vholder(View r) {
            this.txt1 = r.findViewById(R.id.layout_v2_text);
            this.lay = r.findViewById(R.id.layout_v2_lay);
            this.editimg = r.findViewById(R.id.layout_v2_editimg);
            this.delimg = r.findViewById(R.id.layout_v2_deleteimg);
        }
    }
}