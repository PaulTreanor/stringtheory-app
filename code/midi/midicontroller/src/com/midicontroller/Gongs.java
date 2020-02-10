package com.midicontroller;


import jm.music.data.*;
import jm.music.tools.*;
import jm.JMC;
import jm.audio.*;
import jm.util.*;

// Gong-like timbres inspired by
// Claude Risset's early computer music pieces

public class Gongs implements JMC {
    public static void main(String[] args) {
        //create pitchArray
        int[] pitches = {CS4, B4, D5, E6, A5, B5};
        new Gongs(pitches);
    }
    public Gongs(int[] pitches) {
        Score score = new Score();

        //stop while i less than length pitches
        for (int i=0; i< pitches.length -1; i++){
            Part p = new Part(i);
            Phrase phr = new Phrase (new Note(pitches[i], 1.0));
            p.addPhrase(phr); //add cphrase?
            score.addPart(p);
        }

        //instrument declaration
        int sampleRate = 22000;
        Instrument[] sines = new Instrument[4];
        for (int i=0; i<pitches.length - 1; i++){
            Instrument sine = new AddSynthInst(sampleRate);
            sines[i] = sine;

        }
        Play.audio(score, sines);
    }


}
