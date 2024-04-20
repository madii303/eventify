package com.eventify.eventify.adapter;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eventify.eventify.DetailsActivity;
import com.eventify.eventify.R;
import com.eventify.eventify.models.Caterer;
import com.eventify.eventify.models.Venue;

import java.util.ArrayList;

public class CatererAdapter extends RecyclerView.Adapter<CatererAdapter.CatererViewHolder> {

    ArrayList<Caterer> dataHolder;
    public Context context;


    public CatererAdapter(Context context, ArrayList<Caterer> dataHolder){
        this.context = context;
        this.dataHolder = dataHolder;
    }

    @NonNull
    @Override
    public CatererViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_cell, parent, false);
        return new CatererViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatererViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.name.setText(dataHolder.get(position).getName());
        holder.info.setText(dataHolder.get(position).getAddress());
        holder.details.setText(dataHolder.get(position).getPrice_range());

        holder.btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Caterer Booked!", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public static class CatererViewHolder extends RecyclerView.ViewHolder {

        TextView name, info, details;
        Button btn_book;

        public CatererViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.text_view_name);
            info = (TextView) itemView.findViewById(R.id.text_view_info);
            details = (TextView) itemView.findViewById(R.id.text_view_details);

            btn_book = (Button) itemView.findViewById(R.id.btn_book);
        }
    }
}
