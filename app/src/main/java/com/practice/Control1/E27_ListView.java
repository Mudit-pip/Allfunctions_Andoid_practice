package com.practice.Control1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.practice.R;

import java.util.List;

public class E27_ListView extends AppCompatActivity {

    ListView lst;
    String[] comp = {"HP", "dell", "lenovo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e27_list_view);

        lst = findViewById(R.id.E27_lst);

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, comp);
        lst.setAdapter(adapt);


        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = ((TextView)view).getText().toString();
                Toast.makeText(E27_ListView.this, s, Toast.LENGTH_SHORT).show();
            }
        });


    }
}