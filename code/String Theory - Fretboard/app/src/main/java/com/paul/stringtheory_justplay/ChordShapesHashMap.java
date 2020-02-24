package com.paul.stringtheory_justplay;

import android.widget.Button;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ChordShapesHashMap {
    static HashMap<Integer, ArrayList<Button>> map = new HashMap<>();
    private Button[] allButtons;

    public ChordShapesHashMap(Button[] allButtons) {
        this.allButtons = allButtons;

        //create a C chord shape
        ArrayList<Button> cChord = new ArrayList<Button>(
                Arrays.<Button>asList(allButtons[17], allButtons[10], allButtons[7]));
        //map c soundfile to chord shape
        map.put(R.raw.c, cChord);
        //Am
        ArrayList<Button> amChord = new ArrayList<Button>(
                Arrays.<Button>asList(allButtons[17], allButtons[10], allButtons[14]));
        map.put(R.raw.am, amChord);
        //d
        ArrayList<Button> dChord = new ArrayList<Button>(
                Arrays.<Button>asList(allButtons[14], allButtons[22], allButtons[19]));
        map.put(R.raw.d, dChord);
        //em
        ArrayList<Button> emChord = new ArrayList<Button>(
                Arrays.<Button>asList(allButtons[6], allButtons[10]));
        map.put(R.raw.em, emChord);
        //g
        ArrayList<Button> gChord = new ArrayList<Button>(
                Arrays.<Button>asList(allButtons[3], allButtons[6], allButtons[23]));
        map.put(R.raw.g, gChord);
        //f
        ArrayList<Button> fChord = new ArrayList<Button>(
                Arrays.<Button>asList(allButtons[17], allButtons[14], allButtons[11]));
        map.put(R.raw.f, fChord);
        //a7
        ArrayList<Button> a7Chord = new ArrayList<Button>(
                Arrays.<Button>asList(allButtons[17], allButtons[10]));
        map.put(R.raw.a7, a7Chord);
        //a
        ArrayList<Button> aChord = new ArrayList<Button>(
                Arrays.<Button>asList(allButtons[18], allButtons[10], allButtons[14]));
        map.put(R.raw.a, aChord);
        //b7
        ArrayList<Button> b7Chord = new ArrayList<Button>(
                Arrays.<Button>asList(allButtons[6], allButtons[9], allButtons[14], allButtons[22]));
        map.put(R.raw.b7, b7Chord);
        //c7
        ArrayList<Button> c7Chord = new ArrayList<Button>(
                Arrays.<Button>asList(allButtons[7], allButtons[10], allButtons[15], allButtons[17]));
        map.put(R.raw.c7, c7Chord);
        //dm
        ArrayList<Button> dmChord = new ArrayList<Button>(
                Arrays.<Button>asList(allButtons[21], allButtons[19], allButtons[14]));
        map.put(R.raw.dm, dmChord);
        //e
        ArrayList<Button> eChord = new ArrayList<Button>(
                Arrays.<Button>asList(allButtons[13], allButtons[6], allButtons[10]));
        map.put(R.raw.e, eChord);
        //e7
        ArrayList<Button> e7Chord = new ArrayList<Button>(
                Arrays.<Button>asList(allButtons[13], allButtons[6]));
        map.put(R.raw.e7, e7Chord);;
        //g7
        ArrayList<Button> g7Chord = new ArrayList<Button>(
                Arrays.<Button>asList(allButtons[3], allButtons[6], allButtons[21]));
        map.put(R.raw.g7, g7Chord);
    }

    public static HashMap<Integer, ArrayList<Button>> getMap(){
        return map;
    }

}
