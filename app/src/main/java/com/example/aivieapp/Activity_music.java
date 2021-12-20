package com.example.aivieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupWindow;

public class Activity_music extends AppCompatActivity {

    ImageButton mgoback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        mgoback = findViewById(R.id.goback);

        mgoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
    }
    private void openActivity3() {
        Intent intent = new Intent(this, Activity_Editpage.class);
        startActivity(intent);
    }

    public void buttonPopupWindow(View view){
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        View viewPopupwindow = layoutInflater.inflate(R.layout.activity_popupmusic, null);

        PopupWindow popupWindow = new PopupWindow(viewPopupwindow, 1400, 1600, true);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
//        popupWindow.setAnimationStyle(R.style.popup_window_animation_phone);
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);

    }
    public void buttonPopupWindow2(View view){
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        View viewPopupwindow = layoutInflater.inflate(R.layout.activity_popupmusic, null);

        PopupWindow popupWindow = new PopupWindow(viewPopupwindow, 1400, 1600, true);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
//        popupWindow.setAnimationStyle(R.style.popup_window_animation_phone);
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);

    }
}