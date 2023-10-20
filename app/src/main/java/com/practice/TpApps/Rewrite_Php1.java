package com.practice.TpApps;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Rewrite_Php1 extends AppCompatActivity {
    EditText txt;
    RequestQueue requestQueue;

    String url = "http://PHPAPI.anantanantsports.com/categoryadd.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewrite_php1);

        txt = findViewById(R.id.Rewrite_Php1_txtName);

        requestQueue = Volley.newRequestQueue(Rewrite_Php1.this);

    }

    public void Rewrite_Php1_fun_Submit(View view) {
        String name = txt.getText().toString();

        Insert ins = new Insert(name, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    String str = obj.getString("Status");

                    if(str.equals("Success")){
                        txt.setText("");
                        Toast.makeText(Rewrite_Php1.this, "Done", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Rewrite_Php1.this, "error", Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        requestQueue.add(ins);

    }


    public class Insert extends StringRequest{
        Map<String, String> para;


        public Insert(String Name, Response.Listener<String> listener) {
            super(Method.POST, url, listener, null);
            para = new HashMap<>();
            para.put("CategoryName", Name);
        }

        @Nullable
        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            return para;
        }
    }


}