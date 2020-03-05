package com.paul.stringtheory_justplay;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.os.Vibrator;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    MediaPlayer player;
    private static MainActivity instance;
    private Shapes chordShape;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set immersive mode
        int UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                         View.SYSTEM_UI_FLAG_FULLSCREEN |
                         View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                         View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                         View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;

        getWindow().getDecorView().setSystemUiVisibility(UI_OPTIONS);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                             WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //list all buttons on fretboard
        //set up listener to see which buttons are being pressed
        chordShape = new Shapes(this);
        chordShape.setAllButtons();
        chordShape.pressedButtons();
        //set map
        chordShape.setMap();

        //set up info button
        Button info_button = findViewById(R.id.infoButton);
        info_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InfoActivity.class));
            }
        });
    }

    //allows methods from MainActivity to be called from other classes
    public static MainActivity getInstance() {
        return instance;
    }


    //called from strum
    public void playChord(View v) {

        //check is chord_shape is valid
        Log.d("VALID", String.valueOf(chordShape.isShapeValid()));
        if (chordShape.isShapeValid()){
            if (player !=null) {
                stopPlayer();
            }
            int chord = chordShape.getChord();
            player = MediaPlayer.create(this, chord);
            //stops media player when sound is finished playing
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
            player.start();
        } else {
            //chord wrong, then vibrate
            vibrator();
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

    //vibrator for when chord played is played wrong
    private void vibrator() {
        //test android version
        if (Build.VERSION.SDK_INT >= 26) {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(150,
                                                                    VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(150);
        }
    }


}

