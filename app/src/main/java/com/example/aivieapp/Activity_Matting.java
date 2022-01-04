package com.example.aivieapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class Activity_Matting extends AppCompatActivity {
//    ImageButton editpage;
//    ImageButton editpage2;
//    ImageButton mmusicedit;
//    ImageButton meditspeed1;
//    ImageButton meditaudio1;
//    VideoView videoView;
//    MediaController mc;
    //    SeekBar seekBar;
//    SeekBar mprogressBar;
    ImageButton mmgoback;
//    TextView curTime;
//    TextView toTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bgmatting);

//        editpage = findViewById(R.id.Editpage);
//        editpage2 = findViewById(R.id.editsegment8);
//        meditspeed1 = findViewById(R.id.editSpeed1);
//        mmusicedit = findViewById(R.id.musicedit);
//        meditaudio1 = findViewById(R.id.editAudio1);
//        videoView = findViewById(R.id.video_View);
//        seekBar = findViewById(R.id.seekBar2);
        mmgoback = findViewById(R.id.goback);

//        mprogressBar = findViewById(R.id.progressBar);
//        mprogressBar.setProgress(0);
//        mprogressBar.setMax(100);
//
//        curTime = findViewById(R.id.time1);
//        toTime = findViewById(R.id.time5);

//        mc = new MediaController(Activity_Bgmatting.this);
//        videoView.setMediaController(mc);
//        mc.setAnchorView(videoView);
//        editpage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (ContextCompat.checkSelfPermission(Activity_Bgmatting.this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
//                    ActivityCompat.requestPermissions(Activity_Bgmatting.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
//                }
//                else {
//                    selectVideo();
//                }
//            }
//        });
//        editpage2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (ContextCompat.checkSelfPermission(Activity_Bgmatting.this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
//                    ActivityCompat.requestPermissions(Activity_Bgmatting.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
//                }
//                else {
//                    selectVideo2();
//                }
//            }
//        });
        mmgoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
//        mmusicedit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openActivity4();
//                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
//            }
//        });
//        meditaudio1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openActivity4();
//                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
//            }
//        });
//        meditspeed1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openActivity5();
//                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
//            }
//        });
//
//        mprogressBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                if (fromUser){
//                    mprogressBar.setProgress(progress);
//                }
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
//
//        new MyAsync().execute();


//        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                seekBar.setMax(videoView.getDuration());
//            }
//        });

    }

//
//    public void buttonPopupWindow(View view){
//        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
//
//        View viewPopupwindow = layoutInflater.inflate(R.layout.activity_popupsticker, null);
//
//        PopupWindow popupWindow = new PopupWindow(viewPopupwindow, 1400, 1600, true);
//        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
////        popupWindow.setAnimationStyle(R.style.popup_window_animation_phone);
//        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
//
//    }

    private void openActivity3() {
        Intent intent = new Intent(this, Activity_Editpage.class);
        startActivity(intent);
    }
//    private void openActivity4() {
//        Intent intent = new Intent(this, Activity_music.class);
//        startActivity(intent);
//    }
//    private void openActivity5() {
//        Intent intent = new Intent(this, Activity_speed.class);
//        startActivity(intent);
//    }
//
//
//    private class MyAsync extends AsyncTask<Void, Integer, Void>
//    {
//        int duration = 0;
//        int current = 0;
//        @Override
//        protected Void doInBackground(Void... params) {
//
//
//
//            videoView.start();
//            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//
//                public void onPrepared(MediaPlayer mp) {
//                    duration = videoView.getDuration();
//                }
//            });
//
//            do {
//                current = videoView.getCurrentPosition();
//                System.out.println("duration - " + duration + " current- "
//                        + current);
//                try {
//                    publishProgress((int) (current * 100 / duration));
//                    if(mprogressBar.getProgress() >= 100){
//                        break;
//                    }
//                } catch (Exception e) {
//                }
//            } while (mprogressBar.getProgress() <= 100);
//
//            return null;
//        }
//
//        @Override
//        protected void onProgressUpdate(Integer... values) {
//            super.onProgressUpdate(values);
//            System.out.println(values[0]);
//            mprogressBar.setProgress(values[0]);
//        }
//    }
//
//    public void PlayButton(View view){
//
//        videoView.start();
//        new CountDownTimer(videoView.getDuration(), 1){
//
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void onTick(long millisUntilFinished) {
////                seekBar.setProgress(videoView.getCurrentPosition(), true);
//            }
//
//            @Override
//            public void onFinish() {
//
//            }
//        };
//    }
//
//    private void selectVideo() {
//        Intent intent = new Intent(Intent.ACTION_PICK);
//        intent.setType("video/*");
//        startActivityForResult(Intent.createChooser(intent, "select video"), 100);
//    }
//
//    private void selectVideo2() {
//        Intent intent = new Intent(Intent.ACTION_PICK);
//        intent.setType("video/*");
//        startActivityForResult(Intent.createChooser(intent, "select video"), 100);
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == 1 && grantResults.length> 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//            selectVideo();
//        }
//        else {
//            Toast.makeText(getApplicationContext(), "permission denied", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//
//        super.onActivityResult(requestCode, resultCode, data);
////        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
////            Uri uri = data.getData();
////            Intent intent = new Intent( this,Activity_playvideo.class);
////            intent.putExtra("uri",uri.toString());
////            startActivity(intent);
////
////        }
//        if (requestCode == 100){
//            Uri uri = data.getData();
//            videoView.setVisibility(View.VISIBLE);
//            videoView.setVideoURI(uri);
//            videoView.start();
//
//        }
//    }
//    @SuppressLint("HandlerLeak")
//    private Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
////            Log.i("handler ", "handler called");
//            int current_position = msg.what;
//            mprogressBar.setProgress(current_position);
//            String cTime = createTimeLabel(current_position);
//            curTime.setText(cTime);
//        }
//    };
//    public String createTimeLabel (int duration){
//        String timerlabel = "";
//        int min = duration / 1000 / 60;
//        int sec = duration / 1000 % 60;
//
//        timerlabel += min + ":";
//
//        if (sec<10)timerlabel += "0";
//        timerlabel += sec;
//
//        return timerlabel;
//
//    }
}