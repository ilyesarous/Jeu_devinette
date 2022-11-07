package com.example.tp4.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tp4.R;

public class Winner extends AppCompatActivity {

    Button retour;
    TextView winner;
    String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        retour = findViewById(R.id.retourHome);
        winner = findViewById(R.id.winner);
        getName();
        affiche(playerName);
        retour();
    }

    void getName(){
        Intent intent = getIntent();
        playerName = intent.getStringExtra("player");
    }

    void affiche(String playerName){
        winner.setText("Congrats "+playerName);
    }

    void retour(){
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Winner.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }


}