package com.eventify.eventify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.eventify.eventify.databinding.ActivityDetailsBinding;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        String stringId = getIntent().getStringExtra("id");
//        int id = Integer.parseInt(stringId);
//
//        String name = getIntent().getStringExtra("type");

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsActivity.this, PaymentActivity.class);
                startActivity(intent);
            }
        });

        ArrayList<String> type = new ArrayList<>();
        type.add("Select Type");
        type.add("Conference");
        type.add("Meeting");
        type.add("Party");
        type.add("Wedding");

        ArrayAdapter<String> Adp = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, type);
        binding.spinnerType.setAdapter(Adp);

    }
}
