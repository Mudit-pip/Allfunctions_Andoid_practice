package com.practice.Hardware;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.practice.R;


public class G0_Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g0_home);
    }

    public void Fun_G1_BatteryLevel(View view) {
        startActivity(new Intent(this, G1_BatteryLevel.class));
    }

    public void Fun_G2_BlueTooth(View view) {
        startActivity(new Intent(this, G2_BlueTooth.class));
    }

    public void Fun_G3_Wifi(View view) {
        startActivity(new Intent(this, G3_Wifi.class));
    }

    public void Fun_G4_BlutoothPairedDevice(View view) {
        startActivity(new Intent(this, G4_BluetoothPairedDevice.class));
    }

    public void Fun_G5_MotionDetection(View view) {
        startActivity(new Intent(this, G5_MotionDetection.class));

    }

    public void Fun_G6_GetCallState1(View view) {
        startActivity(new Intent(this, G6_GetCallState1.class));
    }

    public void Fun_G7_PhoneCall(View view) {
        startActivity(new Intent(this, G7_PhoneCall.class));
    }

    public void Fun_G8_TelephonyManager(View view) {
        startActivity(new Intent(this, G8_TelephonyManager.class));
    }

    public void Fun_G9_SendSMS(View view) {
        startActivity(new Intent(this, G9_SendSMS.class));
    }

    public void Fun_G10_ReadSMS(View view) {
        startActivity(new Intent(this, G10_ReadSMS.class));
    }

    public void Fun_G11_ContactDetails(View view) {
        startActivity(new Intent(this, G11_ContactDetails.class));
    }

    public void Fun_G11_ReadContacts(View view) {
        startActivity(new Intent(this, G11_ReadContacts.class));
    }

    public void Fun_G12_CallLogRead(View view) {
        startActivity(new Intent(this, G12_CallLogRead.class));
    }

    public void Fun_G13_CallLogUtility(View view) {
        startActivity(new Intent(this, G13_CallLogUtility.class));
    }

    public void Fun_G13_CallLogWrite(View view) {
        startActivity(new Intent(this, G13_CallLogWrite.class));
    }

    public void Fun_G14_SendMail(View view) {
        startActivity(new Intent(this, G14_SendMail.class));
    }

    public void Fun_G15_TextToSpeech(View view) {
        startActivity(new Intent(this, G15_TextToSpeech.class));
    }

    public void Fun_G16_Camera(View view) {
        startActivity(new Intent(this, G16_Camera.class));
    }

    public void Fun_G18_SMS(View view) {
        startActivity(new Intent(this, G18_SMS.class));
    }
}