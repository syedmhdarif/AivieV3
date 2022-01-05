package com.example.aivieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Activity_Setting extends AppCompatActivity {
    ImageButton sgoback;
    ImageButton mbuttonsetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        sgoback = findViewById(R.id.backbutton);
        mbuttonsetting = findViewById(R.id.buttonsetting);

        sgoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });

        mbuttonsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
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
}