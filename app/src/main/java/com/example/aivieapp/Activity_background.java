package com.example.aivieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Activity_background extends AppCompatActivity {

    ImageButton mmgoback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background);

        mmgoback = findViewById(R.id.goback3);

        mmgoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity6();
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
    }

    private void openActivity6() {
        Intent intent = new Intent(this, Activity_Editpage.class);
        startActivity(intent);
    }
}