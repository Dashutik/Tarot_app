package com.example.tarot_beta;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class PredictionsActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.predictions);
    }
    public void startPrediction(View v) {
        Intent intent = new Intent(PredictionsActivity.this, ThreeCardsPredictionActivity.class);
        startActivity(intent);
    };

    public void startYesNoPrediction(View v) {
        Intent intent = new Intent(PredictionsActivity.this, YesNoPredictionActivity.class);
        startActivity(intent);
    };
    public void backToMain(View v) {
        Intent intent = new Intent(PredictionsActivity.this, MainActivity.class);
        startActivity(intent);
    };
}
