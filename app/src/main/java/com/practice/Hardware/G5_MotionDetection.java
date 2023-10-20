package com.practice.Hardware;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.practice.R;

import java.util.Random;



public class G5_MotionDetection extends AppCompatActivity implements SensorEventListener {
    SensorManager sm;
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g5__motion_detection);

        ll = findViewById(R.id.G5_ll);
        //get sensor service
        sm = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);
        //Tell which sensor you are going to use
        //And declare delay of sensor
        //Register all to your sensor object to use
        sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // TODO Auto-generated method stub
    }
    //This method is called when your mobile moves any direction

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            //get x, y, z values
            //The XYZ value changes for every acceleration (for every 20 ms). So the iteration of values passed into a low/high pass filter will provide the range for walking, running, jogging, etc.
            float value[] = event.values;
            float x = value[0];
            float y = value[1];
            float z = value[2];
            //use the following formula
            //use gravity according to your place if you are on moon than use moon gravity
            float asr = (x * x + y * y + z * z) / (SensorManager.GRAVITY_EARTH *
                    SensorManager.GRAVITY_EARTH);
            //If mobile move any direction then the following condition will become true
            if (asr >= 2) {
                //any thing
                Random random = new Random();
                int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
                ll.setBackgroundColor(color);


            }
        }
    }
}
