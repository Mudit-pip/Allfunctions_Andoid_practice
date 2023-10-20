package com.practice.SQLite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.practice.R;

public class sq1_InsertSingle extends AppCompatActivity {
    SQLiteDatabase db;
    EditText txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sq1_insert_single);

        txtName=findViewById(R.id.Sq1_txt_Name);

        db=openOrCreateDatabase("db_Mudit",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_Student (Name varchar(200))");
    }


    public void sq1_btn_Insert(View view) {
        String qry, name;

        name=txtName.getText().toString();

        qry="INSERT INTO tbl_Student (Name) VALUES ('" + name + "')";
        db.execSQL(qry);

        txtName.setText("");
        Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();
    }
}