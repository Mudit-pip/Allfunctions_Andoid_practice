package com.practice.Hardware;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.pm.PackageManager;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.practice.R;


public class G2_BlueTooth extends AppCompatActivity {
    BluetoothAdapter ba=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g2__blue_tooth);

        askForPermission(Manifest.permission.BLUETOOTH_ADMIN,1);
        askForPermission(Manifest.permission.BLUETOOTH,1);

        ba=BluetoothAdapter.getDefaultAdapter();
    }

    private void askForPermission(String permission, Integer requestCode) {
        if (ContextCompat.checkSelfPermission(G2_BlueTooth.this, permission) != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(G2_BlueTooth.this, permission)) {

                //This is called if user has denied the permission before
                //In this case I am just asking the permission again
                ActivityCompat.requestPermissions(G2_BlueTooth.this, new String[]{permission}, requestCode);

            } else {

                ActivityCompat.requestPermissions(G2_BlueTooth.this, new String[]{permission}, requestCode);
            }
        } else {
            Toast.makeText(this, "" + permission + " is already granted.", Toast.LENGTH_SHORT).show();
        }
    }


    public void G2_fun_Show(View v)
    {
        if (ba == null) {
            Toast.makeText(this, "No Bluetooth found", Toast.LENGTH_LONG).show();
        } else {
            if (ba.isEnabled()) {
                ba.disable();
                ((Button)v).setText("Turn On");
            } else {
                ba.enable();
                ((Button)v).setText("Turn Off");
            }
        }
    }
}

