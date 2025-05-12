package com.example.tarot_beta;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class YesNoPredictionActivity extends AppCompatActivity {
    private TextView cardNameTextView, cardDescriptionTextView;
    private ImageView cardImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.yes_no_prediction);
        showRandomTarotCard();
    }
    private void showRandomTarotCard() {
        TypedArray cardImages = getResources().obtainTypedArray(R.array.tarot_card_images);

        String[] cardNames = getResources().getStringArray(R.array.tarot_card_names);
        String[] cardDescriptions = getResources().getStringArray(R.array.yes_no_meanings);

        Random random = new Random();
        int randomIndex = random.nextInt(cardImages.length());

        cardImageView = findViewById(R.id.cardImageView);
        cardNameTextView = findViewById(R.id.cardNameTextView);
        cardDescriptionTextView = findViewById(R.id.cardDescriptionTextView);

        int imageResId = cardImages.getResourceId(randomIndex, -1);
        cardImageView.setImageResource(imageResId);
        cardNameTextView.setText(cardNames[randomIndex]);
        cardDescriptionTextView.setText(cardDescriptions[randomIndex]);
    }
    public void backToMain(View v) {
        Intent intent = new Intent(YesNoPredictionActivity.this, MainActivity.class);
        startActivity(intent);
    };
}
