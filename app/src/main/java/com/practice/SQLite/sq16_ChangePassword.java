package com.practice.SQLite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.practice.R;

public class sq16_ChangePassword extends AppCompatActivity {

    EditText oldPass, newPass1, newPass2;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sq16_change_password);

        oldPass = findViewById(R.id.sq16_oldpass);
        newPass1 = findViewById(R.id.sq16_newpass1);
        newPass2 = findViewById(R.id.sq16_newpass2);

        db = openOrCreateDatabase("db_Mudit", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_Register (RegId Integer PRIMARY KEY AUTOINCREMENT, Name varchar(200), Mobile varchar(20), Email varchar(30),  Password varchar(30))");


    }

    public void sq16_Submit(View view) {
        String Id, qry;
        Cursor cur;
        int n;

        if (oldPass.getText().toString().trim().length() == 0)
            Toast.makeText(this, "Enter Current Password" + "", Toast.LENGTH_SHORT).show();
        else if (newPass1.getText().toString().trim().length() == 0)
            Toast.makeText(this, "Enter New Password" + "", Toast.LENGTH_SHORT).show();
        else if (newPass2.getText().toString().trim().length() == 0)
            Toast.makeText(this, "enter confirm Password" + "", Toast.LENGTH_SHORT).show();
        else if (!(newPass2.getText().toString().trim().equals(newPass1.getText().toString().trim())))
            Toast.makeText(this, "does not match" + "", Toast.LENGTH_SHORT).show();
        else {
            SharedPreferences pref = getSharedPreferences("pref_isSaved", MODE_PRIVATE);
            Id = pref.getString("RegId", "0");

            if (Integer.parseInt(Id) > 0) {
                qry = "SELECT * FROM tbl_Register WHERE RegId = '" + Id + "' AND Password = '" + oldPass.getText().toString() + "'";
                cur = db.rawQuery(qry, null);

                cur.moveToLast();
                n = cur.getCount();

                if (n == 1) {
                    qry = "UPDATE tbl_Register SET  Password ='" + newPass1.getText().toString() + "' Where RegId= " + Id ;
                    db.execSQL(qry);
                    Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Worng current password", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}