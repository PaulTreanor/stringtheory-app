package com.midicontroller;
import java.util.Scanner;
import jm.JMC;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String chordName = input.next();
        while (!chordName.equals("done")) {
            //select chord
            int[] pitchArray = chordChooser(chordName);

            //play chord
            Chords newChord = new Chords(pitchArray);
            newChord.play();

            //get next input
            chordName = input.next();
        }
    }

    public static int[] chordChooser(String chordName){
        if (chordName.equals("d")){
            return dChord();
        }
        else{
            return gChord();
        }
    }
    public static int[] dChord(){
        int[] pitchArray = {JMC.A5, JMC.D5, JMC.FS5};
        return pitchArray;
    }
    public static int[] gChord(){
        int[] pitchArray = {JMC.G5, JMC.B5, JMC.D5};
        return pitchArray;
    }
}
