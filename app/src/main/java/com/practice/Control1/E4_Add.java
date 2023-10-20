package com.practice.Control1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.practice.R;

public class E4_Add extends AppCompatActivity {

    EditText txtNo1, txtNo2;
    TextView lblResult;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e4_add);

        txtNo1 = findViewById(R.id.E4_txt_No1);
        txtNo2 = findViewById(R.id.E4_txt_No2);
        lblResult = findViewById(R.id.E4_txt_Result);
        btnAdd = findViewById(R.id.E4_btn_Add);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1, n2, res;

                n1 =Integer.parseInt(txtNo1.getText().toString());
                n2 =Integer.parseInt(txtNo2.getText().toString());

                res=n1+n2;

                lblResult.setText(String.valueOf(res));

            }
        });

    }

//    public void E4_fun_Add(View view) {
//        int n1, n2, res;
//
//        n1 =Integer.parseInt(txtNo1.getText().toString());
//        n2 =Integer.parseInt(txtNo2.getText().toString());
//
//        res=n1+n2;
//
//        lblResult.setText(String.valueOf(res));
//    }
}