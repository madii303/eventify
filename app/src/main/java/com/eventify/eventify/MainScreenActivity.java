package com.eventify.eventify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.metrics.Event;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import com.eventify.eventify.adapter.EventAdapter;
import com.eventify.eventify.databinding.ActivityMainScreenBinding;
import com.eventify.eventify.db.DBManager;
import com.eventify.eventify.fragments.ProfileFragment;
import com.eventify.eventify.fragments.VenueFragment;
import com.eventify.eventify.fragments.CatererFragment;
import com.eventify.eventify.fragments.DecoratorFragment;
import com.eventify.eventify.models.Caterer;
import com.eventify.eventify.models.Decorator;
import com.eventify.eventify.models.Venue;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainScreenActivity extends AppCompatActivity {

    ActivityMainScreenBinding binding;

    private void loadFragment(Fragment f){
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.dashboard_container, f).commit();
        //getSupportFragmentManager().beginTransaction().replace(R.id.dashboard_container, f).commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadFragment(new VenueFragment());

        binding.bottomNavDashboard.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(R.id.action_venue == item.getItemId()){
                    loadFragment(new VenueFragment());
                }
                else if(R.id.action_caterer == item.getItemId()){
                    loadFragment(new CatererFragment());
                }
                else if(R.id.action_decorator == item.getItemId()){
                    loadFragment(new DecoratorFragment());
                }
                else{
                    loadFragment(new ProfileFragment());
                }
                return true;
            }
        });
    }
}