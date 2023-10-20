package com.practice.Hardware;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;


import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.practice.R;


public class G6_GetCallState1 extends AppCompatActivity {
    Integer PHONESTATE = 1;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g6__get_call_state1);

        txt=findViewById(R.id.G6_txt);

        askForPermission(Manifest.permission.READ_PHONE_STATE,PHONESTATE);

        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);


        PhoneStateListener callStateListener = new PhoneStateListener() {
            public void onCallStateChanged(int state, String incomingNumber)
            {
                if(state==TelephonyManager.CALL_STATE_RINGING){
                    txt.setText(txt.getText() +"\n"+"Phone Is Ringing ");
                }

                if(state==TelephonyManager.CALL_STATE_OFFHOOK){
                    txt.setText(txt.getText() +"\n"+"Phone is Currently in A call");
                }

                if(state==TelephonyManager.CALL_STATE_IDLE){
                    txt.setText(txt.getText() +"\n"+"phone is neither ringing nor in a call");
                }
            }
        };

        telephonyManager.listen(callStateListener,PhoneStateListener.LISTEN_CALL_STATE);

    }


    private void askForPermission(String permission, Integer requestCode) {
        if (ContextCompat.checkSelfPermission(G6_GetCallState1.this, permission) != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(G6_GetCallState1.this, permission)) {
                //This is called if user has denied the permission before
                //In this case I am just asking the permission again
                ActivityCompat.requestPermissions(G6_GetCallState1.this, new String[]{permission}, requestCode);
            } else {
                ActivityCompat.requestPermissions(G6_GetCallState1.this, new String[]{permission}, requestCode);
            }
        } else {
            Toast.makeText(this, "" + permission + " is already granted.", Toast.LENGTH_SHORT).show();
        }
    }
}

