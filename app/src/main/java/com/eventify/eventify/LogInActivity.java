package com.eventify.eventify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.eventify.eventify.databinding.ActivityLogInBinding;
import com.eventify.eventify.db.DBManager;

public class LogInActivity extends AppCompatActivity {

    ActivityLogInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.editTextEmail.getText().toString();

                        if (username.equals("Admin") || username.equals("admin")){
                        Intent i = new Intent(LogInActivity.this, MainActivity.class);
                        startActivity(i);
                    }
                    else {
                            Intent j = new Intent(LogInActivity.this, MainScreenActivity.class);
                            startActivity(j);
                        }
            }
        });

        binding.linkSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}