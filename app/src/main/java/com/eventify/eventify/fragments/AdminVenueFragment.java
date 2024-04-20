package com.eventify.eventify.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eventify.eventify.LogInActivity;
import com.eventify.eventify.R;
import com.eventify.eventify.adapter.AdminEventAdapter;
import com.eventify.eventify.adapter.EventAdapter;
import com.eventify.eventify.databinding.FragmentAdminVenueBinding;
import com.eventify.eventify.databinding.FragmentVenueBinding;
import com.eventify.eventify.db.DBManager;
import com.eventify.eventify.models.Venue;

import java.util.ArrayList;

public class AdminVenueFragment extends Fragment {

    FragmentAdminVenueBinding binding;

    RecyclerView recyclerView;
    AdminEventAdapter adapter;

    ArrayList<Venue> venue = new ArrayList<>();

    private void populateListView(){

        recyclerView = binding.recyclerViewDisplay;
        DBManager mgr = new DBManager(getContext());
        venue.clear();
        venue = mgr.getAllVenue();

        adapter = new AdminEventAdapter(getContext(), venue);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentAdminVenueBinding.inflate(getLayoutInflater());
        populateListView();

        binding.imageButtonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LogInActivity.class);
                startActivity(intent);
            }
        });

        return binding.getRoot();
    }
}