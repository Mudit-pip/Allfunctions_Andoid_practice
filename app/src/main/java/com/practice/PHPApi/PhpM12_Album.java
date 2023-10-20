package com.practice.PHPApi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.practice.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class PhpM12_Album extends AppCompatActivity {

    GridView lst;
    String arTitle[], arPhotoUrl[], arAlbumId[];
    String urlWebService= "http://PHPAPI.anantanantsports.com/getAlbum.php";
    String BaseUrl = "http://PHPAPI.anantanantsports.com/";
    RequestQueue requestQueue;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_php_m12_album);

        lst = findViewById(R.id.PHPM12_lst);

        requestQueue = Volley.newRequestQueue(PhpM12_Album.this);

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
        arTitle= new String[jsonArray.length()];
        arPhotoUrl= new String[jsonArray.length()];
        arAlbumId= new String[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            arTitle[i] = obj.getString("AlbumName");
            arPhotoUrl[i] =BaseUrl+ obj.getString("PhotoUrl");
            arAlbumId[i] = obj.getString("AlbumId");

        }

        CustAdpt adpt = new CustAdpt(this, arTitle, arPhotoUrl, arAlbumId);
        lst.setAdapter(adpt);
    }

    public class CustAdpt extends ArrayAdapter<String> {
        String mName[];
        String mPhotoUrl[];
        String mAlbumId[];
        Context mcontext;

        public CustAdpt(Context context, String Lname[], String Lphotourl[], String LalbumId[]) {
            super(context, R.layout.activity_phpm_12_row, R.id.lay_PHPM12_txt, Lname);
            mcontext = context;
            mName = Lname;
            mPhotoUrl = Lphotourl;
            mAlbumId = LalbumId;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            CustAdpt.viewHolder vholder = null;

            if (row == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(mcontext.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.activity_phpm_12_row, parent, false);
                vholder = new CustAdpt.viewHolder(row);
                row.setTag(vholder);
            } else {
                vholder = (CustAdpt.viewHolder) row.getTag();
            }

            vholder.txtname.setText(mName[position]);
            vholder.txtname.setTag(mAlbumId[position]);


            vholder.txtname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    String AlbumId= ((TextView)view).getTag().toString();
//                    Intent i=new Intent(PhpM12_Album.this , PhpM14_Gallery.class);
//                    i.putExtra("AlbumId",AlbumId);
//                    startActivity(i);
                }
            });
            vholder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    String AlbumId= ((TextView)view).getTag().toString();
//                    Intent i=new Intent(PhpM12_Album.this , PhpM14_Gallery.class);
//                    i.putExtra("AlbumId",AlbumId);
//                    startActivity(i);
                }
            });


            Glide.with(PhpM12_Album.this)
                    .load(mPhotoUrl[position])
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(vholder.img);



            return row;
        }

        public class viewHolder {
            TextView txtname;
            ImageView img;

            public viewHolder(View v) {
                txtname = (TextView) v.findViewById(R.id.lay_PHPM12_txt);
                img = (ImageView) v.findViewById(R.id.lay_PHPM12_img);
            }
        }
    }
}
