package com.practice.Hardware;

import android.app.ProgressDialog;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.practice.R;


public class G14_SendMail extends AppCompatActivity {
    EditText txtTo,txtSubject,txtMessage;
    Button btnsend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g14__send_mail);

        txtTo=findViewById(R.id.G14_txt_To);
        txtSubject=findViewById(R.id.G14_txt_Subject);
        txtMessage=findViewById(R.id.G14_txt_Message);

        btnsend=findViewById(R.id.btn_SendMsg);

        btnsend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                ProgressDialog pd = new ProgressDialog(G14_SendMail.this);
                pd.setMessage("Sending ......");
                pd.show();

                //String to="a@gmail.com,b@gmail.com,c@gmail.com,d@gmail.com";
                String to=txtTo.getText().toString();
                String subject=txtSubject.getText().toString();
                String message=txtMessage.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));
                pd.dismiss();
            }
        });
    }
}
