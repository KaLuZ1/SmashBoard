package com.lukascomp.smashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.smashboard.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String message = "Player List";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}