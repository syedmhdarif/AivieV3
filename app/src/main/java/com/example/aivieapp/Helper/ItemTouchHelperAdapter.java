package com.example.aivieapp.Helper;

public interface ItemTouchHelperAdapter {
    boolean onItemMove (int fromPosition, int toPosition);
    void onItemDismiss(int position);
}
