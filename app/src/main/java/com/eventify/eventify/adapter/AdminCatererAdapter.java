package com.eventify.eventify.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eventify.eventify.R;
import com.eventify.eventify.models.Caterer;

import java.util.ArrayList;

public class AdminCatererAdapter extends RecyclerView.Adapter<AdminCatererAdapter.AdminCatererViewHolder>{

    ArrayList<Caterer> dataHolder;
    public Context context;

    public AdminCatererAdapter(Context context, ArrayList<Caterer> dataHolder){
        this.context = context;
        this.dataHolder = dataHolder;
    }

    @NonNull
    @Override
    public AdminCatererAdapter.AdminCatererViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_cell_admin, parent, false);
        return new AdminCatererAdapter.AdminCatererViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminCatererAdapter.AdminCatererViewHolder holder, int position) {
        holder.name.setText(dataHolder.get(position).getName());
        holder.info.setText(dataHolder.get(position).getAddress());
        holder.details.setText(dataHolder.get(position).getPrice_range());

        holder.btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Caterer Removed!", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public static class AdminCatererViewHolder extends RecyclerView.ViewHolder {

        TextView name, info, details;
        Button btn_book;

        public AdminCatererViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.text_view_name);
            info = (TextView) itemView.findViewById(R.id.text_view_info);
            details = (TextView) itemView.findViewById(R.id.text_view_details);

            btn_book = (Button) itemView.findViewById(R.id.btn_book);
        }
    }
}
