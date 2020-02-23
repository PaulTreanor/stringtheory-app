package com.paul.stringtheory_justplay;

import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ChordShapesHashMap {
    static HashMap<Integer, ArrayList<Button>> map = new HashMap<>();
    private Integer C = R.raw.c;


    public void ChordShapesHashMap(Shapes chordShapes){
        //get list of all buttons
        Button[] allButtons = chordShapes.getAllButtons();

        //create a C chord shape
        ArrayList<Button> cChord = new ArrayList<Button>(
                Arrays.<Button>asList(allButtons[17], allButtons[10], allButtons[7]));
        //map c soundfile to chord shape
        map.put(C, cChord);
    }

    public static HashMap<Integer, ArrayList<Button>> getMap(){
        return map;
    }

}
