package com.paul.stringtheory_justplay;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.net.URI;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player;
    //rprivate Button[] allButtons = new Button[25];

    private static MainActivity instance;
    private Shapes chordShape;
    //testing passing chords
    private int chord = R.raw.dm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set immersive mode
        int UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        getWindow().getDecorView().setSystemUiVisibility(UI_OPTIONS);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //list all buttons on fretboards
        //setAllButtons();
        chordShape = new Shapes(this);
        chordShape.setAllButtons();
        chordShape.pressedButtons();
    }

    //allows methods from MainAcitvity to be called from other classes
    public static MainActivity getInstance() {
        return instance;
    }

    public void playChord(View v) {
        Log.d("BUTTON", "hello");
        chordShape.testButtons();

        //check is chord_shape is valid
        if (chordShape.isShapeValid()){
            if (player !=null) {
                stopPlayer();
            }

            //use shape to find chord file to use
            //chord = chordShape.getChord(); - findChord function of Shape class;
            player = MediaPlayer.create(this, chord); //what type is dm and how do I set a variable to be equal to it

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

