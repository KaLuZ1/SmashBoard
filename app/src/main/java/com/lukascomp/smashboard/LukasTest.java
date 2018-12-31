package com.lukascomp.smashboard;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class LukasTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lukas_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final ListView listView = (ListView)findViewById(R.id.listViewPlayers);
        Button addPlayer = (Button) findViewById(R.id.addPlayer);
        final EditText nameField = (EditText) findViewById(R.id.nameField);

        final ArrayList<String> nameList = new ArrayList<>();


        addPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameList.add(nameField.getText().toString());
                Toast.makeText(LukasTest.this, "Players:"+ nameList.toString(), Toast.LENGTH_SHORT).show();


                String[] nameListArray = new String[nameList.size()];
                for(int i = 0; i<nameList.size(); i++){
                    nameListArray[i] = nameList.get(i);
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(LukasTest.this, android.R.layout.simple_list_item_multiple_choice, nameListArray);
                listView.setAdapter(adapter);
            }
        });








        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(LukasTest.this, listView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
