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
import com.eventify.eventify.SignUpActivity;
import com.eventify.eventify.adapter.AdminCatererAdapter;
import com.eventify.eventify.adapter.CatererAdapter;
import com.eventify.eventify.databinding.FragmentAdminCatererBinding;
import com.eventify.eventify.databinding.FragmentCatererBinding;
import com.eventify.eventify.db.DBManager;
import com.eventify.eventify.models.Caterer;

import java.util.ArrayList;

public class AdminCatererFragment extends Fragment {

   FragmentAdminCatererBinding binding;

    RecyclerView recyclerView;
    AdminCatererAdapter adapter;

    ArrayList<Caterer> caterer = new ArrayList<>();

    private void populateListView(){

        recyclerView = binding.recyclerViewDisplay;
        DBManager mgr = new DBManager(getContext());
        caterer.clear();
        caterer = mgr.getAllCaterer();

        adapter = new AdminCatererAdapter(getContext(), caterer);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentAdminCatererBinding.inflate(getLayoutInflater());
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