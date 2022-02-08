package com.example.aivieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Activity_Helpcenter extends AppCompatActivity {
    ImageButton sbackbuttonHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpcenter);

        sbackbuttonHelp = findViewById(R.id.backbuttonHelp);

        sbackbuttonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
    }
    private void openActivity1() {
        Intent intent = new Intent(this, Activity_Setting.class);
        startActivity(intent);
    }
}