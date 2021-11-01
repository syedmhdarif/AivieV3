package com.example.aivieapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;

import androidx.fragment.app.Fragment;

public class VideoTabFragment extends Fragment {


    public View onCeateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.video_fragment, container, false);

        return root;
    }
}
