/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vldmrk
 */
public class Primalac {

    private Socket s;
    private ObjectInputStream ois;

    public Primalac(Socket s) {
        this.s = s;
        try {
            // Kreiramo ObjectInputStream jednom; ponovna kreacija može izazvati header probleme
            this.ois = new ObjectInputStream(s.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Primalac.class.getName()).log(Level.SEVERE, null, ex);
            this.ois = null;
        }
    }

    public Object primi() {
        if (ois == null) {
            return null;
        }
        try {
            return ois.readObject();
        } catch (SocketException se) {
            Logger.getLogger(Primalac.class.getName()).log(Level.INFO, "Socket closed by peer: {0}", se.getMessage());
            return null;
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Primalac.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void close() {
        if (ois != null) {
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(Primalac.class.getName()).log(Level.FINE, null, ex);
            } finally {
                ois = null;
            }
        }
    }
}
