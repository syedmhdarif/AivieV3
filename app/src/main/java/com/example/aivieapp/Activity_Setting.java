package com.example.aivieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Activity_Setting extends AppCompatActivity {
    ImageButton sgoback;
    ImageButton mbuttonsetting;
    ImageButton svidsettingbutton;
    ImageButton sbuttonNotification;
    ImageButton sappinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        sgoback = findViewById(R.id.backbutton);
        svidsettingbutton = findViewById(R.id.vidsettingbutton);
        mbuttonsetting = findViewById(R.id.buttonsetting);
        sbuttonNotification = findViewById(R.id.buttonNotification);
        sappinfo = findViewById(R.id.appinfo);

        sgoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
        sbuttonNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });

        mbuttonsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
        sappinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
        svidsettingbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
    }

    private void openActivity1() {
        Intent intent = new Intent(this, Activity_home.class);
        startActivity(intent);
    }
    private void openActivity2() {
        Intent intent = new Intent(this, Activity_Account.class);
        startActivity(intent);
    }
    private void openActivity3() {
        Intent intent = new Intent(this, Activity_videosetting.class);
        startActivity(intent);
    }
    private void openActivity4() {
        Intent intent = new Intent(this, Activity_notifications.class);
        startActivity(intent);
    }
    private void openActivity5() {
        Intent intent = new Intent(this, Activity_appinfo.class);
        startActivity(intent);
    }
}