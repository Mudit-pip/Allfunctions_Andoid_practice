package com.practice.Control1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.practice.R;

public class E5_calc extends AppCompatActivity {
 EditText num1, num2;
 TextView lbl;

 float ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e5_calc);

        num1 = findViewById(R.id.E5_txt_num1);
        num2 = findViewById(R.id.E5_txt_num2);
        lbl = findViewById(R.id.E5_lbl_sum);
    }


    public void E5_add_button1(View view) {
        ans = Float.parseFloat(num1.getText().toString()) +  Float.parseFloat(num2.getText().toString());;
        lbl.setText(String.valueOf(ans));

    }

    public void E5_sub_button2(View view) {
        ans = Float.parseFloat(num1.getText().toString()) - Float.parseFloat(num2.getText().toString());;
        lbl.setText(String.valueOf(ans));
    }

    public void E5_mul_button3(View view) {
        ans = Float.parseFloat(num1.getText().toString()) * Float.parseFloat(num2.getText().toString());
        lbl.setText(String.valueOf(ans));
    }

    public void E5_div_button4(View view) {
        ans = Float.parseFloat(num1.getText().toString())/Float.parseFloat(num2.getText().toString());;
        lbl.setText(String.valueOf(ans));
    }
}