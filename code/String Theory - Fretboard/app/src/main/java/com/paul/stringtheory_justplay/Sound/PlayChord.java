package com.paul.stringtheory_justplay.Sound;

import jm.JMC;

public class PlayChord {
    public static void main(String[] args) {
        /*Scanner input = new Scanner(System.in);
        String chordName = input.next();
        while (!chordName.equals("done")) {
            //select chord
            //select chord
            int[] pitchArray = chordChooser(chordName);

            //play chord
            Chords newChord = new Chords(pitchArray);
            newChord.play();

            //get next input
            chordName = input.next();
        }*/
        int[] pitchArray = {JMC.A5, JMC.D5, JMC.F5};
        Chords newChord = new Chords(pitchArray);
        newChord.play();
    }
}