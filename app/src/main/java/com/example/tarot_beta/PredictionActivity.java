package com.example.tarot_beta;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PredictionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);


        ViewPager2 viewPager = findViewById(R.id.cardImageView);
        @SuppressLint("Recycle") TypedArray imageArray = getResources().obtainTypedArray(R.array.tarot_card_images);
        String[] cardNames = getResources().getStringArray(R.array.tarot_card_names);
        String[] cardDescriptions = getResources().getStringArray(R.array.tarot_card_descriptions);

        List<Slide> slides = new ArrayList<>();

        List<Integer> allIndices = new ArrayList<>();
        for (int i = 0; i < imageArray.length(); i++) {
            allIndices.add(i);
            Collections.shuffle(allIndices);
        }

        for (int i = 0; i < 3; i++) {
            int randomIndex = allIndices.get(i);
            int imageResId = imageArray.getResourceId(randomIndex, -1);
            if (imageResId != -1) {
                slides.add(new Slide(imageResId, cardNames[randomIndex], cardDescriptions[randomIndex]));
            }
        }
        viewPager.setAdapter(new SlidePagerAdapter(this, slides));
    }
    public void backToMain(View v) {
        Intent intent = new Intent(PredictionActivity.this, MainActivity.class);
        startActivity(intent);
    };

}