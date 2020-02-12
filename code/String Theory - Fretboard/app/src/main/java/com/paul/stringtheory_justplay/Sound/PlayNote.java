package com.paul.stringtheory_justplay.Sound;

import jm.JMC;
import jm.music.data.Note;
import jm.util.Play;

public class PlayNote {


    public static void main(String[] args){
        Note note = new Note();
        note.setPitch(JMC.A4);

        Play.midi(note);

    }
}
