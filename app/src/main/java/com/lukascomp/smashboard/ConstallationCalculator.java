package com.lukascomp.smashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

import static com.lukascomp.smashboard.MainActivity.charsOne;
import static com.lukascomp.smashboard.MainActivity.charsTwo;
import static com.lukascomp.smashboard.MainActivity.playerOne;
import static com.lukascomp.smashboard.MainActivity.playerTwo;

public class ConstallationCalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constallation_calculator);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();

        // Capture the layout's TextView and set the string as its text
        TextView playerone = findViewById(R.id.playerone);
        TextView playertwo = findViewById(R.id.playertwo);


        TextView charone = findViewById(R.id.charone);
        TextView chartwo = findViewById(R.id.chartwo);

        playerone.setText(playerOne);
        playertwo.setText(playerTwo);

        int rdm1 = new Random().nextInt(charsOne.size());
        int rdm2 = new Random().nextInt(charsOne.size() - 1);
        if(rdm1 == rdm2) {
            rdm2 = charsOne.size();
        }
        charone.setText(charsOne.get(rdm1) + ", " + charsOne.get(rdm2));

        rdm1 = new Random().nextInt(charsTwo.size());
        rdm2 = new Random().nextInt(charsTwo.size() - 1);
        if(rdm1 == rdm2) {
            rdm2 = charsTwo.size();
        }

        chartwo.setText(charsTwo.get(rdm1) + ", " + charsTwo.get(rdm2));


    }
}
