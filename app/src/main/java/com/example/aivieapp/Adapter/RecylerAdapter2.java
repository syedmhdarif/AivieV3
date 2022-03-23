package com.example.aivieapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aivieapp.R;

import java.util.List;

public class RecylerAdapter2 extends RecyclerView.Adapter<RecylerAdapter2.ViewHolder>{

    private static final String TAG = "RecyclerAdapter";

    List<String> musicsList;

    public RecylerAdapter2(List<String> musicsList) {
        this.musicsList = musicsList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.music_lists, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.timevidprev.setText(String.valueOf(position));
        holder.titlemusic1.setText(musicsList.get(position));

    }

    @Override
    public int getItemCount() {
        return musicsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        RelativeLayout music1;
        ImageView vidprev1;
        TextView titlemusic1;
        TextView timevidprev;
        ImageButton addmusicaction;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            music1 = itemView.findViewById(R.id.music1);
            titlemusic1 = itemView.findViewById(R.id.titlemusic1);
            vidprev1 = itemView.findViewById(R.id.vidprev1);
            timevidprev = itemView.findViewById(R.id.timevidprev);
            addmusicaction = itemView.findViewById(R.id.addmusicaction);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), musicsList.get(getAdapterPosition()), Toast.LENGTH_SHORT).show();
        }
    }


}
