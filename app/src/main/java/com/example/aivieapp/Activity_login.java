package com.example.aivieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_login extends AppCompatActivity {
    private Button login;
    private Button login2;
    ConstraintLayout loginarea;
    float v=0;
    @SuppressLint("WrongViewCast")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginarea = findViewById(R.id.loginarea);

        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });

        login2 = (Button) findViewById(R.id.login2);
        login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });

        loginarea.setTranslationY(300);

        loginarea.setAlpha(v);

        loginarea.animate().translationY(0).alpha(1).setDuration(600).setStartDelay(400).start();
    }
    public void openActivity3(){
        Intent intent = new Intent(this, Activity_home.class);
        startActivity(intent);
    }
}