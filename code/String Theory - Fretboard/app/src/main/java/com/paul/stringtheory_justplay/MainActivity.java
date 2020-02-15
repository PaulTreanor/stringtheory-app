package com.paul.stringtheory_justplay;

import androidx.appcompat.app.AppCompatActivity;

import android.media.JetPlayer;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;


public class MainActivity extends AppCompatActivity {

    MediaPlayer player;


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

    public void playf(View v){
        //int[] pitchArray = {JMC.A5, JMC.D5, JMC.F5};
        //Chords newChord = new Chords(pitchArray);
        if (player ==null){
            player = MediaPlayer.create(this, R.raw.chords);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();

    }
    public void pause(View v){
        if (player  !=null){
            player.pause();
        }

    }
    public void stop(View v){

        stopPlayer();
    }

    private void stopPlayer(){
        if (player !=null){
            player.release();
            player = null;
        }
    }
    @Override
    protected void onStop(){
        super.onStop();
        stopPlayer();

    }
}

