package com.lukascomp.smashboard;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
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

import static com.lukascomp.smashboard.MainActivity.playerOne;
import static com.lukascomp.smashboard.MainActivity.playerTwo;

public class DisplayMessageActivity extends AppCompatActivity {

    ListView list_View;
    ArrayAdapter<String> adapter;
    ArrayList<String> playerList= new ArrayList<>();
    ArrayList<String> list_items = new ArrayList<>();
    int count = 0;
    Button nextButton;

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

        list_View = (ListView)findViewById(R.id.playerlist);
        nextButton = (Button)findViewById(R.id.gotochars);



        playerList.add("Elena");
        playerList.add("Fernando");
        playerList.add("Alex");
        playerList.add("Lukas");
        playerList.add("default1");
        playerList.add("default2");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, playerList);
        list_View.setAdapter(adapter);
        list_View.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        list_View.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                if(checked){
                    count++;
                    mode.setTitle(count + " player selected. Confirm?");
                    list_items.add(playerList.get(position));
                } else {
                    count--;
                    mode.setTitle(count + " player selected. Confirm?");
                    list_items.remove(playerList.get(position));
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
                        if(list_items.size() == 2){
                            playerOne = list_items.get(0);
                            playerTwo = list_items.get(1);
                            Toast.makeText(getBaseContext(),"Nice! Player One is " + list_items.get(0) + " and player two " + list_items.get(1), Toast.LENGTH_LONG).show();
                            nextButton.setVisibility(View.VISIBLE);
                            adapter.clear();

                        } else {
                            Toast.makeText(getBaseContext(),"Select only 2 players! You selected " + count, Toast.LENGTH_SHORT).show();
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


    }

    public void goToChars(View view) {
        if(playerOne != null && playerOne != "") {
                Intent intent;
                intent = new Intent(this, PickCharacter.class);
                String message = "Player List";
                intent.putExtra("com.example.smashboard.MESSAGE1", message);
                startActivity(intent);
        } else
                Toast.makeText(getBaseContext(),"You have to confirm the players before you can go next", Toast.LENGTH_SHORT).show();
    }
}
