package com.example.fourfeet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Housemates extends AppCompatActivity {
    private Button btnAdd;
    private Button btnBack;
    private Button btnEdit;
    ImageView pet1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_housematesctivity);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdd();
            }
        });

        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getBack();
            }
        });

        btnEdit= (Button) findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEdit();
            }
        });

        pet1=(ImageView) findViewById(R.id.imgIcon1);

        SharedPreferences pref = getSharedPreferences("Images", Context.MODE_PRIVATE);
        int res = pref.getInt("IMG",0);
        if(res!=0)
        {
            pet1.setImageResource(res);

        }
    }

    private void openEdit() {
        Intent intent = new Intent(this, Edit.class);
        startActivity(intent);
    }

    private void openAdd(){
        Intent intent = new Intent(this, Add.class);
        startActivity(intent);
    }

    private void getBack(){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}