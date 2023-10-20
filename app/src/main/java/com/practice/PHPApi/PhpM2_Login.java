package com.practice.PHPApi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.practice.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PhpM2_Login extends AppCompatActivity {

    String url = "http://PHPAPI.anantanantsports.com/login.php";
    EditText mobile,pass;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_php_m2_login);

        mobile= findViewById(R.id.phpM2_mobile);
        pass = findViewById(R.id.phpM2_password);

        requestQueue = Volley.newRequestQueue(PhpM2_Login.this);
    }

    public void PhpM2_login_btn(View view) {
        String Mobileno = mobile.getText().toString();
        String Password = pass.getText().toString();

        InsertRequest insertRequest = new InsertRequest(Mobileno, Password, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject obj = null;
                try {
                    obj = new JSONObject(response);
                    String stat = obj.getString("Status");

                    if(stat.equals("Success")){

                        SharedPreferences pref=getSharedPreferences("PrefPHP",MODE_PRIVATE);
                        SharedPreferences.Editor editor= pref.edit();
                        editor.putString("RegId",obj.getString("RegId"));
                        editor.putBoolean("IsLogin",true);
                        editor.commit();

                        startActivity(new Intent(PhpM2_Login.this, PhpM3_Home.class));


                        Toast.makeText(PhpM2_Login.this, "Success", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(PhpM2_Login.this, "Failed!!", Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        requestQueue.add(insertRequest);

    }

    public void PhpM2_registernew_btn(View view) {
        startActivity(new Intent(this, PhpM1_Register.class));
    }

    public class InsertRequest extends StringRequest {
        Map<String, String> parameters;

        public InsertRequest(String Mobile, String Password, Response.Listener<String> listener) {
            super(Method.POST, url, listener, null);
            parameters = new HashMap<>();
            parameters.put("Mobile", Mobile);
            parameters.put("Password", Password);
        }

        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            return parameters;
        }
    }


}