package com.practice.PHPApi;

import androidx.appcompat.app.AppCompatActivity;

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

public class Php1_InsertData extends AppCompatActivity {

    EditText txt_Name;
    RequestQueue requestQueue;
    String REGISTER_URL = "http://PHPAPI.anantanantsports.com/categoryadd.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_php1_insert_data);

        txt_Name = findViewById(R.id.Php1_txtName);

        //creating request queue to send request to server
        requestQueue = Volley.newRequestQueue(Php1_InsertData.this);
    }


    public void Php1_fun_Submit(View view) {
        String PName = txt_Name.getText().toString();

        if (PName.equals("")) {
            Toast.makeText(this, "Enter Name to Save", Toast.LENGTH_SHORT).show();
        } else {
            InsertRequest registerRequest = new InsertRequest(PName, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    //Log.i("Response", response);
                    try {
                        JSONObject obj = new JSONObject(response);
                        String stat = obj.getString("Status");
                        //if (new JSONObject(response).getString("Status").equals("Success")) {
                        if (stat.equals("Success")) {
                            Toast.makeText(Php1_InsertData.this, "Data Successfully Inserted", Toast.LENGTH_SHORT).show();
                            txt_Name.setText("");
                        } else
                            Toast.makeText(Php1_InsertData.this, "Something Has Happened. Please Try Again!", Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
            requestQueue.add(registerRequest);
        }
    }

    public class InsertRequest extends StringRequest {
        Map<String, String> parameters;

        public InsertRequest(String nameJi, Response.Listener<String> listener) {
            super(Method.POST, REGISTER_URL, listener, null);
            parameters = new HashMap<>();
            parameters.put("CategoryName", nameJi);
        }

        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            return parameters;
        }
    }
}