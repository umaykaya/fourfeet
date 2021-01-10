package com.example.fourfeet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Add extends AppCompatActivity {

    Button mChooseButton;
    ImageView mImageView;
    private static final int IMAGE_PICK_CODE=1000;
    private static final int PERMISSION_CODE=1001;

    private Button btnYes;
    private Button btnNo;
    private Button btnBack;
    EditText txtSpecies;
    EditText txtBreed;
    EditText txtDateOfBirth;
    EditText txtCoat;
    EditText txtSex;

    EditText editTxtVacARab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        mImageView =findViewById(R.id.imageView7);
        mChooseButton=findViewById(R.id.chooseBtn);

        txtSpecies = (EditText) findViewById(R.id.txtSpecies);

        mChooseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                            PackageManager.PERMISSION_DENIED){
                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        requestPermissions(permissions,PERMISSION_CODE);
                    }else {
                        pickImageFromGallery();

                    }

                }else{
                    pickImageFromGallery();

                }
            }
        });



        btnYes = (Button) findViewById(R.id.btnYes);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdd2();
            }
        });

        btnNo = (Button) findViewById(R.id.btnNo);
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHousemates();
            }
        });

        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getBack();
            }
        });
    }


    public void getBack() {
        Intent intent = new Intent(this, Housemates.class);
        startActivity(intent);
    }

    private void openHousemates() {
        Intent intent = new Intent(this, Housemates.class);

        String txtSpeciesFinal=txtSpecies.getText().toString();
        intent.putExtra("txtSpecies",txtSpeciesFinal);

        String txtBreedFinal =txtBreed.getText().toString();
        intent.putExtra("txtBreed", txtBreedFinal);

        String txtSexFinal = txtSex.getText().toString();
        intent.putExtra("txtSex", txtSexFinal);

        String txtCoatFinal = txtCoat.getText().toString();
        intent.putExtra("txtCoat", txtCoatFinal);

        String txtDateOfBirthFinal = txtDateOfBirth.getText().toString();
        intent.putExtra("txtDateOfBirth", txtDateOfBirthFinal);

        SharedPreferences pref = getSharedPreferences("Images", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = pref.edit();
        ed.putInt("IMG", R.drawable.mImageView);
        ed.apply();

        startActivity(intent);
    }

    private void openAdd2(){
        Intent intent = new Intent(this, Add2.class);

        String txtSpeciesFinal=txtSpecies.getText().toString();
        intent.putExtra("txtSpecies",txtSpeciesFinal);

        String txtBreedFinal =txtBreed.getText().toString();
        intent.putExtra("txtBreed", txtBreedFinal);

        String txtSexFinal = txtSex.getText().toString();
        intent.putExtra("txtSex", txtSexFinal);

        String txtCoatFinal = txtCoat.getText().toString();
        intent.putExtra("txtCoat", txtCoatFinal);

        String txtDateOfBirthFinal = txtDateOfBirth.getText().toString();
        intent.putExtra("txtDateOfBirth", txtDateOfBirthFinal);

        SharedPreferences pref = getSharedPreferences("Images", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = pref.edit();
        ed.putInt("IMG", R.drawable.mImageView);
        ed.apply();

        startActivity(intent);
    }

    private void pickImageFromGallery() {
        Intent intent= new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode==RESULT_OK&& requestCode== IMAGE_PICK_CODE){
            mImageView.setImageURI(data.getData());
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PERMISSION_CODE:{
                if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    pickImageFromGallery();
                }else{
                    Toast.makeText(this, "Permission denied.", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
