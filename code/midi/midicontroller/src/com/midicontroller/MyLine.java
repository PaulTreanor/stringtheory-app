package com.midicontroller;
import java.util.Scanner;

import jm.JMC;
import jm.music.data.*;
import jm.audio.*;
import jm.music.rt.*;

public final class MyLine extends RTLine implements JMC {

    public static void main(String[] args) {
        Instrument inst = new AddSynthInst(44100);
        new MyLine(new Instrument[] {inst});
    }

    public MyLine(Instrument[] insts) {
        super(insts);
        RTMixer mixer = new RTMixer(new RTLine[] {this});
        mixer.begin();
    }

    public Note getNextNote() {
        int chooseNote = chooseNote();
        Note n = new Note(chooseNote, 0.5);
        return n;
    }

    public int chooseNote(){
        Scanner input = new Scanner(System.in);
        int noteName = input.nextInt();
        return noteName;
    }
}