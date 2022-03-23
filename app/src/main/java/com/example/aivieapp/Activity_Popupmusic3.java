package com.example.aivieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Activity_Popupmusic3 extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popupmusic3);

        listView = (ListView) findViewById(R.id.listView);

        ArrayList<String> arraylist = new ArrayList<>();

        arraylist.add("The only exception");
        arraylist.add("Crazier");
        arraylist.add("Happier");
        arraylist.add("Love Back");
        arraylist.add("Give me your forever");
        arraylist.add("Why I love you");

        ArrayAdapter arrayAdapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1,arraylist);

        listView.setAdapter(arrayAdapter);
    }
}