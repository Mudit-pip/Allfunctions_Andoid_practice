package com.practice.Control1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.practice.R;

public class E7_checkbox extends AppCompatActivity {
    CheckBox chkASP, chkPHP, chkSEO, chkJAVA, chkAndroid;
    TextView lblMSg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e7_checkbox);

        chkASP = findViewById(R.id.E7_chk_ASP);
        chkPHP = findViewById(R.id.E7_chk_PHP);
        chkAndroid = findViewById(R.id.E7_chk_Android);
        chkJAVA = findViewById(R.id.E7_chk_JAVA);
        chkSEO = findViewById(R.id.E7_chk_SEO);
        lblMSg = findViewById(R.id.E7_lbl_Result);

    }

    public void E7_fun_Show(View view) {
        String Msg = "";

        if (chkPHP.isChecked())
            Msg = Msg + "PHP ";
        if (chkASP.isChecked())
            Msg = Msg + "ASP ";
        if (chkJAVA.isChecked())
            Msg = Msg + "Java ";
        if (chkAndroid.isChecked())
            Msg = Msg + "ANDROID ";
        if (chkSEO.isChecked())
            Msg = Msg + "SEO ";

        lblMSg.setText(Msg);
    }
}