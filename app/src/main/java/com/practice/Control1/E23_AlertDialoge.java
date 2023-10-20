package com.practice.Control1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ZoomControls;

import com.practice.R;

public class E23_AlertDialoge extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e23_alert_dialoge);
    }

    public void E23_fun_Button1(View view) {
        AlertDialog.Builder ad = new AlertDialog.Builder(this);

        ad.setTitle("This is Title");
        ad.setMessage("This is Message ");

        AlertDialog abb = ad.create();
        abb.show();

    }




    public void E23_fun_Button2(View view) {
        AlertDialog.Builder ad = new AlertDialog.Builder(this);

        ad.setTitle("This is Title");
        ad.setMessage("This is Message ");

        ad.setPositiveButton("YES",null);
        ad.setNegativeButton("No",null);
        ad.setNeutralButton("Cancel",null);


        AlertDialog abb = ad.create();
        abb.show();

    }

    public void E23_fun_Button3(View view) {
        AlertDialog.Builder ad = new AlertDialog.Builder(this);

        ad.setTitle("This is Title");
        ad.setMessage("This is Message ");

        ad.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(E23_AlertDialoge.this, "YESYES", Toast.LENGTH_SHORT).show();
            }
        });
        ad.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(E23_AlertDialoge.this, "NoNO", Toast.LENGTH_SHORT).show();
            }
        });
        ad.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(E23_AlertDialoge.this, "Cancel", Toast.LENGTH_SHORT).show();
            }
        });


        AlertDialog abb = ad.create();
        abb.show();

    }
}