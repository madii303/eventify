package com.eventify.eventify.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Toast;

import com.eventify.eventify.DetailsActivity;
import com.eventify.eventify.LogInActivity;
import com.eventify.eventify.R;
import com.eventify.eventify.adapter.EventAdapter;
import com.eventify.eventify.databinding.FragmentVenueBinding;
import com.eventify.eventify.db.DBManager;
import com.eventify.eventify.models.Caterer;
import com.eventify.eventify.models.Venue;

import java.util.ArrayList;

public class VenueFragment extends Fragment {

    FragmentVenueBinding binding;

    RecyclerView recyclerView;
    EventAdapter adapter;

    ArrayList<Venue> venue = new ArrayList<>();

    private void populateListView(){

        recyclerView = binding.recyclerViewDisplay;
        DBManager mgr = new DBManager(getContext());
        venue.clear();
        venue = mgr.getAllVenue();

        adapter = new EventAdapter(getContext(), venue);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentVenueBinding.inflate(getLayoutInflater());
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
