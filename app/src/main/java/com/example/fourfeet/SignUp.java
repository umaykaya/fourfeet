package com.example.fourfeet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUp extends AppCompatActivity {
    private Button btnBack;
    private Button btnContiniue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });

        btnContiniue= (Button) findViewById(R.id.btnContiniue);
        btnContiniue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivation();
            }
        });
    }

    private void openLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    private void openActivation() {
        Intent intent = new Intent(this, signupActivation.class);
        startActivity(intent);
    }

}