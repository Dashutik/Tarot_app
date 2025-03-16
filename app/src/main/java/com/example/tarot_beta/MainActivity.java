package com.example.tarot_beta;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView cardImageView;

    private final int[] tarotCards = {
            R.drawable.coins01, R.drawable.coins02, R.drawable.coins03,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardImageView = findViewById(R.id.cardImageView);
        Button pickCardButton = findViewById(R.id.button5);

        String[] tarotCardNames = getResources().getStringArray(R.array.tarot_cards);

        pickCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int randomIndex = (int) (Math.random() * tarotCards.length);
                cardImageView.setImageResource(tarotCards[randomIndex]);

                Toast.makeText(MainActivity.this, tarotCardNames[randomIndex], Toast.LENGTH_SHORT).show();
            }
        });
    }
}