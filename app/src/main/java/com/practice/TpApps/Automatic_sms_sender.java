package com.practice.TpApps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.practice.Hardware.G9_SendSMS;
import com.practice.R;

public class Automatic_sms_sender extends AppCompatActivity {

    EditText mobile, message, amount;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automatic_sms_sender);

        askForPermission(Manifest.permission.SEND_SMS, 1);
        amount = findViewById(R.id.tp_sms_amount);
        message = findViewById(R.id.tp_sms_message);
        mobile = findViewById(R.id.tp_sms_mobile);


    }

    public void tp_automaticsms_btn(View view) {
        int n = Integer.parseInt(amount.getText().toString());

        Intent intent = new Intent(getApplicationContext(), G9_SendSMS.class);
        PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);

        SmsManager sms = SmsManager.getDefault();

        for (int i = 0; i < n; i++) {
            String s = mobile.getText().toString();
            String a = message.getText().toString();

            sms.sendTextMessage(s, null, a, pi, null);
        }
    }

    private void askForPermission(String permission, Integer requestCode) {
        if (ContextCompat.checkSelfPermission(Automatic_sms_sender.this, permission) != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(Automatic_sms_sender.this, permission)) {
                //This is called if user has denied the permission before
                //In this case I am just asking the permission again
                ActivityCompat.requestPermissions(Automatic_sms_sender.this, new String[]{permission}, requestCode);
            } else {
                ActivityCompat.requestPermissions(Automatic_sms_sender.this, new String[]{permission}, requestCode);
            }
        } else {
            Toast.makeText(this, "" + permission + " is already granted.", Toast.LENGTH_SHORT).show();
        }
    }


}