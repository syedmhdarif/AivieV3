package com.example.aivieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.example.aivieapp.Adapter.RecyclerAdapter;
import com.example.aivieapp.Adapter.RecylerAdapter2;

import java.util.ArrayList;
import java.util.List;

public class Activity_popupmusic2 extends AppCompatActivity {

    RelativeLayout mmainpopup;
    float v=0;

    RecyclerView recyclerView2;
    RecylerAdapter2 recyclerAdapter2;
    List<String> musicsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popupmusic2);

        musicsList = new ArrayList<>();

        recyclerView2 = findViewById(R.id.recyclerView2);
        recyclerAdapter2 = new RecylerAdapter2(musicsList);



//        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setAdapter(recyclerAdapter2);

//        mmainpopup = findViewById(R.id.mainpopup);
//
//        mmainpopup.setTranslationY(300);
//
//        mmainpopup.setAlpha(v);
//
//        mmainpopup.animate().translationY(0).alpha(1).setDuration(600).setStartDelay(400).start();

        musicsList.add("Draft 1");
        musicsList.add("Draft 2");
        musicsList.add("Draft 3");
        musicsList.add("Draft 4");
        musicsList.add("Draft 5");
        musicsList.add("Draft 6");
        musicsList.add("Draft 7");
        musicsList.add("Draft 8");
        musicsList.add("Draft 9");
        musicsList.add("Draft 10");

    }
}