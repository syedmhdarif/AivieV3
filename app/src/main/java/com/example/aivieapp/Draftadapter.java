package com.example.aivieapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Draftadapter extends ArrayAdapter<Videodraft> {
    private Context mContext;
    private int mRecource;

    public Draftadapter(@NonNull Context context, int resource, @NonNull ArrayList<Videodraft> objects) {
        super(context, resource, objects);
        this.mContext=context;
        this.mRecource= resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView=layoutInflater.inflate(mRecource, parent, false);

//        Button buttonedit = convertView.findViewById(R.id.buttonedit);
        ImageView imageView = convertView.findViewById(R.id.view1);
        TextView textView = convertView.findViewById(R.id.textView);
        TextView textView2 = convertView.findViewById(R.id.textView2);

        imageView.setImageResource(getItem(position).getImage());
        textView.setText(getItem(position).getName());
        textView2.setText(getItem(position).getDesc());

        return convertView;
    }
}
