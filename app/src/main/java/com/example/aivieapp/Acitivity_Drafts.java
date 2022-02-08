package com.example.aivieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Acitivity_Drafts extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    ImageButton sbackbuttonDraft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acitivity_drafts);

        sbackbuttonDraft = findViewById(R.id.backbuttonDraft);

        sbackbuttonDraft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
    }
    private void openActivity1() {
        Intent intent = new Intent(this, Activity_home.class);
        startActivity(intent);
    }

    public void popupmenu(View view) {
        PopupMenu spopupmenu = new PopupMenu(this, view);
        spopupmenu.setOnMenuItemClickListener(this);
        spopupmenu.inflate(R.menu.popup_menu);
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
}