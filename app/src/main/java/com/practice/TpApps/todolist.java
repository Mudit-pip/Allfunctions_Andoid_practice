package com.practice.TpApps;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.practice.R;

import java.util.ArrayList;

public class todolist extends AppCompatActivity {

    ListView list;
    ArrayList<String> todo;
    ArrayList<String> detailsforitems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);

        list = findViewById(R.id.todo_list);

        todo = new ArrayList<>();
        detailsforitems = new ArrayList<>();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = ((TextView)view).getText().toString();
                EditText detail = new EditText(todolist.this);

                AlertDialog.Builder ad = new AlertDialog.Builder(todolist.this);
                ad.setTitle("Add Details for "+s);
                ad.setView(detail);
                ad.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        detailsforitems.add(detail.getText().toString());
                        //Toast.makeText(todolist.this, detail.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                });

                ad.create().show();
            }
        });


    }

    public void btn1(View view) {

        EditText et = new EditText(this);
        et.setHint("Item for To-Do List...");

        AlertDialog.Builder ad = new AlertDialog.Builder(this);
        ad.setTitle("Add items in List");
        ad.setView(et);

        ad.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                todo.add(et.getText().toString());

                ArrayAdapter<String> adapter = new ArrayAdapter<>(todolist.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, todo);
                list.setAdapter(adapter);

                Toast.makeText(todolist.this, "Added" + et.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        ad.setNeutralButton("Cancel", null);
        ad.create().show();

    }
}