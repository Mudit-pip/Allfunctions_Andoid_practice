package com.practice.Control1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ZoomButton;
import android.widget.ZoomControls;

import com.practice.R;

public class E22_ZoomControl extends AppCompatActivity {
    ZoomControls zc;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e22_zoom_control);

        zc = findViewById(R.id.E22_btnMinus);
        img = findViewById(R.id.E22_Img);

        zc.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x,y;

                x=img.getScaleX();
                y=img.getScaleY();

                x=x+1;
                y=y+1;

                img.setScaleX(x);
                img.setScaleY(y);
            }

        });

        zc.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x,y;

                x=img.getScaleX();
                y=img.getScaleY();

                if(x>1) {
                    x = x - 1;
                    y = y - 1;
                }

                img.setScaleX(x);
                img.setScaleY(y);
            }
        });


    }
}