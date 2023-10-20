package com.practice.Control1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import com.practice.R;

public class E20_SearchView extends AppCompatActivity {
    SearchView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e20_search_viw);

        sv = findViewById(R.id.E20_sv);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(E20_SearchView.this, s, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
//                Toast.makeText(E20_SearchView.this, s, Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }
}