package com.practice.Control1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.practice.R;

public class E31_GridView extends AppCompatActivity {

    GridView list;
    String[] items = {"a","ab","abc","abcd","abcde","abcdef","ab","abc","abcd","abcde","abcdef","ab","abc","abcd","abcde","abcdef","ab","abc","abcd","abcde","abcdef","ab","abc","abcd","abcde","abcdef","ab","abc","abcd","abcde","abcdef","ab","abc","abcd","abcde","abcdef","ab","abc","abcd","abcde","abcdef"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e31_grid_view);

        list = findViewById(R.id.E31_list);

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,items);
        list.setAdapter(adapt);
    }

}