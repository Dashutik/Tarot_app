package com.example.tarot_beta;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PredictionsActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.predictions);
    }
    public void startPrediction(View v) {
        Intent intent = new Intent(PredictionsActivity.this, PredictionActivity.class);
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
