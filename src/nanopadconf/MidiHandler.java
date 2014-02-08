/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nanopadconf;

/**
 *
 * @author luc donze
 */
import java.util.List;
import javax.sound.midi.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static sun.audio.AudioDevice.device;

public class MidiHandler {

    /**
     * device object out
     */
    private MidiDevice deviceOut;
    private List<Transmitter> transmitters;

    /**
     * device object in
     */
    private MidiDevice deviceceIn;

    /**
     *
     * @param deviceName , the name of device search
     */
    public MidiHandler(String deviceName) {
        try {
            MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
            // Check all device midi conected
            for (MidiDevice.Info deviceSelected : infos) {
                try {
                    MidiDevice midi = MidiSystem.getMidiDevice(deviceSelected);
                    //System.out.println("list device name = "+midi.getDeviceInfo().getName());
                    if (midi.getDeviceInfo().getName().contains(deviceName)) {
                        this.deviceOut = midi;
                        //A MidiDevice instance that represents a MIDI IN port has Transmitters, but no Receivers. For MIDI OUT, it's vice versa
                        //not supporting Transmitters / Receivers returns 0 on the respective method.
                        if (midi.getMaxReceivers() != 0) {
                            this.deviceOut = midi;
                            System.out.println("reciever  ! : " + midi.getDeviceInfo());
                        } else if (midi.getMaxTransmitters() != 0) {
                            this.deviceceIn = midi;
                            System.out.println("transmiter  ! " + midi.getDeviceInfo());
                        }
                    }

                } catch (MidiUnavailableException ex) {
                    Logger.getLogger(MidiHandler.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            // Now open device
            // transforms device In for get event of the midi device
            transmitters = this.deviceceIn.getTransmitters();
            for (Transmitter tter : transmitters) {
                tter.setReceiver(new MidiInputReceiver(deviceOut.getDeviceInfo().toString()));
            }
            Transmitter trans = deviceceIn.getTransmitter();
            trans.setReceiver(new MidiInputReceiver(deviceceIn.getDeviceInfo().toString()));

            //open device
            deviceceIn.open();
            //if code gets this far without throwing an exception
            //print a success message
            System.out.println(deviceceIn.getDeviceInfo() + " Was Opened");
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(MidiHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * List devices midi connected
     */
    public static void listDevices() {
        MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
        for (MidiDevice.Info deviceSelected : infos) {
            try {
                MidiDevice midi = MidiSystem.getMidiDevice(deviceSelected);
                System.out.println("device midi = " + midi.getDeviceInfo());
            } catch (MidiUnavailableException ex) {
                Logger.getLogger(MidiHandler.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    /**
     * @return the deviceOut
     */
    public MidiDevice getDeviceOut() {
        return deviceOut;
    }

    /**
     * @param deviceOut the deviceOut to set
     */
    public void setDeviceOut(MidiDevice deviceOut) {
        this.deviceOut = deviceOut;
    }

    /**
     * @return the deviceceIn
     */
    public MidiDevice getDeviceceIn() {
        return deviceceIn;
    }

    /**
     * @param deviceceIn the deviceceIn to set
     */
    public void setDeviceceIn(MidiDevice deviceceIn) {
        this.deviceceIn = deviceceIn;
    }

}
