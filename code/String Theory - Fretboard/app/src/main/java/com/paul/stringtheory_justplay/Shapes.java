package com.paul.stringtheory_justplay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Shapes {
    //list of all buttons
    public Activity activity;
    private Button[] allButtons = new Button[25];
    private ArrayList<Button> pressedNotes = new ArrayList<Button>(0);
    private int chord;

    public Button[] getAllButtons(){
        return allButtons;
    }

    //constructor
    public Shapes(Activity _activity){
        this.activity = _activity;
    }

    public void testButtons(){
        Log.d("BUTTON", String.valueOf(pressedNotes.size()));
    }

    public boolean isShapeValid(){
        //create hashmap instance
        ChordShapesHashMap hashM = new ChordShapesHashMap();
        //get map
        HashMap<Integer, ArrayList<Button>> map = ChordShapesHashMap.getMap();
        //search item in map
        //iterate through map
        /*Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            //PROPER EQUALS METHOD NEEDED!
            if (pair.getValue() ==pressedNotes){
                //set chord
                chord = (int) pair.getKey();
                return true;
            }

            it.remove(); // avoids a ConcurrentModificationException
        }*/
        //hardcoding c chord
        ArrayList<Button> cChord = new ArrayList<Button>(
                Arrays.<Button>asList(allButtons[17], allButtons[10], allButtons[7]));

        if (cChord.containsAll(pressedNotes) && pressedNotes.containsAll(cChord)){
            return true;

        }
        else{ return false;}
    }


    public int getChord(){
        return chord; //returns soundfile link
    }

    public void setAllButtons(){
        for (int i = 1; i < 25; i++) {
            int id = this.activity.getResources().getIdentifier("btn"+ i, "id", this.activity.getPackageName());
            allButtons[i] = (Button) this.activity.findViewById(id);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    public void pressedButtons(){

        //for button that are touched in allButtons
        Button[] validButtons = Arrays.copyOfRange(allButtons, 1, 25);
        //final Button button = validButtons[0];

        for (final Button button: validButtons) {
            button.setOnTouchListener(new Button.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            button.setText("click");
                            if (!pressedNotes.contains(button)){
                                pressedNotes.add(button);
                            }
                            break;

                        case MotionEvent.ACTION_MOVE:
                            button.setText("touch");
                            if (!pressedNotes.contains(button)){
                                pressedNotes.add(button);
                            }
                            break;
                        case MotionEvent.ACTION_UP:
                            button.setText("F");
                            if (pressedNotes.contains(button)){
                                pressedNotes.remove(button);
                            }
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
