package com.practice.Hardware;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.CallLog;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.practice.R;

import java.util.Date;



public class G12_CallLogRead extends AppCompatActivity {
    TextView txtLog = null;
    Integer CONTACT = 0x9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g12__call_log_read);

        txtLog = findViewById(R.id.G12_txt_Log);

        askForPermission(Manifest.permission.READ_CALL_LOG,CONTACT);

        getCallDetails();
    }

    private void askForPermission(String permission, Integer requestCode) {
        if (ContextCompat.checkSelfPermission(G12_CallLogRead.this, permission) != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(G12_CallLogRead.this, permission)) {

                //This is called if user has denied the permission before
                //In this case I am just asking the permission again
                ActivityCompat.requestPermissions(G12_CallLogRead.this, new String[]{permission}, requestCode);

            } else {

                ActivityCompat.requestPermissions(G12_CallLogRead.this, new String[]{permission}, requestCode);
            }
        } else {
            Toast.makeText(this, "" + permission + " is already granted.", Toast.LENGTH_SHORT).show();
        }
    }

    private void getCallDetails() {
        StringBuffer sb = new StringBuffer();
        String strOrder = CallLog.Calls.DATE + " DESC";
        /* Query the CallLog Content Provider */
        ContentResolver cr = getContentResolver();

        Cursor c = cr.query(CallLog.Calls.CONTENT_URI, null,null,
                null, strOrder);

        sb.append("Call Log :");

        while (c.moveToNext()) {
            String phNum = c.getString(c.getColumnIndex(CallLog.Calls.NUMBER));
            String callTypeCode = c.getString(c.getColumnIndex(CallLog.Calls.TYPE));
            String strcallDate = c.getString(c.getColumnIndex(CallLog.Calls.DATE));
            Date callDate = new Date(Long.valueOf(strcallDate));
            String callDuration = c.getString(c.getColumnIndex(CallLog.Calls.DURATION));
            String callType = null;

            int callcode = Integer.parseInt(callTypeCode);
            switch (callcode) {
                case CallLog.Calls.OUTGOING_TYPE:
                    callType = "Outgoing";
                    break;
                case CallLog.Calls.INCOMING_TYPE:
                    callType = "Incoming";
                    break;
                case CallLog.Calls.MISSED_TYPE:
                    callType = "Missed";
                    break;
            }

            sb.append("\nPhone Number:--- " + phNum + " \nCall Type:--- "
                    + callType + " \nCall Date:--- " + callDate
                    + " \nCall duration in sec :--- " + callDuration);
            sb.append("\n----------------------------------");
        }
        c.close();
        //Toast.makeText(G12_CallLogRead.this, sb.toString(),Toast.LENGTH_LONG).show();
        txtLog.setText(sb);
    }
}
