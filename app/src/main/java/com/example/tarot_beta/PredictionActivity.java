package com.example.tarot_beta;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.TextView;

import java.util.Random;

public class PredictionActivity extends AppCompatActivity {
    private ImageView cardImageView;
    private TextView cardNameTextView, cardDescriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prediction);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        showRandomTarotCard();

    }
    private void showRandomTarotCard() {
        TypedArray cardImages = getResources().obtainTypedArray(R.array.tarot_card_images);

        String[] cardNames = getResources().getStringArray(R.array.tarot_card_names);
        String[] cardDescriptions = getResources().getStringArray(R.array.tarot_card_descriptions);

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
        Intent intent = new Intent(PredictionActivity.this, MainActivity.class);
        startActivity(intent);
    };

}