/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nanopadconf;

/**
 *
 * @author luc
 */
public class NanoPadConf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nameOfDevice = "nanoPAD2";
        MidiHandler.listDevices();
        MidiHandler mh = new MidiHandler(nameOfDevice);
        // TODO code application logic here
    }
    
}
