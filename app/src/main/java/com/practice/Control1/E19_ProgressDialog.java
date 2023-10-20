package com.practice.Control1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.practice.R;

public class E19_ProgressDialog extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e19_progress_dialog);

        btn=findViewById(R.id.E19_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog progressDialog=new ProgressDialog(E19_ProgressDialog.this);
                progressDialog.setCancelable(false);
                progressDialog.show();
                progressDialog.dismiss();
            }
        });
    }
}