package com.practice.Control1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.practice.R;

public class E6_RadioButton extends AppCompatActivity {

    EditText number1, number2;
    TextView labelans;
    RadioButton radadd,radsub,radmul,raddiv;

    int ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e6_radio_button);

        number1 = findViewById(R.id.E6_txt_num1);
        number2 = findViewById(R.id.E6_txt_num2);
        labelans = findViewById(R.id.E6_lbl_ans);

        radadd = findViewById(R.id.E6_rdo_Add);
        radsub = findViewById(R.id.E6_rdo_sub);
        radmul = findViewById(R.id.E6_rdo_mul);
        raddiv = findViewById(R.id.E6_rdo_div);

    }


    public void E6_btn_Calc(View view) {
        int n1, n2, res=0;

        n1 =Integer.parseInt(number1.getText().toString());
        n2 =Integer.parseInt(number2.getText().toString());

        if(radadd.isChecked())
            res=n1+n2;
        else if(radsub.isChecked())
            res=n1-n2;
        else if(radmul.isChecked())
            res=n1*n2;
        else if(raddiv.isChecked())
            res=n1/n2;

        labelans.setText(String.valueOf(res));

    }
}