package com.example.fourfeet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Add2 extends AppCompatActivity {

    private Button btnBack;
    private Button btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add2);

        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdd();
            }
        });

        btnDone =(Button) findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHousemates();
            }
        });
    }

    private void openHousemates() {
        Intent intent= new Intent(this, Housemates.class);
        startActivity(intent);
    }

    private void openAdd() {
        Intent intent =new Intent(this, Add.class);
        startActivity(intent);
    }
}