package com.practice.Hardware;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.practice.R;


public class G11_ReadContacts extends AppCompatActivity {
    ListView lvContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g11__read_contacts);

        lvContacts = findViewById(R.id.G11_lst);

        askForPermission(Manifest.permission.READ_CONTACTS,1);

        //Message Contacts Gallery
        ContentResolver cr = getContentResolver();

        // Read Contacts
        Cursor c = cr.query(ContactsContract.Contacts.CONTENT_URI,
                new String[] {ContactsContract.Contacts._ID,
                        ContactsContract.Contacts.DISPLAY_NAME },
                null, null, null);
        // Attached with cursor with Adapter
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.activity_g11__read_contacts_row, c,
                new String[] { ContactsContract.Contacts.DISPLAY_NAME },
                new int[] { R.id.G11_lblName });

        // Display data in listview
        lvContacts.setAdapter(adapter);

        // On Click of each row of contact display next screen with contact
        // number

        lvContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                //String s=((TextView)v).getText().toString();

                Cursor c = (Cursor) adapter.getItemAtPosition(position);
                String cid = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
                // Explicit Intent Example
                Intent i = new Intent(getApplicationContext(), G11_ContactDetails.class);
                i.putExtra("id", cid);
                startActivity(i);
            }
        });

    }


    private void askForPermission(String permission, Integer requestCode) {
        if (ContextCompat.checkSelfPermission(G11_ReadContacts.this, permission) != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(G11_ReadContacts.this, permission)) {

                //This is called if user has denied the permission before
                //In this case I am just asking the permission again
                ActivityCompat.requestPermissions(G11_ReadContacts.this, new String[]{permission}, requestCode);

            } else {

                ActivityCompat.requestPermissions(G11_ReadContacts.this, new String[]{permission}, requestCode);
            }
        } else {
            Toast.makeText(this, "" + permission + " is already granted.", Toast.LENGTH_SHORT).show();
        }
    }

}


