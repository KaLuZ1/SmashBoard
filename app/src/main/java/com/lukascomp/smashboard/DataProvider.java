package com.lukascomp.smashboard;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.io.File;

public class DataProvider extends AppCompatActivity {

    private File playerFile;
    private File charFile;

    public DataProvider(){

    }

    private void writeFile(){
        String filename = "myfile";
        String fileContents = "Hello world!";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
