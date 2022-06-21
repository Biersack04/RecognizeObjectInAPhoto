package com.example.recognizeobjectinaphoto;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

import java.sql.Types;
import java.util.Locale;

public class PhotoActivity extends AppCompatActivity  {

    private MaterialButton capture;
    private Intent cameraIntent;
    private int cameraRequestCode = 001;
    private Bitmap imageBitmap;
    private Classifier classifier;
    private String identifiedType;
    private Intent intentToType ;
    private TextToSpeech myTTS;
    private int MY_DATA_CHECK_CODE = 0;
    private static final int REQUEST_TAKE_PHOTO = 1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        classifier = new Classifier(Utils.assetFilePath(this, Constants.NETWORK_FILE));
        startActivityForResult(cameraIntent, REQUEST_TAKE_PHOTO);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            imageBitmap = (Bitmap) data.getExtras().get(Constants.DATA);
            identifiedType = classifier.predict(imageBitmap);
            myTTS = new TextToSpeech(PhotoActivity.this, new TextToSpeech.OnInitListener() {

                @Override
                public void onInit(int status) {
                    if (status == TextToSpeech.SUCCESS) {
                        myTTS.isLanguageAvailable(new Locale("ru", "RUS"));
                        ConvertTextToSpeech(identifiedType);
                    } else
                        Log.e("error", "Initilization Failed!");
                }
            });

            Toast toast = Toast.makeText(getApplicationContext(),
                    identifiedType, Toast.LENGTH_LONG);
            toast.show();
            intentToType = new Intent(PhotoActivity.this, PhotoActivity.class);
            startActivity(intentToType);


        }
    }


    private void ConvertTextToSpeech(String identifiedType) {
        myTTS.speak(identifiedType, TextToSpeech.QUEUE_FLUSH, null);
    }

    }









