package com.paul.stringtheory_justplay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import java.util.Arrays;


public class Shapes {
    //list of all buttons
    public Activity activity;
    private Button[] allButtons = new Button[25];
    private ArrayList<Button> pressedNotes = new ArrayList<Button>(0);


    //constructor
    public Shapes(Activity _activity){
        this.activity = _activity;
    }

    public void setShape(){

        //sets listOfNotes
        pressedNotes = pressedButtons();

    }

    public void testButtons(){
        Log.d("BUTTON", String.valueOf(pressedNotes.size()));
    }

    public boolean isShapeValid(){
        //is listOfNotes a valid shape?
        return true;
    }

    public void getChord(){
        //returns a chord associated with that shape
    }

    public void setAllButtons(){
        for (int i = 1; i < 25; i++) {
            int id = this.activity.getResources().getIdentifier("btn"+ i, "id", this.activity.getPackageName());
            allButtons[i] = (Button) this.activity.findViewById(id);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    public ArrayList<Button> pressedButtons(){
        final ArrayList<Button> pressedButtons = new ArrayList<>(0);

        //for button that are touched in allButtons
        Button[] validButtons = Arrays.copyOfRange(allButtons, 1, 25);
        final Button button = validButtons[0];
        final boolean[] isScreenTouched = {false};

        button.setOnTouchListener(new Button.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float x = event.getX();
                float y = event.getY();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        button.setText("click");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        button.setText("touch");
                        break;
                    case MotionEvent.ACTION_UP:
                        button.setText("uppp");
                        break;
                }

                return true;
            }


            /*@Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_MOVE ) {
                    isScreenTouched[0] = true;
                }
                return isScreenTouched[0];
            }*/

        });
        if (isScreenTouched[0] = true) {
            button.setText("hello");
            pressedButtons.add(button);
        }


        return pressedButtons;
    }


}
