package com.practice.PHPApi;

import androidx.appcompat.app.AppCompatActivity;

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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PhpM4_EditProfile extends AppCompatActivity {

    EditText txtName, txtEmail;
    RequestQueue requestQueue;
    String RegId ;
    String Update_URL = "http://PHPAPI.anantanantsports.com/editprofile.php";
    String Get_URL = "http://PHPAPI.anantanantsports.com/getRegistrationById.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_php_m4_edit_profile);

        txtName =  findViewById(R.id.PhpM4_txtName);
        txtEmail =  findViewById(R.id.PhpM4_txtEmail);

        requestQueue = Volley.newRequestQueue(PhpM4_EditProfile.this);
        FillValues();
    }
    private void FillValues() {
        SharedPreferences pref = getSharedPreferences("PrefPHP", MODE_PRIVATE);
        RegId =  pref.getString("RegId", "") ;

        getDetailsRequest getdetailrequest = new getDetailsRequest(RegId, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    if (new JSONObject(response).getString("Status").equals("Success")) {
                        loadIntoListView(response);
                    } else
                        Toast.makeText(PhpM4_EditProfile.this, "Something Has Happened. Please Try Again!", Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        requestQueue.add(getdetailrequest);
    }

    public class getDetailsRequest extends StringRequest {

        private Map<String, String> parameters;

        public getDetailsRequest(String RegId, Response.Listener<String> listener) {
            super(Method.POST, Get_URL, listener, null);
            parameters = new HashMap<>();
            parameters.put("RegId", RegId);
        }

        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            return parameters;
        }
    }

    private void loadIntoListView(String json) throws JSONException {
        JSONObject obj = new JSONObject(json);
        txtName.setText(obj.getString("RegName"));
        txtEmail.setText(obj.getString("RegEmail"));
    }


    public void PhpM4_fun_Submit(View view) {

        SharedPreferences pref = getSharedPreferences("PrefPHP", MODE_PRIVATE);
        RegId =  pref.getString("RegId", "") ;

        String PName = txtName.getText().toString();
        String Email = txtEmail.getText().toString();

        ProfileUpdateRequest updateRequest = new ProfileUpdateRequest(RegId, PName, Email, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    if (new JSONObject(response).getString("Status").equals("Success")) {
                        Toast.makeText(PhpM4_EditProfile.this, "Profile Updated Successfully", Toast.LENGTH_SHORT).show();
                        //finish();
                    } else
                        Toast.makeText(PhpM4_EditProfile.this, "Something Has Happened. Please Try Again!", Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        requestQueue.add(updateRequest);
    }

    public class ProfileUpdateRequest extends StringRequest {

        private Map<String, String> parameters;

        public ProfileUpdateRequest(String regId, String name, String email, Response.Listener<String> listener) {
            super(Method.POST, Update_URL, listener, null);
            parameters = new HashMap<>();
            parameters.put("Name", name);
            parameters.put("Email", email);
            parameters.put("RegId", regId);

        }

        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            return parameters;
        }
    }

}
