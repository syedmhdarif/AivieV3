package com.example.aivieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;

public class Activity__popupsticker extends AppCompatActivity {

    ConstraintLayout mmainpopup;
    float v=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popupsticker);

        mmainpopup = findViewById(R.id.mainpopup);

        mmainpopup.setTranslationY(300);

        mmainpopup.setAlpha(v);

        mmainpopup.animate().translationY(0).alpha(1).setDuration(600).setStartDelay(400).start();
    }
}