package com.eventify.eventify.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eventify.eventify.DetailsActivity;
import com.eventify.eventify.LogInActivity;
import com.eventify.eventify.adapter.CatererAdapter;
import com.eventify.eventify.adapter.DecoratorAdapter;
import com.eventify.eventify.adapter.EventAdapter;
import com.eventify.eventify.databinding.FragmentDecoratorBinding;
import com.eventify.eventify.db.DBManager;
import com.eventify.eventify.models.Caterer;
import com.eventify.eventify.models.Decorator;
import com.eventify.eventify.models.Venue;

import java.util.ArrayList;

public class DecoratorFragment extends Fragment {

    FragmentDecoratorBinding binding;

    RecyclerView recyclerView;
    DecoratorAdapter adapter;

    ArrayList<Decorator> decorator = new ArrayList<>();

    private void populateListView(){

        recyclerView = binding.recyclerViewDisplay;
        DBManager mgr = new DBManager(getContext());
        decorator.clear();
        decorator = mgr.getAllDecorator();

        adapter = new DecoratorAdapter(getContext(), decorator);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDecoratorBinding.inflate(getLayoutInflater());
        populateListView();

        binding.imageButtonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LogInActivity.class);
                startActivity(intent);
            }
        });

        binding.imageButtonCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                startActivity(intent);
            }
        });

        return binding.getRoot();
    }


}
