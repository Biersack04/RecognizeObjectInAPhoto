package com.example.recognizeobjectinaphoto;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.material.textview.MaterialTextView;
import static com.example.recognizeobjectinaphoto.Constants.SPLASH_DISPLAY_LENGTH;

public class WelcomeActivity extends AppCompatActivity {

    MaterialTextView loadingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        initTextView();

        new Handler().postDelayed(() -> {

            Intent mainIntent = new Intent(WelcomeActivity.this, PhotoActivity.class);
            WelcomeActivity.this.startActivity(mainIntent);
            WelcomeActivity.this.finish();

        }, SPLASH_DISPLAY_LENGTH);
    }

    public void initTextView(){

        loadingText = findViewById(R.id.loading_text_view);
        loadingText.setTypeface(Typeface.createFromAsset(getAssets(),getString(R.string.elsie_regular)));
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }
}