package com.example.aivieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;

public class Activity_Camera extends AppCompatActivity {
    private static int VIDEO_REQUEST = 101;
    private Uri videoUri = null;

    ImageButton recordbutton;
    ImageButton closetab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        recordbutton = findViewById(R.id.Recordbutton);
        closetab = findViewById(R.id.close);

        if (ContextCompat.checkSelfPermission(Activity_Camera.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Activity_Camera.this,
                    new String[]{
                            Manifest.permission.CAMERA
                    }, 100);
        }

        recordbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(intent, 100);
            }
        });

        closetab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
    }
    private void openActivity3() {
        Intent intent = new Intent(this, Activity_home.class);
        startActivity(intent);
    }

}