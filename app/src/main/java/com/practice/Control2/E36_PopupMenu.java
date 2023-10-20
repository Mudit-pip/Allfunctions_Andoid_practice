package com.practice.Control2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.practice.R;

public class E36_PopupMenu extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e36_popup_menu);

        btn = findViewById(R.id.E36_btn_Show);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu pmneu = new PopupMenu(getApplicationContext(), v);
                pmneu.setOnMenuItemClickListener(E36_PopupMenu.this);
                pmneu.inflate(R.menu.menu_e36__popup_menu);
                pmneu.show();
            }
        });
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.E36_btn_Show)
            Toast.makeText(this, "Blue", Toast.LENGTH_LONG).show();
        else if (id == R.id.E36_mnu_Exit)
            Toast.makeText(this, "Red", Toast.LENGTH_LONG).show();
        else if (id == R.id.E36_mnu_File)
            Toast.makeText(this, "Green", Toast.LENGTH_LONG).show();
        else if (id == R.id.E36_mnu_Open)
            Toast.makeText(this, "Orange", Toast.LENGTH_LONG).show();

        return false;
    }
}