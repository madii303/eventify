package com.eventify.eventify.adapter;

import android.annotation.SuppressLint;
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
import com.eventify.eventify.models.Decorator;

import java.util.ArrayList;

public class AdminDecoratorAdapter extends RecyclerView.Adapter<AdminDecoratorAdapter.AdminDecoratorViewHolder> {

    ArrayList<Decorator> dataHolder;
    public Context context;


    public AdminDecoratorAdapter(Context context, ArrayList<Decorator> dataHolder){
        this.context = context;
        this.dataHolder = dataHolder;
    }

    @NonNull
    @Override
    public AdminDecoratorAdapter.AdminDecoratorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_cell_admin, parent, false);
        return new AdminDecoratorAdapter.AdminDecoratorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminDecoratorAdapter.AdminDecoratorViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.name.setText(dataHolder.get(position).getName());
        holder.info.setText(dataHolder.get(position).getAddress());
        holder.details.setText(dataHolder.get(position).getPrice_range());


        holder.btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Decorator Removed!", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }


    public static class AdminDecoratorViewHolder extends RecyclerView.ViewHolder {

        TextView name, info, details;
        Button btn_book;

        public AdminDecoratorViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.text_view_name);
            info = (TextView) itemView.findViewById(R.id.text_view_info);
            details = (TextView) itemView.findViewById(R.id.text_view_details);

            btn_book = (Button) itemView.findViewById(R.id.btn_book);
        }
    }
}
