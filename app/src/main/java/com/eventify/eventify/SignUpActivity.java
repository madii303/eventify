package com.eventify.eventify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.eventify.eventify.databinding.ActivitySignUpBinding;
import com.eventify.eventify.db.DBManager;
import com.eventify.eventify.models.User;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBManager mgr = new DBManager(this);

        String username = binding.editTextEmail.getText().toString();
        String password = binding.editTextPassword.getText().toString();
        String contact = binding.editTextContact.getText().toString();

        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.Username = username;
                user.Password = password;
                user.Contact_no = contact;
                user.Contact_email = "";
                user.User_type = "user";
                mgr.addUser(user);

                Toast.makeText(SignUpActivity.this, "User Created Successfully!", Toast.LENGTH_LONG).show();

            }
        });

        binding.linkSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
                startActivity(intent);
            }
        });
    }
}