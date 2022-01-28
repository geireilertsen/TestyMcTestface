package com.example.testymctestface;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout nameInputLayout, passwordErrorInputLayout;
    private TextInputEditText nameEditText, passwordEditText;
    private TextView registerClickableTextView;
    private Button loginButton;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);

        nameEditText = findViewById(R.id.nameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        registerClickableTextView = findViewById(R.id.registerClickableTextView);
        loginButton = findViewById(R.id.loginButton);
    }

    public void loginButtonClicked(View view) {
        String nameInput = nameEditText.getText().toString().trim();
        String passwordInput = passwordEditText.getText().toString().trim();
        if(checkInput(nameInput, passwordInput)){
            Toast.makeText(this, nameInput + " " + passwordInput, Toast.LENGTH_SHORT).show();
            closeKeyboard();
        }
    }

    public void registerHereTextViewClicked(View view) {
        Intent i = new Intent(view.getContext(), RegisterActivity.class);
        startActivity(i);
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();

        if (view != null) { InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private boolean checkInput(String name, String password){
        return name.length() > 0 && password.length() > 0;
    }
}
