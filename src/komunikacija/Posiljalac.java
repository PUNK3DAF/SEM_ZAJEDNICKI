package komunikacija;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vldmrk
 */
public class Posiljalac {

    private Socket s;
    private ObjectOutputStream oos;

    public Posiljalac(Socket s) {
        this.s = s;
        try {
            // Kreirati ObjectOutputStream jednom i flush-ovati header
            this.oos = new ObjectOutputStream(s.getOutputStream());
            this.oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(Posiljalac.class.getName()).log(Level.SEVERE, null, ex);
            this.oos = null;
        }
    }

    public void posalji(Object obj) {
        if (oos == null) {
            return;
        }
        try {
            oos.writeObject(obj);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(Posiljalac.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() {
        if (oos != null) {
            try {
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Posiljalac.class.getName()).log(Level.FINE, null, ex);
            } finally {
                oos = null;
            }
        }
    }
}
