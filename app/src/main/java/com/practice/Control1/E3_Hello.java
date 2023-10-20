package com.practice.Control1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.practice.R;

public class E3_Hello extends AppCompatActivity {
EditText txtName;
TextView lblMsg;
Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e3_hello);

        txtName = findViewById(R.id.E3_txt_Name);
        lblMsg = findViewById(R.id.E3_lbl_Msg);
        button = findViewById(R.id.E3_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ss;

                ss=txtName.getText().toString();

                lblMsg.setText(ss);
            }
        });
    }

}