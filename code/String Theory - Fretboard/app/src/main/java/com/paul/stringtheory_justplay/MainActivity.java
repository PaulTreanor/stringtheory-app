package com.paul.stringtheory_justplay;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;


public class MainActivity extends AppCompatActivity {

    MediaPlayer player;
    private static MainActivity instance;
    private Shapes chordShape;



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
        //set up listener to see which buttons are being pressed
        chordShape = new Shapes(this);
        chordShape.setAllButtons();
        chordShape.pressedButtons();
        //set map
        chordShape.setMap();
    }

    //allows methods from MainAcitvity to be called from other classes
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

