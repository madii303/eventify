package com.eventify.eventify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.eventify.eventify.databinding.ActivityMainBinding;
import com.eventify.eventify.databinding.ActivityMainScreenBinding;
import com.eventify.eventify.fragments.AdminCatererFragment;
import com.eventify.eventify.fragments.AdminDecoratorFragment;
import com.eventify.eventify.fragments.AdminProfileFragment;
import com.eventify.eventify.fragments.AdminVenueFragment;
import com.eventify.eventify.fragments.CatererFragment;
import com.eventify.eventify.fragments.DecoratorFragment;
import com.eventify.eventify.fragments.ProfileFragment;
import com.eventify.eventify.fragments.VenueFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    private void loadFragment(Fragment f){
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.dashboard_container, f).commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadFragment(new AdminVenueFragment());

        binding.bottomNavDashboard.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(R.id.action_venue == item.getItemId()){
                    loadFragment(new AdminVenueFragment());
                }
                else if(R.id.action_caterer == item.getItemId()){
                    loadFragment(new AdminCatererFragment());
                }
                else if(R.id.action_decorator == item.getItemId()){
                    loadFragment(new AdminDecoratorFragment());
                }
                else{
                    loadFragment(new AdminProfileFragment());
                }
                return true;
            }
        });
    }
}