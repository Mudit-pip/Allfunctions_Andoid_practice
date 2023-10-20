package com.practice.Hardware;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;


import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.practice.R;


public class G18_SMS extends AppCompatActivity {
    ListView lst;
    Integer SMSJi = 1;
    EditText txt;
    RadioButton opt_Number, opt_Message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g18__s_m_s);

        askForPermission(Manifest.permission.READ_SMS, SMSJi);

        lst = (ListView) findViewById(R.id.G18_lst);
        txt = findViewById(R.id.G18_txt);
        opt_Number = findViewById(R.id.G18_opt_Number);
        opt_Message = findViewById(R.id.G18_opt_Message);

    }

    private void askForPermission(String permission, Integer requestCode) {
        if (ContextCompat.checkSelfPermission(G18_SMS.this, permission) != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(G18_SMS.this, permission)) {

                //This is called if user has denied the permission before
                //In this case I am just asking the permission again
                ActivityCompat.requestPermissions(G18_SMS.this, new String[]{permission}, requestCode);

            } else {

                ActivityCompat.requestPermissions(G18_SMS.this, new String[]{permission}, requestCode);
            }
        } else {
            Toast.makeText(this, "" + permission + " is already granted.", Toast.LENGTH_SHORT).show();
        }
    }

    public void G18_fun_Inbox(View v) {
        String strSelectionType, strSelectionValue;


        // Create Inbox box URI
        Uri inboxURI = Uri.parse("content://sms/inbox");
        // List required columns
        String[] reqCols = new String[]{"_id", "address", "body"};
        // Get Content Resolver object, which will deal with Content Provider
        ContentResolver cr = getContentResolver();
        // Fetch Inbox SMS Message from Built-in Content Provider
        strSelectionValue = "%" + txt.getText().toString() + "%";

        if (opt_Number.isChecked())
            strSelectionType = "address LIKE ?";
        else
            strSelectionType = "body LIKE ?";

        //Cursor c = cr.query(inboxURI, reqCols, "date" + ">?",new String[]{""+date},"date DESC");
        Cursor c = cr.query(inboxURI, reqCols, strSelectionType, new String[]{strSelectionValue}, "date DESC");
        // Attached Cursor with adapter and display in listview
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.activity_g10__read_sms_row, c,
                new String[]{"body", "address"}, new int[]{
                R.id.G10_lbl_Msg, R.id.G10_lbl_Number});
        lst.setAdapter(adapter);
    }

}

