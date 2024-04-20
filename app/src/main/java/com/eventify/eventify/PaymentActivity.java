package com.eventify.eventify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.eventify.eventify.databinding.ActivityPaymentBinding;

public class PaymentActivity extends AppCompatActivity {

    ActivityPaymentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentActivity.this, MainScreenActivity.class);
                startActivity(intent);

                Toast.makeText(PaymentActivity.this, "BOOKED!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
