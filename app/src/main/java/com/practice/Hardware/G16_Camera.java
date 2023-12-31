package com.practice.Hardware;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.practice.R;


public class G16_Camera extends AppCompatActivity {
    Button button;
    ImageView imageView;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g16__camera);

        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);

        EnableRuntimePermission();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 1);

            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent i) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bitmap bitmap = (Bitmap) i.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        }
    }

    public void EnableRuntimePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(G16_Camera.this,
                Manifest.permission.CAMERA)) {
            Toast.makeText(G16_Camera.this, "CAMERA permission allows us to Access CAMERA app", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(G16_Camera.this, new String[]{
                    Manifest.permission.CAMERA}, 1);
        }
    }

//    @Override
//    public void onRequestPermissionsResult(int RC, String per[], int[] PResult) {
//        switch (RC) {
//            case RequestPermissionCode:
//                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(G16_Camera.this, "Permission Granted, Now your application can access CAMERA.", Toast.LENGTH_LONG).show();
//                } else {
//                    Toast.makeText(G16_Camera.this, "Permission Canceled, Now your application cannot access CAMERA.", Toast.LENGTH_LONG).show();
//                }
//                break;
//        }
//    }

}