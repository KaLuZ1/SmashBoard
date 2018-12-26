package com.lukascomp.smashboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.smashboard.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goTOPlayerList(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String message = "hello world";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
