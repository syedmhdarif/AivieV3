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

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private static final String TAG = "RecyclerAdapter";
//    int count = 0;

    List<String> moviesList;



    public RecyclerAdapter(List<String> moviesList) {
        this.moviesList = moviesList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//        Log.i(TAG, "onCreateViewHolder: " + count++);
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);


        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rowCountTextView.setText(String.valueOf(position));
        holder.textView.setText(moviesList.get(position));

    }

    @Override
    public int getItemCount() {

        return moviesList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView textView, rowCountTextView;
        RelativeLayout sdraft1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageid1);
            textView = itemView.findViewById(R.id.textid1);
            rowCountTextView = itemView.findViewById(R.id.rowCountTextView);
            sdraft1 = itemView.findViewById(R.id.draft1);

            itemView.setOnClickListener(this);

//            itemView.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View v) {
//                    moviesList.remove(getAdapterPosition());
//                    notifyItemRemoved(getAdapterPosition());
//                    return true;
//                }
//            });
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), moviesList.get(getAdapterPosition()), Toast.LENGTH_SHORT).show();
        }


    }
}
