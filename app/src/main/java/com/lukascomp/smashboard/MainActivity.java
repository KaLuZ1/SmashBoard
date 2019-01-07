package com.lukascomp.smashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    public static String playerOne;
    public static String playerTwo;
    public static ArrayList<String> charsOne = new ArrayList<>();
    public static ArrayList<String> charsTwo = new ArrayList<>();
    public static boolean firstUser = true;
    public static final String EXTRA_MESSAGE = "com.example.smashboard.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        firstUser = true;
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String message = "Player List";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void openTest(View view) {
        Intent intent = new Intent(this, LukasTest.class);
        String message = "Player List";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}