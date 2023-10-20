package com.practice.Hardware;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.icu.number.Scale;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.practice.R;


public class G1_BatteryLevel extends AppCompatActivity {
    TextView batteryPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g1__battery_level);

        batteryPercent = findViewById(R.id.G1_txt);
        getBatteryPercentage();
    }

    private void getBatteryPercentage() {

            BroadcastReceiver batteryLevelReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {

                //context.unregisterReceiver(this);
                int currentLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

                Toast.makeText(context, ""+currentLevel+"  "+ scale, Toast.LENGTH_SHORT).show();
                int level = 0;

                if (currentLevel >= 0 && scale > 0) {
                    level = (currentLevel * 100) / scale;

                    if(level<=20)
                        Toast.makeText(G1_BatteryLevel.this, "charge",Toast.LENGTH_LONG).show();
                }
                batteryPercent.setText("Battery Level Remaining: " + level + "%");
            }
        };

        IntentFilter batteryLevelFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(batteryLevelReceiver, batteryLevelFilter);

    }


}
