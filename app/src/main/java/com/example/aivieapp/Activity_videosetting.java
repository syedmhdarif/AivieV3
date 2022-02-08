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

public class Activity_videosetting extends AppCompatActivity {

    ImageButton sbackbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videosetting);

        sbackbutton = findViewById(R.id.backbuttonvid);

        sbackbutton.setOnClickListener(new View.OnClickListener() {
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

    public void Buttonreso(View view){
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        View viewPopupwindow = layoutInflater.inflate(R.layout.activity_popupvidsetting, null);

        PopupWindow popupWindow = new PopupWindow(viewPopupwindow, 1400, 900, true);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
//        popupWindow.setAnimationStyle(R.style.popup_window_animation_phone);
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);

    }

    public void buttonframerate(View view){
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        View viewPopupwindow = layoutInflater.inflate(R.layout.activity_popupframerate, null);

        PopupWindow popupWindow = new PopupWindow(viewPopupwindow, 1400, 900, true);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
//        popupWindow.setAnimationStyle(R.style.popup_window_animation_phone);
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);

    }
}