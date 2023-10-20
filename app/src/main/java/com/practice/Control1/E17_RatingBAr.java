package com.practice.Control1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;

import com.practice.R;

public class E17_RatingBAr extends AppCompatActivity {
RatingBar    rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e17_rating_bar);

        rb=findViewById(R.id.E17_rb);



        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(E17_RatingBAr.this, ""+v, Toast.LENGTH_SHORT).show();
            }
        });
    }
}