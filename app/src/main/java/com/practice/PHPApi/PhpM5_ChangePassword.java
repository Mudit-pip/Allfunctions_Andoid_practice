package com.practice.PHPApi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.practice.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PhpM5_ChangePassword extends AppCompatActivity {

    EditText txtCurrentPass, txtNewPass, txtConfirmPass;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_php_m5_change_password);

        txtCurrentPass = (EditText) findViewById(R.id.PhpM5_txtCurrentPass);
        txtNewPass= (EditText) findViewById(R.id.PhpM5_txtNewPass);
        txtConfirmPass= (EditText) findViewById(R.id.PhpM5_txtConfirmPass);

        //creating request queue
        requestQueue = Volley.newRequestQueue(PhpM5_ChangePassword.this);
    }


    public void PhpM5_fun_Submit(View view) {
        String CurrentPass = txtCurrentPass.getText().toString();
        String NewPass = txtNewPass.getText().toString();
        String ConfirmPass = txtConfirmPass.getText().toString();


        SharedPreferences pref = getSharedPreferences("PrefPHP", MODE_PRIVATE);
        String RegId =  pref.getString("RegId", "") ;


        RegisterRequest registerRequest = new RegisterRequest(CurrentPass, NewPass, RegId,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("Response", response);

                try {
                    if (new JSONObject(response).getString("Status").equals("Success")) {
                        Toast.makeText(PhpM5_ChangePassword.this, "Account Successfully Created", Toast.LENGTH_SHORT).show();
                        //finish();
                    } else
                        Toast.makeText(PhpM5_ChangePassword.this, "Something Has Happened. Please Try Again!", Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        requestQueue.add(registerRequest);
    }

    public class RegisterRequest extends StringRequest {
        private static final String REGISTER_URL = "http://PHPAPI.anantanantsports.com/changepassword.php";
        private Map<String, String> parameters;

        public RegisterRequest(String CurrentPass, String NewPass, String RegId, Response.Listener<String> listener) {
            super(Method.POST, REGISTER_URL, listener, null);
            parameters = new HashMap<>();
            parameters.put("NewPassword", NewPass);
            parameters.put("CurrentPassword", CurrentPass);
            parameters.put("RegId", RegId);
        }

        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            return parameters;
        }
    }

}