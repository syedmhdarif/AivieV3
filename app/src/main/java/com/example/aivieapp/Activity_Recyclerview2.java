package com.example.aivieapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.aivieapp.Adapter.RecyclerAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Activity_Recyclerview2 extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    ImageButton sbackbuttonDraft;

    List<String> moviesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview2);

        sbackbuttonDraft = findViewById(R.id.backbuttonDraft);

        moviesList = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerAdapter = new RecyclerAdapter(moviesList);


//        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(recyclerAdapter);

        sbackbuttonDraft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });

//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//        recyclerView.addItemDecoration(dividerItemDecoration);

        moviesList.add("Draft 1");
        moviesList.add("Draft 2");
        moviesList.add("Draft 3");
        moviesList.add("Draft 4");
        moviesList.add("Draft 5");
        moviesList.add("Draft 6");
        moviesList.add("Draft 7");
        moviesList.add("Draft 8");
        moviesList.add("Draft 9");
        moviesList.add("Draft 10");
        moviesList.add("Draft 11");
        moviesList.add("Draft 12");
        moviesList.add("Draft 13");
        moviesList.add("Draft 14");

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private void openActivity1() {
        Intent intent = new Intent(this, Activity_home.class);
        startActivity(intent);
    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN
    | ItemTouchHelper.START | ItemTouchHelper.END, 0) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            int fromPosition = viewHolder.getAdapterPosition();
            int toPosition = target.getAdapterPosition();

            Collections.swap(moviesList, fromPosition, toPosition);
            recyclerView.getAdapter().notifyItemMoved(fromPosition, toPosition);
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

        }
    };
}