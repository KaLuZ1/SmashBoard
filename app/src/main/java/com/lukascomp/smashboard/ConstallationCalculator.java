package com.lukascomp.smashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

import static com.lukascomp.smashboard.MainActivity.GAMECONSTELLATION;

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

        playerone.setText(GAMECONSTELLATION[0][0].toString());
        playertwo.setText(GAMECONSTELLATION[1][0].toString());

        int rdm1 = new Random().nextInt(5);
        int rdm2 = new Random().nextInt(4);
        if(rdm1 == rdm2) {
            rdm2 = 5;
        }
        charone.setText(GAMECONSTELLATION[0][rdm1 + 1]+", " + GAMECONSTELLATION[0][rdm2 + 1]);

        rdm1 = new Random().nextInt(5);
        rdm2 = new Random().nextInt(4);
        if(rdm1 == rdm2) {
            rdm2 = 5;
        }

        chartwo.setText(GAMECONSTELLATION[1][rdm1 + 1]+", " + GAMECONSTELLATION[1][rdm2 + 1]);


    }
}
