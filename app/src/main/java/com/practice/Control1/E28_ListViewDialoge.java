package com.practice.Control1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.practice.R;

public class E28_ListViewDialoge extends AppCompatActivity {

    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e28_list_view_dialoge);
    }

    public void E28_btn_Show(View view) {
        ListView lst=new ListView(this);
        String[] comp = {"HP", "dell", "lenovo"};

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, comp);
        lst.setAdapter(adapt);

        AlertDialog.Builder ad = new AlertDialog.Builder(this);

        ad.setTitle("This is Title");
        ad.setView(lst);



        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                s = ((TextView)view).getText().toString();
                //Toast.makeText(E28_ListViewDialoge.this, s, Toast.LENGTH_SHORT).show();
            }
        });

        ad.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(E28_ListViewDialoge.this, s+" "+ "Pressed yes", Toast.LENGTH_SHORT).show();
            }
        });

        ad.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(E28_ListViewDialoge.this, s+" "+ "Pressed NO", Toast.LENGTH_SHORT).show();
            }
        });

        ad.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(E28_ListViewDialoge.this, s+" "+ "Pressed Neutral", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog abb=ad.create();
        abb.show();

    }
}