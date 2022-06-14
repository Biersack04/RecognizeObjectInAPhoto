package com.example.recognizeobjectinaphoto;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.MediaStore;

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

    /*
    @Override
    public void onBackPressed() {
        Log.i(Constants.TAG_MAIN, getString(R.string.exitTheProgram) );
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 1) {
            fm.popBackStackImmediate();
        } else {
            new AlertDialog.Builder(this)
                    .setMessage(R.string.reallyQuitTheProgram)
                    .setCancelable(false)
                    .setPositiveButton(R.string.yes,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    moveTaskToBack(true);
                                    Process.killProcess(Process.myPid());
                                    System.exit(0);
                                }
                            }).setNegativeButton(R.string.no, null).show();
        }
    }*/




}