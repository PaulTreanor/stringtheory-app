package com.midicontroller;

import jm.JMC;
import jm.constants.ProgramChanges;
import jm.music.data.CPhrase;
import jm.music.data.Part;
import jm.music.data.Score;
import jm.util.Play;
import jm.util.Write;


public final class Chords implements JMC{
    Score s = new Score("CPrase (chord) class");
    Part p = new Part("distorted guitar", ProgramChanges.DIST_GUITAR, 0);
    int[] pitchArray = {};

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

    private void createChord(int[] pitchArray) {
        //add chord to the part
        CPhrase chord = new CPhrase();
        chord.addChord(pitchArray, 1.0); //second parameter is duration, not in seconds tho
        p.addCPhrase(chord);
    }
}

