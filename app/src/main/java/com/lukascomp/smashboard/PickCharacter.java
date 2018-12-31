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

public class PickCharacter extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_character);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView3);
        if(GAMECONSTELLATION[0][1] == null){
            textView.setText(GAMECONSTELLATION[0][0].toString()+" picks her/his Characters");
        } else {
            textView.setText(GAMECONSTELLATION[1][0].toString()+" picks her/his Characters");
        }



        listView=(ListView)findViewById(R.id.charlist);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setItemsCanFocus(false);

        final ArrayList<String> charList = new ArrayList<>();

        charList.add("Bayonetta");
        charList.add("Bowser");
        charList.add("Bowser  Jr.");
        charList.add("Capitain Falcon");
        charList.add("Chrom");
        charList.add("Cloud");
        charList.add("Corrin");
        charList.add("Daisy");
        charList.add("Dark Pit");
        charList.add("Dark Samus");
        charList.add("Diddy Kong");
        charList.add("Donkey Kong");
        charList.add("Dr. Mario");
        charList.add("Duck Hunt");
        charList.add("Falco");
        charList.add("Fox");
        charList.add("Ganondorf");
        charList.add("Greninja");
        charList.add("Ice Climber");
        charList.add("Ike");
        charList.add("Incineroar");
        charList.add("Inkling");
        charList.add("Isabelle");
        charList.add("Jigglipuff");
        charList.add("Ken");
        charList.add("King Dedede");
        charList.add("King K. Rool");
        charList.add("Kirby");
        charList.add("Link");
        charList.add("Lucario");
        charList.add("Lucas");
        charList.add("Lucina");
        charList.add("Luigi");
        charList.add("Mario");
        charList.add("Marth");
        charList.add("Mega Man");
        charList.add("Meta-Knight");
        charList.add("Mii Blaster");
        charList.add("Mii Fighter");
        charList.add("Mii Sword");
        charList.add("Mr. Game & Watch");
        charList.add("Ness");
        charList.add("Olimar");
        charList.add("Pac-man");
        charList.add("Paulatena");
        charList.add("Peach");
        charList.add("Pichu");
        charList.add("Pikachu");
        charList.add("Pit");
        charList.add("Pokemon Trainer");
        charList.add("R.O.B.");
        charList.add("Richter");
        charList.add("Ridley");
        charList.add("Robin");
        charList.add("Roy");
        charList.add("Ryu");
        charList.add("Samus");
        charList.add("Shiek");
        charList.add("Shulk");
        charList.add("Simon");
        charList.add("Snake");
        charList.add("Sonic");
        charList.add("Toon Link");
        charList.add("Villager");
        charList.add("Wario");
        charList.add("Wii-Fit Trainer");
        charList.add("Wolf");
        charList.add("Yoshi");
        charList.add("Young Link");
        charList.add("Zelda");
        charList.add("Zero Suit Samus");




        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, charList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int i = (GAMECONSTELLATION[0][5] == null) ? 0 : 1;
                if(GAMECONSTELLATION[i][1] == null){
                    GAMECONSTELLATION[i][1] = charList.get(position);
                    Toast.makeText(PickCharacter.this, GAMECONSTELLATION[i][0]+": Character one is: "+charList.get(position)+ "! pick an other one", Toast.LENGTH_SHORT).show();
                } else if(GAMECONSTELLATION[i][2] == null){
                    GAMECONSTELLATION[i][2] = charList.get(position);
                    Toast.makeText(PickCharacter.this, GAMECONSTELLATION[i][0]+": Character two is: "+charList.get(position)+ "! pick an other one", Toast.LENGTH_SHORT).show();
                } else if(GAMECONSTELLATION[i][3] == null){
                    GAMECONSTELLATION[i][3] = charList.get(position);
                    Toast.makeText(PickCharacter.this, GAMECONSTELLATION[i][0]+": Character three is: "+charList.get(position)+ "! pick an other one", Toast.LENGTH_SHORT).show();
                } else if(GAMECONSTELLATION[i][4] == null){
                    GAMECONSTELLATION[i][4] = charList.get(position);
                    Toast.makeText(PickCharacter.this, GAMECONSTELLATION[i][0]+": Character four is: "+charList.get(position)+ "! pick an other one", Toast.LENGTH_SHORT).show();
                } else {
                    GAMECONSTELLATION[i][5] = charList.get(position);
                    Toast.makeText(PickCharacter.this, GAMECONSTELLATION[i][0]+": Character five is: "+charList.get(position)+ "! click on next!", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
    /** Called when the user taps the Send button */
    public void updateThis(View view) {
        Intent intent;
        if(GAMECONSTELLATION[1][5] == null){
            intent = new Intent(this, PickCharacter.class);
        } else {
            intent = new Intent(this, ConstallationCalculator.class);
        }

        String message = "Player List";
        intent.putExtra("com.example.smashboard.MESSAGE1", message);
        startActivity(intent);


    }
}
