package com.ray.java.basic.simple_sequencer;

import javax.sound.midi.*;

/**
 * Created by dangdang on 5/13/16.
 */
public class MiniMusicApp {


    public static void main(String[] args) {

        MiniMusicApp miniMusicApp = new MiniMusicApp();
        miniMusicApp.play();

    }

    private void play() {
        try {

            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ,4);

            Track track = seq.createTrack();

            ShortMessage a = new ShortMessage();
            a.setMessage(144,2,44,100);
            MidiEvent noteOn = new MidiEvent(a,1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128,1,44,100);
            MidiEvent noteOff = new MidiEvent(b,3);
            track.add(noteOff);

            player.setSequence(seq);

            player.start();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
