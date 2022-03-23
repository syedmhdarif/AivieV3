package com.example.aivieapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.Toast;
import android.widget.VideoView;

public class Activity_music extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    ImageButton mgoback;
    VideoView videoView;
    MediaController mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        mgoback = findViewById(R.id.goback);
        videoView = findViewById(R.id.video_View);
        mc = new MediaController(Activity_music.this);
        videoView.setMediaController(mc);
        mc.setAnchorView(videoView);

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

        View viewPopupwindow = layoutInflater.inflate(R.layout.activity_popupmusic3, null);

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
    public void popupmenu(View view) {
        PopupMenu spopupmenu = new PopupMenu(this, view);
//        spopupmenu = PopupMenu(getApplicationContext(), editpage2);
        spopupmenu.setOnMenuItemClickListener(this);
        spopupmenu.inflate(R.menu.popup_videoedit);
        spopupmenu.show();


    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.rename:
                Toast.makeText(this, "Rename", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.duplicate:
                Toast.makeText(this, "Duplicated", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.delete:
                Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }

    public void PlayButton(View view){

        videoView.start();
        new CountDownTimer(videoView.getDuration(), 1){

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onTick(long millisUntilFinished) {
//                seekBar.setProgress(videoView.getCurrentPosition(), true);
            }

            @Override
            public void onFinish() {

            }
        };
    }
}