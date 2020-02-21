package com.paul.stringtheory_justplay;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    MediaPlayer player;
    private Button[] allButtons = new Button[25];


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
        Shapes chordShape = new Shapes();
        chordShape.setShape();
        setAllButtons();
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

    public void setAllButtons(){
        for (int i = 1; i < 25; i++) {
            int id = getResources().getIdentifier("btn"+ i, "id", getPackageName());
            allButtons[i] = (Button) findViewById(id);
            Log.d("BUTTON", String.valueOf(i));
        }
    }

    public Button[] pressedButtons(){
        Button[]

        return
    }




}

