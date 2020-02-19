package com.paul.stringtheory_justplay;

import androidx.appcompat.app.AppCompatActivity;

import android.media.JetPlayer;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    MediaPlayer player;
    private String demoFileName = "hello.txt";
    private Toast textViewPathHint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set immersive mode
        int UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        getWindow().getDecorView().setSystemUiVisibility(UI_OPTIONS);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


    }


    public void playChord(View v) {
        //get shape
        //Shape shape = new Shape();

        //check is chord_shape is valid
        if ((1+2)==3){    //simple if statement is filling in for shape checking function
            if (player !=null) {
                stopPlayer();
            }
            //use shape to find chord file to use
            //chord = findChord(shape) - findChord function of Shape class
            player = MediaPlayer.create(this, R.raw.a_chord);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });

            player.start();
        }
    }

    private void stopPlayer(){
        if (player !=null){
            player.release();
            player = null;
        }
    }

    //stops MediaPlayer upon leaving app
    @Override
    protected void onStop(){
        super.onStop();
        stopPlayer();

    }



}

