package com.practice.Control1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.practice.R;

public class E26_ListView extends AppCompatActivity {
ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e26_list_view);
        list = findViewById(R.id.E26_lst);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s=((TextView)view).getText().toString();
                Toast.makeText(E26_ListView.this, s, Toast.LENGTH_SHORT).show();

            }
        });
     }
}