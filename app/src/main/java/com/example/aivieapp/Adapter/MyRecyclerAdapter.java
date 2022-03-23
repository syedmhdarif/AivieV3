package com.example.aivieapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aivieapp.Helper.ItemTouchHelperAdapter;
import com.example.aivieapp.Helper.OnStartDragListener;
import com.example.aivieapp.R;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>
implements ItemTouchHelperAdapter {

    Context context;
    List<String> stringList;
    OnStartDragListener listener;

    public MyRecyclerAdapter(Context context, List<String> stringList, OnStartDragListener listener) {
        this.context = context;
        this.stringList = stringList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_caard_item, parent, false));
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txt_number.setText(new StringBuilder().append(position+1));
        holder.txt_title.setText(stringList.get(position));

        holder.item.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                final int action = motionEvent.getAction();
                if (action == MotionEvent.ACTION_DOWN)
                    listener.onStartDrag(holder);
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(stringList, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        stringList.remove(position);
        notifyItemRemoved(position);

    }


    public static class MyViewHolder extends  RecyclerView.ViewHolder{
        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.txt_title)
        TextView txt_title;
        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.txt_number)
        TextView txt_number;
        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.item)
        CardView item;

        Unbinder unbinder;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
        }
    }
}
