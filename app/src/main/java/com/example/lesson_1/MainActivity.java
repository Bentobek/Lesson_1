package com.example.lesson_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lesson_1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.sendMessege.setOnClickListener(v -> {
            String message = "Hello, this is a test message!";

            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"exemple@gmail.com"});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Test Email");
            emailIntent.putExtra(Intent.EXTRA_TEXT, message);

            if (emailIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(Intent.createChooser(emailIntent, "Choose an email client"));
            }
        });
        binding.sendMessage.setOnClickListener(v -> {
            String message = "Hello, this is a test message!";
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("MESSAGE", message);
            startActivity(intent);

        });
    }
}