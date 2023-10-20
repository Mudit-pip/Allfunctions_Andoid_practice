package com.practice.Control1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.practice.R;

public class E8_ImageView extends AppCompatActivity {
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e8_image_view);

        img=findViewById(R.id.E8_img);
    }

    public void E8_fun_Img1(View view) {
        img.setImageResource(R.drawable.f);
    }

    public void E8_fun_Img2(View view) {
        img.setImageResource(R.drawable.abc);
    }

    public void E8_fun_Img3(View view) {
        img.setImageResource(R.drawable.e);
    }

    public void E8_fun_Img4(View view) {
        img.setImageResource(R.drawable.cd);
    }
}