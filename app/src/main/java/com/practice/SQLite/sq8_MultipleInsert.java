package com.practice.SQLite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.practice.R;

public class sq8_MultipleInsert extends AppCompatActivity {
    SQLiteDatabase db;
    EditText txtName, txtMobile, txtRollNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sq8_multiple_insert);

        txtRollNo = findViewById(R.id.Sq8_txt_RollNo);
        txtName = findViewById(R.id.Sq8_txt_Name);
        txtMobile = findViewById(R.id.Sq8_txt_Mobile);

        db = openOrCreateDatabase("db_Mudit", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_StudentNew (RollNo Integer,Name varchar(200),Mobile varchar(200))");
    }


    public void sq8_btn_Insert(View view) {
        String qry, name, rollno, mobile;

        rollno = txtRollNo.getText().toString();
        name = txtName.getText().toString();
        mobile = txtMobile.getText().toString();

        qry = "INSERT INTO tbl_StudentNew (RollNo, Name, Mobile) VALUES ('" + rollno + "','" + name + "','" + mobile + "')";
        db.execSQL(qry);

        txtRollNo.setText("");
        txtName.setText("");
        txtMobile.setText("");
        Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();
    }
}
