package com.practice.Hardware;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Build;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.practice.R;


public class G3_Wifi extends AppCompatActivity {
    WifiManager wm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g3__wifi);

        askForPermission(Manifest.permission.ACCESS_WIFI_STATE,1);
        askForPermission(Manifest.permission.CHANGE_WIFI_STATE,1);
    }

    private void askForPermission(String permission, Integer requestCode) {
        if (ContextCompat.checkSelfPermission(G3_Wifi.this, permission) != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(G3_Wifi.this, permission)) {

                //This is called if user has denied the permission before
                //In this case I am just asking the permission again
                ActivityCompat.requestPermissions(G3_Wifi.this, new String[]{permission}, requestCode);

            } else {

                ActivityCompat.requestPermissions(G3_Wifi.this, new String[]{permission}, requestCode);
            }
        } else {
            Toast.makeText(this, "" + permission + " is already granted.", Toast.LENGTH_SHORT).show();
        }
    }



    public void G3_fun_Show(View v) {
        //get Wifi service
        wm = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        //Check Wifi is on or off
        if (wm.isWifiEnabled()) {
            //enable or disable Wifi for enable pass true value for disable pass false value
            wm.setWifiEnabled(false);
            ((Button)v).setText("Turn On");
        } else {
            wm.setWifiEnabled(true);
            ((Button)v).setText("Turn Off");
        }

//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            Intent panelIntent = new
//                    Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);
//            startActivityForResult(panelIntent, 0);
//        } else {
//            // for previous android version
//            WifiManager wifiManager = (WifiManager)
//                    this.getApplicationContext().getSystemService(WIFI_SERVICE);
//            wifiManager.setWifiEnabled(true);
//        }
    }
}

