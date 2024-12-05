package com.example.lesson_1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activitty);

        TextView messageTextView = findViewById(R.id.textView);
        String message = getIntent().getStringExtra("MESSAGE_KEY");
        if (message != null) {
            messageTextView.setText(message);
        }
    }
}