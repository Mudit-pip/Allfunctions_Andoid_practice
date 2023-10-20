package com.practice.PHPApi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.practice.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PhpM1_Register extends AppCompatActivity {

    RequestQueue requestQueue;
    String REGISTER_URL = "http://PHPAPI.anantanantsports.com/register.php";

    EditText txtRegName, txtRegMobile, txtRegEmail, txtRegPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_php_multi_insert);

        txtRegName = findViewById(R.id.PHPM1_txt_Name);
        txtRegMobile = findViewById(R.id.PHPM1_txt_Mobile);
        txtRegEmail = findViewById(R.id.PHPM1_txt_Email);
        txtRegPassword = findViewById(R.id.PHPM1_txt_Password);

        //creating request queue
        requestQueue = Volley.newRequestQueue(PhpM1_Register.this);
    }

    public void PHPM1_fun_Continue(View view) {
        String PName = txtRegName.getText().toString();
        String Mobile = txtRegMobile.getText().toString();
        String Email = txtRegEmail.getText().toString();
        String Password = txtRegPassword.getText().toString();


        RegisterRequest registerRequest = new RegisterRequest(PName, Mobile, Email, Password, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject obj = new JSONObject(response);
                    String stat = obj.getString("status");

                    if (stat.equals("Success")) {
                        Toast.makeText(PhpM1_Register.this, "Account Successfully Created", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(PhpM1_Register.this, "Something Has Happened. Please Try Again!", Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        requestQueue.add(registerRequest);
    }

    public class RegisterRequest extends StringRequest {

        private Map<String, String> parameters;

        public RegisterRequest(String name, String mobile, String email, String password, Response.Listener<String> listener) {
            super(Method.POST, REGISTER_URL, listener, null);
            parameters = new HashMap<>();
            parameters.put("Name", name);
            parameters.put("Password", password);
            parameters.put("Email", email);
            parameters.put("Mobile", mobile);
        }


        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            return parameters;
        }
    }

}