package com.itrainasia.roomwordssample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends
        RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    List<Word> mWords = new ArrayList<>();


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext()),parent);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.textView.setText(mWords.get(position).getWord());
    }

    @Override
    public int getItemCount() {
        return mWords.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        public CustomViewHolder(LayoutInflater inflater, @NonNull ViewGroup parent) {
            super(inflater.inflate(R.layout.custom_row,parent,false));
            textView = itemView.findViewById(R.id.textView);

        }
    }
}
