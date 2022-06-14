package com.example.recognizeobjectinaphoto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class PhotoActivity extends AppCompatActivity {

    private MaterialButton capture;
    private Intent cameraIntent;
    private int cameraRequestCode = 001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent,cameraRequestCode);
        setContentView(R.layout.activity_main);


        capture = findViewById(R.id.capture_button);
        capture.setTypeface(Typeface.createFromAsset(getAssets(),getString(R.string.elsie_regular)));
/*
        capture.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,cameraRequestCode);
            }
        });*/
    }




}