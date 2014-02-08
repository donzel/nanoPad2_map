/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nanopadconf;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;

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
        }

        public void close() {
        }
    }