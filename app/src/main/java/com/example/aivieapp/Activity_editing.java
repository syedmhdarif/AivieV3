package com.example.aivieapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

public class Activity_editing extends AppCompatActivity {

    private static int VIDEO_REQUEST = 101;
    private Uri videoUri = null;
    Button btn_open;
    ImageView imageView;
    Button recordvideo;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editing);

        imageView = findViewById(R.id.image_View);
        btn_open = findViewById(R.id.btn_open);
        recordvideo = findViewById(R.id.recordvideo);

        if (ContextCompat.checkSelfPermission(Activity_editing.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Activity_editing.this,
                    new String[]{
                            Manifest.permission.CAMERA
                    }, 100);
        }

        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
            }
        });

//        if (ContextCompat.checkSelfPermission(Activity_editing.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(Activity_editing.this,
//                    new String[]{
//                            Manifest.permission.CAMERA
//                    }, 100);
//        }
//
//        recordvideo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
//                startActivityForResult(intent, 100);
//            }
//        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == VIDEO_REQUEST && resultCode == RESULT_OK && data != null) {
            videoUri = data.getData();
//            Uri uri = data.getData();
//            Intent intent = new Intent(this, Activity_playvideo.class);
//            intent.putExtra("uri",uri.toString());
//            startActivity(intent);

        }

        if (requestCode == 100) {
            Bitmap captureImage = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(captureImage);
        }
    }

    public void captureVideo(View view) {
        Intent videoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

        if (videoIntent.resolveActivity(getPackageManager()) !=null){
            startActivityForResult(videoIntent, VIDEO_REQUEST);
        }
    }

    public void playVideo(View view) {
        Intent playIntent = new Intent(this,Activity_playvideo.class);
        playIntent.putExtra("videoUri", videoUri.toString());
        startActivity(playIntent);
    }


}