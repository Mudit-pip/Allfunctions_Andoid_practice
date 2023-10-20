package com.practice.Control2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.practice.R;

public class E38_contextMenu extends AppCompatActivity {

    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e38_context_menu);

        txt = findViewById(R.id.E37_txt);
        registerForContextMenu(txt);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo info) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.setHeaderTitle("This is My Menu");
        menu.add("Red");
        menu.add("Yellow");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //noinspection SimplifiableIfStatement
        if (item.getTitle().equals("Red")) {
            Toast.makeText(this, "Red", Toast.LENGTH_LONG).show();
            return true;
        } else if (item.getTitle().equals("Yellow")) {
            Toast.makeText(this, "Yellow", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onContextItemSelected(item);
    }
}