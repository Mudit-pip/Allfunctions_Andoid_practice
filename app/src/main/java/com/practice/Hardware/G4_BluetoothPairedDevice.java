package com.practice.Hardware;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.practice.R;

import java.util.Set;



public class G4_BluetoothPairedDevice extends AppCompatActivity {
    TextView txtDeviceList;
    BluetoothAdapter btAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g4__bluetooth_paired_device);

        txtDeviceList = (TextView) findViewById(R.id.G4_txtListz);

        // Getting the Bluetooth adapter
        btAdapter = BluetoothAdapter.getDefaultAdapter();
        txtDeviceList.append("\nAdapter: " + btAdapter);



        askForPermission(Manifest.permission.BLUETOOTH,1);
        CheckBluetoothState();

    }

    private void askForPermission(String permission, Integer requestCode) {
        if (ContextCompat.checkSelfPermission(G4_BluetoothPairedDevice.this, permission) != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(G4_BluetoothPairedDevice.this, permission)) {

                //This is called if user has denied the permission before
                //In this case I am just asking the permission again
                ActivityCompat.requestPermissions(G4_BluetoothPairedDevice.this, new String[]{permission}, requestCode);

            } else {

                ActivityCompat.requestPermissions(G4_BluetoothPairedDevice.this, new String[]{permission}, requestCode);
            }
        } else {
            Toast.makeText(this, "" + permission + " is already granted.", Toast.LENGTH_SHORT).show();
        }
    }

    /* It is called when an activity completes.*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            CheckBluetoothState();
        }

    }

    private void CheckBluetoothState() {
        // Checks for the Bluetooth support and then makes sure it is turned on
        // If it isn't turned on, request to turn it on
        // List paired devices
        if(btAdapter==null) {
            txtDeviceList.append("\nBluetooth NOT supported. Aborting.");
            return;
        } else {
            if (btAdapter.isEnabled()) {
                txtDeviceList.append("\nBluetooth is enabled...");

                // Listing paired devices
                txtDeviceList.append("\nPaired Devices are:");

                //set list listarray are collection
                //devies is object of class set and also collection can also treated as array
                Set<BluetoothDevice> devices = btAdapter.getBondedDevices();

                for (BluetoothDevice i : devices) {
                    txtDeviceList.append("\n  Device: " + i.getName() + ", " + i);
                }

            } else {
                //Prompt user to turn on Bluetooth
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, 1);
            }
        }
    }
}
