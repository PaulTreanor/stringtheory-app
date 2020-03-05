package com.paul.stringtheory_justplay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Shapes {

    private Activity activity;
    private static Button[] allButtons = new Button[25];
    private ArrayList<Button> pressedNotes = new ArrayList<>(0);
    private int chord;
    private HashMap<Integer, ArrayList<Button>> map;

    //constructor
    Shapes(Activity _activity){
        this.activity = _activity;
    }

    void setMap() {
        ChordShapesHashMap chordShapesHashMap = new ChordShapesHashMap(allButtons);
        this.map = ChordShapesHashMap.getMap();
    }

    public static Button[] getAllButtons() {
        return allButtons;
    }


    boolean isShapeValid(){
        //iterate through map
        for (Map.Entry<Integer, ArrayList<Button>> ee : map.entrySet()) {
            int key = ee.getKey();
            ArrayList<Button> values = ee.getValue();
            if (shapesEquals(values, pressedNotes)) {
                chord = key;
                return true;
            }
        }
        return false;
    }


    //equals method for chord shapes
    private boolean shapesEquals( ArrayList<Button> chordA, ArrayList<Button> chordB){
        return chordA.containsAll(chordB) && chordB.containsAll(chordA);
    }


    int getChord()
    {
        return chord;
    }

    void setAllButtons(){
        for (int i = 1; i < 25; i++) {
            int id = this.activity.getResources().getIdentifier("btn"+ i, "id", this.activity.getPackageName());
            allButtons[i] = this.activity.findViewById(id);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    void pressedButtons(){
        //because allButtons begins at index 1 to make button names more intuitive
        Button[] validButtons = Arrays.copyOfRange(allButtons, 1, 25);

        for (final Button button: validButtons) {
            button.setOnTouchListener(new Button.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                        case MotionEvent.ACTION_MOVE:
                            button.setBackgroundResource(R.drawable.button_green);
                            if (!pressedNotes.contains(button)){
                                pressedNotes.add(button);
                            }
                            break;
                        case MotionEvent.ACTION_UP:
                            button.setBackgroundResource(R.drawable.button_grey);

                            pressedNotes.remove(button);
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + event.getAction());
                    }
                    return true;
                }
            });
        }
    }
}
