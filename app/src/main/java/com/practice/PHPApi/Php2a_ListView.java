package com.practice.PHPApi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.practice.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class Php2a_ListView extends AppCompatActivity {

    ListView list;
    String arName[];
    RequestQueue requestQueue;
    String urlWebService = "http://PHPAPI.anantanantsports.com/getCategoryList.php";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_php2a_list_view);

        list = findViewById(R.id.Php2a_lst);

        requestQueue = Volley.newRequestQueue(Php2a_ListView.this);
        GetDetails();

    }

    public void GetDetails() {
        RegisterRequest registerRequest = new RegisterRequest(new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    loadIntoListView(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        requestQueue.add(registerRequest);
    }

    public class RegisterRequest extends StringRequest {

        private Map<String, String> parameters;

        public RegisterRequest(Response.Listener<String> listener) {
            super(Method.POST, urlWebService, listener, null);
        }

        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            return parameters;
        }
    }


    private void loadIntoListView(String json) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);

        arName = new String[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            arName[i] = obj.getString("CategoryName");

        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                arName);
        list.setAdapter(arrayAdapter);

    }


}