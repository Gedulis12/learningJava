package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText username = findViewById(R.id.register_username_input);
        EditText password = findViewById(R.id.register_password_input);
        EditText email = findViewById(R.id.register_email_input);
        Button register = findViewById(R.id.register_button);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username.setError(null);
                password.setError(null);
                email.setError(null);

                if (!Validation.isUsernameValid(username.getText().toString())) {
                    username.setError(getResources().getString(R.string.bad_register_username));

                } else if (!Validation.isPasswordValid(password.getText().toString())) {
                    password.setError(getResources().getString(R.string.bad_register_password));

                } else if (!Validation.isEmailValid(email.getText().toString())) {
                    email.setError(getResources().getString(R.string.bad_register_email));

                } else {
                    Intent goToLoginActivity = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(goToLoginActivity);


                    Toast.makeText(getApplicationContext(),
                            "New user" + username.getText() + " created successfully!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
