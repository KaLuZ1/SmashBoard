package com.lukascomp.smashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.lukascomp.smashboard.MainActivity.GAMECONSTELLATION;

public class DisplayMessageActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView2);
        textView.setText(message);

        listView=(ListView)findViewById(R.id.playerlist);

        final ArrayList<String> playerList= new ArrayList<>();

        playerList.add("Elena");
        playerList.add("Fernando");
        playerList.add("Alex");
        playerList.add("Lukas");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, playerList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(GAMECONSTELLATION[0][0] == null){
                    GAMECONSTELLATION[0][0] = playerList.get(position);
                    Toast.makeText(DisplayMessageActivity.this, "Player one is: "+playerList.get(position), Toast.LENGTH_LONG).show();

                } else {
                    GAMECONSTELLATION[1][0] = playerList.get(position);
                    Toast.makeText(DisplayMessageActivity.this, "Player two is: "+playerList.get(position)+ "! click next!", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
    /** Called when the user taps the Send button */
    public void goToChars(View view) {
        Intent intent = new Intent(this, PickCharacter.class);
        String message = "Player List";
        intent.putExtra("com.example.smashboard.MESSAGE1", message);
        startActivity(intent);
    }
}
