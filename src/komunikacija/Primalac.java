/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vldmrk
 */
public class Primalac {

    private Socket s;

    public Primalac(Socket s) {
        this.s = s;
    }

    public Object primi() {
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            return ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Primalac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
