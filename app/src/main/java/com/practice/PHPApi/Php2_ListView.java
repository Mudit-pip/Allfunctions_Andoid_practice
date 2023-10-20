package com.practice.PHPApi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.practice.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Php2_ListView extends AppCompatActivity {
    ListView lst;
    String[] arName;
    String urlWebService = "http://PHPAPI.anantanantsports.com/getCategoryList.php";
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_php2_list_view);
        lst = findViewById(R.id.Php2_lst);

        Pawan getJSON = new Pawan();
        getJSON.execute();
    }

    class Pawan extends AsyncTask<Void, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();


            dialog=new ProgressDialog(Php2_ListView.this);
            dialog.setMessage("Loading");
            dialog.setCancelable(false);
            dialog.show();
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(urlWebService);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                StringBuilder sb = new StringBuilder();

                // Temprary Ram of Client Device=BufferReader
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String s;
                while ((s = bufferedReader.readLine()) != null) {
                    sb.append(s + "\n");
                }
                return sb.toString().trim();

            } catch (Exception e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if(dialog.isShowing())
                dialog.dismiss();

            try {
                loadIntoListView(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadIntoListView(String s) throws JSONException {
        JSONArray jsonArray = new JSONArray(s);
        int n=jsonArray.length();
        arName = new String[n];

        for (int i = 0; i < n; i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            arName[i] = obj.getString("CategoryName");
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                arName);
        lst.setAdapter(arrayAdapter);

    }
}