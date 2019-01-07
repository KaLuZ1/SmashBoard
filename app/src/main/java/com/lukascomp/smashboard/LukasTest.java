package com.lukascomp.smashboard;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class LukasTest extends AppCompatActivity {
    ListView list_View;
    ArrayAdapter<String> adapter;
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> list_items = new ArrayList<String>();
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lukas_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list_View = (ListView) findViewById(R.id.listViewPlayers);
        list.add("one");
        list.add("one2");
        list.add("one3");
        list.add("one4");
        list.add("last");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, list);
        list_View.setAdapter(adapter);
        list_View.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        list_View.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                count++;
                mode.setTitle(count + " items selected");
                list_items.add(list.get(position));


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
                        for(String msg : list_items) {
                            adapter.remove(msg);
                        }
                        Toast.makeText(getBaseContext(), count + " items removed", Toast.LENGTH_SHORT).show();
                        count = 0;
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
        });*/
    }

}
