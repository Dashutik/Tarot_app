package com.example.tarot_beta;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Toast;

public class PredictionActivity extends AppCompatActivity {
    private ImageView cardImageView;

    private final int[] tarotCards = {
            R.drawable.coins01, R.drawable.coins02, R.drawable.coins03,
    };

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
        cardImageView = findViewById(R.id.cardImageView);
        String[] tarotCardNames = getResources().getStringArray(R.array.tarot_cards);
        int randomIndex = (int) (Math.random() * tarotCards.length);
        cardImageView.setImageResource(tarotCards[randomIndex]);

    }
    public void backToMain(View v) {
        Intent intent = new Intent(PredictionActivity.this, MainActivity.class);
        startActivity(intent);
    };

}