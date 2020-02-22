package com.paul.stringtheory_justplay;

import android.app.Activity;
import android.widget.Button;
import java.util.ArrayList;



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
        //pressedNotes = MainActivity.getInstance().pressedButtons();

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


}
