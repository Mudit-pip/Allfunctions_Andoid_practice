package com.practice.Control1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ZoomButton;

import com.practice.R;

import org.w3c.dom.Text;

public class E21_ZoomButton extends AppCompatActivity {
    ZoomButton zbplus, zbminus;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e21_zoom_button);

        zbplus = findViewById(R.id.E21_btnPlus);
        zbminus = findViewById(R.id.E21_btnMinus);
        img = findViewById(R.id.E21_Img);

        zbplus.setOnClickListener(new View.OnClickListener() {
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

        zbminus.setOnClickListener(new View.OnClickListener() {
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