package com.example.testymctestface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void backButtonClicked(View view) {
        Intent i = new Intent(view.getContext(), MainActivity.class);
        startActivity(i);
    }
}