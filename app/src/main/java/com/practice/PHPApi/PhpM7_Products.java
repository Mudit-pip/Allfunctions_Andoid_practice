package com.practice.PHPApi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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

public class PhpM7_Products extends AppCompatActivity {

    ListView lst;
    String arProductName[], arProductPrice[], arProductRating[], arproductId[];
    RequestQueue requestQueue;
    String urlWebService = "http://PHPAPI.anantanantsports.com/getProducts.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_php_m7_products);

        lst = (ListView) findViewById(R.id.PhpM7_lst);


        requestQueue = Volley.newRequestQueue(PhpM7_Products.this);
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

        arProductName = new String[jsonArray.length()];
        arProductPrice = new String[jsonArray.length()];
        arProductRating = new String[jsonArray.length()];
        arproductId = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            arProductName[i] = obj.getString("ProductName");
            arProductPrice[i] = obj.getString("Price");
            arProductRating[i] = obj.getString("Rating");
            arproductId[i] = obj.getString("ProductId");
        }

        CustAdpt adpt = new CustAdpt(this, arProductName, arProductRating, arProductPrice, arproductId);
        lst.setAdapter(adpt);
    }

    public class CustAdpt extends ArrayAdapter<String> {
        String sproductName[];
        String sproductPrice[];
        String sproductRating[];
        String sproductId[];
        Context tcontext;

        public CustAdpt(Context context, String Lproductname[], String LproductPrice[], String LproductRating[], String LproductId[]) {
            super(context, R.layout.phpm7_products_row, R.id.phpM7_row_Productname, Lproductname);
            tcontext = context;
            sproductName = Lproductname;
            sproductPrice = LproductPrice;
            sproductRating = LproductRating;
            sproductId = LproductId;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            CustAdpt.viewHolder vholder = null;

            if (row == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(tcontext.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.phpm7_products_row, parent, false);
                vholder = new CustAdpt.viewHolder(row);
                row.setTag(vholder);
            } else {
                vholder = (CustAdpt.viewHolder) row.getTag();
            }
            vholder.txtProductName.setText(sproductName[position]);
            vholder.txtProductPrice.setText(sproductPrice[position]);
            vholder.txtProductrating.setText(sproductRating[position]);
            vholder.txtProductId.setText(sproductId[position]);
            return row;
        }

        public class viewHolder {
            TextView txtProductName;
            TextView txtProductPrice;
            TextView txtProductrating;
            TextView txtProductId;


            public viewHolder(View v) {
                txtProductName = (TextView) v.findViewById(R.id.phpM7_row_Productname);
                txtProductPrice = (TextView) v.findViewById(R.id.phpM7_row_ProductPrice);
                txtProductrating = (TextView) v.findViewById(R.id.phpM7_row_ProductRating);
                txtProductId = (TextView) v.findViewById(R.id.phpM7_row_ProductId);
            }
        }
    }
}
