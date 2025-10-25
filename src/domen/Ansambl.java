/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author vldmrk
 */
public class Ansambl implements ApstraktniDomenskiObjekat {

    private int ansamblID;
    private String imeAnsambla;
    private String opisAnsambla;
    private Administrator admin;

    public Ansambl() {
    }

    public Ansambl(int ansamblID, String imeAnsambla, String opisAnsambla, Administrator admin) {
        this.ansamblID = ansamblID;
        this.imeAnsambla = imeAnsambla;
        this.opisAnsambla = opisAnsambla;
        this.admin = admin;
    }

    public int getAnsamblID() {
        return ansamblID;
    }

    public void setAnsamblID(int ansamblID) {
        this.ansamblID = ansamblID;
    }

    public String getImeAnsambla() {
        return imeAnsambla;
    }

    public void setImeAnsambla(String imeAnsambla) {
        this.imeAnsambla = imeAnsambla;
    }

    public String getOpisAnsambla() {
        return opisAnsambla;
    }

    public void setOpisAnsambla(String opisAnsambla) {
        this.opisAnsambla = opisAnsambla;
    }

    public Administrator getAdmin() {
        return admin;
    }

    public void setAdmin(Administrator admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return imeAnsambla;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ansambl other = (Ansambl) obj;
        return this.ansamblID == other.ansamblID;
    }

    @Override
    public String vratiNazivTabele() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiPrimarniKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVeednostiZaIzmenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
