package com.midicontroller;
import jm.JMC;
import jm.constants.ProgramChanges;
import jm.util.*;
import jm.music.data.*;


public final class Chords implements JMC{
    private static Score s = new Score("CPrase (chord) class");
    private static Part p = new Part("distorted guitar", ProgramChanges.DIST_GUITAR, 0);
    private int[] pitchArray = {};

    public Chords(int[] pitchArray){
        this.pitchArray = pitchArray;
    }

    public void play(){
        System.out.println("Creating chord...");
        createChord(pitchArray);
        s.addPart(p);
        Write.midi(s, "Chords.mid");
        Play.midi(s);
        //empty part
    }

    private static void createChord(int[] pitchArray) {
        //add chord to the part
        CPhrase chord = new CPhrase();
        chord.addChord(pitchArray, 1.0); //second parameter is duration, not in seconds tho
        p.addCPhrase(chord);
    }
}

