/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nanopadconf;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;
import static javax.sound.midi.ShortMessage.NOTE_OFF;
import static javax.sound.midi.ShortMessage.NOTE_ON;

/**
 *
 * @author luc
 */
//tried to write my own class. I thought the send method handles an MidiEvents sent to it
public class MidiInputReceiver implements Receiver {

    public String name;

    public MidiInputReceiver(String name) {
        this.name = name;
    }

    public void send(MidiMessage msg, long timeStamp) {
        System.out.println("midi received");

        if (msg instanceof ShortMessage) {
            ShortMessage sm = (ShortMessage) msg;
            System.out.print("Channel: " + sm.getChannel() + " ");
          if (sm.getCommand() == NOTE_ON) {
                        int key = sm.getData1();                        
                        int velocity = sm.getData2();
                        System.out.println("Note on, " + " key=" + key + " velocity: " + velocity);
                    } else if (sm.getCommand() == NOTE_OFF) {
                        int key = sm.getData1();                       
                        int velocity = sm.getData2();
                        System.out.println("Note off, "+ " key=" + key + " velocity: " + velocity);
                    } else {
                        System.out.println("Command:" + sm.getCommand());
                    }
                } else {
                    System.out.println("Other message: " + msg.getClass());
                }
        

    }

    public void close() {
    }
}
