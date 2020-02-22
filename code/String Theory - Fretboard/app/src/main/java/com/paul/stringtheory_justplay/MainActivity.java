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
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player;
    //rprivate Button[] allButtons = new Button[25];

    private static MainActivity instance;


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
    }

    //allows methods from MainAcitvity to be called from other classes
    public static MainActivity getInstance() {
        return instance;
    }

    public void playChord(View v) {

        Shapes chordShape = new Shapes(this);
        chordShape.setAllButtons();
        //get list of all buttons that are pressed down
        //chordShape.setShape();
        //check is chord_shape is valid
        if (chordShape.isShapeValid()){    //simple if statement is filling in for shape checking function
            if (player !=null) {
                stopPlayer();
            }

            //use shape to find chord file to use
            //chord = chordShape.getChord(); - findChord function of Shape class;
            player = MediaPlayer.create(this, R.raw.dm); //what type is dm and how do I set a variable to be equal to it
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

    /*lists of fretboard buttons
    public void setAllButtons(){
        for (int i = 1; i < 25; i++) {
            int id = getResources().getIdentifier("btn"+ i, "id", getPackageName());
            allButtons[i] = (Button) findViewById(id);
        }
    }

    //a simple test case pressedButtons functions
    public ArrayList<Button> pressedButtons(){
        ArrayList<Button> pressedButtons = new ArrayList<>(0);

        for (Button button: allButtons){
            pressedButtons.add(button);
        }
        return pressedButtons;
    }



    @SuppressLint("ClickableViewAccessibility")
    public ArrayList<Button> pressedButtons(){
        final ArrayList<Button> pressedButtons = new ArrayList<>(0);

        //for button that are touched in allButtons
        for (Button button: allButtons){
            final boolean[] isScreenTouched = {false};
            button.setOnTouchListener(new Button.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                        isScreenTouched[0] = true;
                    }
                    return isScreenTouched[0];
                }

            });
            if (isScreenTouched[0] = true) {
                pressedButtons.add(button);
            }
        }

        return pressedButtons;
    }*/




}

