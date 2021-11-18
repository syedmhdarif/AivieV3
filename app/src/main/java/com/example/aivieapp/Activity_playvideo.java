package com.example.aivieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class Activity_playvideo extends AppCompatActivity {

    VideoView videoView;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        mvideoView = findViewById(R.id.video_View);
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_playvideo);
//
//        Uri videoUri = Uri.parse(getIntent().getExtras().getString("videoUri"));
//        mvideoView.setVideoURI(videoUri);
//        mvideoView.start();
//    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        mvideoView = findViewById(R.id.video_View);
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_playvideo);
//
//        Bundle bundle = getIntent().getExtras();
//
//        if (bundle != null){
//            Uri videoUri = Uri.parse(bundle.getString("videoUri"));
//            mvideoView.setVideoURI(videoUri);
//            mvideoView.start();
//        }
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        videoView = findViewById(R.id.video_View);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playvideo);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            Uri uri = Uri.parse(bundle.getString("uri"));
            videoView.setVideoURI(uri);
            videoView.start();
        }
    }
}