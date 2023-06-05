package com.taskperformance.emoney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LogInPage extends AppCompatActivity {

    private TextInputEditText passwordEditText;
    private Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_page);





        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.BTlogin);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = passwordEditText.getText().toString().trim();
                if (password.equals("maamsopretty03")) {
                    openHomePageActivity();
                } else {
                    Toast.makeText(LogInPage.this, "Incorrect password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openHomePageActivity() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
        finish();
    }



    }


