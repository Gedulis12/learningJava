package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // when the page is created the following view will be displayed:
        setContentView(R.layout.activity_login);

        EditText username = findViewById(R.id.username_input);
        EditText password = findViewById(R.id.password_input);
        Button login = findViewById(R.id.login_button);
        Button newAcc = findViewById(R.id.login_register_button);

        // button click:
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // define here what happens when a button is clicked
                username.setError(null);
                password.setError(null);
                /*if (Validation.isPasswordValid(
                        password.getText().toString()) &&
                        Validation.isUsernameValid(username.getText().toString())) {

                    // if the user input is correct go to main activity
                    Intent goToMainActivity = new Intent(LoginActivity.this, MainActivity.class);

                    // moving to different activity (must pass intent as a function parameter)
                    startActivity(goToMainActivity);

                    Toast.makeText(getApplicationContext(),
                            "Welcome " + R.string.login_username,
                            Toast.LENGTH_LONG).show();
                } else {
                    username.setError(getResources().getString(R.string.bad_login_pattern));
                    password.setError(getResources().getString(R.string.bad_login_pattern));
                    password.requestFocus(); // moves cursor on the password field
                }
               */
                if (!Validation.isUsernameValid(username.getText().toString())) {
                    username.setError(getResources().getString(R.string.bad_login_pattern));
                    username.requestFocus();
                } else if (!Validation.isPasswordValid(password.getText().toString())) {
                   password.setError(getResources().getString(R.string.bad_login_pattern));
                   password.requestFocus();
                } else {
                    // if the user input is correct go to main activity
                    Intent goToMainActivity = new Intent(LoginActivity.this, MainActivity.class);

                    // moving to different activity (must pass intent as a function parameter)
                    startActivity(goToMainActivity);

                    Toast.makeText(getApplicationContext(),
                            "Welcome " + username.getText(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        newAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToRegisterActivity = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(goToRegisterActivity);
            }
        });
    }
}