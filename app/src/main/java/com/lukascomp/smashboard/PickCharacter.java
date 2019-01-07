package com.lukascomp.smashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.lukascomp.smashboard.MainActivity.charsOne;
import static com.lukascomp.smashboard.MainActivity.charsTwo;
import static com.lukascomp.smashboard.MainActivity.firstUser;
import static com.lukascomp.smashboard.MainActivity.playerOne;
import static com.lukascomp.smashboard.MainActivity.playerTwo;

public class PickCharacter extends AppCompatActivity {

    ListView list_View;
    ArrayAdapter<String> adapter;
    ArrayList<String> charList= new ArrayList<>();
    ArrayList<String> list_items = new ArrayList<>();
    int count = 0;
    Button nextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_character);
        nextButton = (Button)findViewById(R.id.reload);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView3);

        if(firstUser){
            textView.setText(playerOne+" picks her/his Characters");
        } else {
            textView.setText(playerTwo+" picks her/his Characters");
        }



        list_View = (ListView)findViewById(R.id.charlist);


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



        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, charList);
        list_View.setAdapter(adapter);
        list_View.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);


        list_View.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                if(checked){
                    count++;
                    mode.setTitle(count + " Chars selected. Confirm?");
                    list_items.add(charList.get(position));
                } else {
                    count--;
                    mode.setTitle(count + " Chars selected. Confirm?");
                    list_items.remove(charList.get(position));
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.my_context_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.delete_id:
                        if(list_items.size() == 5){
                            for(String str: list_items){
                                if(firstUser)
                                    charsOne.add(str);
                                else
                                    charsTwo.add(str);
                            }
                            if(firstUser){
                                Toast.makeText(getBaseContext(),"CHARACTERS FORM " + playerOne + "\n" + list_items.get(0) + "\n" + list_items.get(1) + "\n" + list_items.get(2) + "\n" + list_items.get(3) + "\n" +list_items.get(4), Toast.LENGTH_LONG).show();
                                list_View.setVisibility(View.INVISIBLE);
                                nextButton.setVisibility(View.VISIBLE);}
                            else{
                                Toast.makeText(getBaseContext(),"CHARACTERS FORM " + playerTwo + "\n" + list_items.get(0) + "\n" + list_items.get(1) + "\n" + list_items.get(2) + "\n" + list_items.get(3) + "\n" +list_items.get(4), Toast.LENGTH_LONG).show();
                                nextButton.setVisibility(View.VISIBLE);
                            adapter.clear();}

                        } else {
                            Toast.makeText(getBaseContext(),"Select 5 character! You selected " + count, Toast.LENGTH_SHORT).show();
                            list_items.clear();
                            count = 0;
                        }
                        mode.finish();
                        return true;
                    //    break;
                    default:
                        return false;
                }
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });


        /*

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
        });*/

    }
    /** Called when the user taps the Send button */
    public void buttonNext(View view) {
       /* Intent intent;
        if(firstUser) {
            firstUser = false;
            intent = new Intent(this, PickCharacter.class);
        }else
            intent = new Intent(this, ConstallationCalculator.class);
            String message = "Player List";
            intent.putExtra("com.example.smashboard.MESSAGE1", message);
            startActivity(intent); */
        if(charsOne.size() != 0 && (charsTwo.size() != 0 || firstUser)) {
        Intent intent;
        if(firstUser) {
            intent = new Intent(this, PickCharacter.class);
        }else
            intent = new Intent(this, ConstallationCalculator.class);
        String message = "Player List";
        intent.putExtra("com.example.smashboard.MESSAGE1", message);
        firstUser = false;
        startActivity(intent);
        } else
            Toast.makeText(getBaseContext(),"You have to confirm the players before you can go next", Toast.LENGTH_SHORT).show();
    }

}
