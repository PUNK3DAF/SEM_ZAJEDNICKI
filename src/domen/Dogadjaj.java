/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import domen.Ansambl;

/**
 *
 * @author vldmrk
 */
public class Dogadjaj implements ApstraktniDomenskiObjekat {

    private int dogadjajID;
    private String naziv;
    private LocalDate datum;
    private Mesto mesto;
    private Ansambl ansambl;

    public Dogadjaj() {
    }

    public Dogadjaj(int dogadjajID, String naziv, LocalDate datum, Mesto mesto) {
        this.dogadjajID = dogadjajID;
        this.naziv = naziv;
        this.datum = datum;
        this.mesto = mesto;
    }

    public Dogadjaj(int dogadjajID, String naziv, LocalDate datum, Mesto mesto, Ansambl ansambl) {
        this.dogadjajID = dogadjajID;
        this.naziv = naziv;
        this.datum = datum;
        this.mesto = mesto;
        this.ansambl = ansambl;
    }

    public int getDogadjajID() {
        return dogadjajID;
    }

    public void setDogadjajID(int dogadjajID) {
        this.dogadjajID = dogadjajID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public Ansambl getAnsambl() {
        return ansambl;
    }

    public void setAnsambl(Ansambl ansambl) {
        this.ansambl = ansambl;
    }

    @Override
    public String vratiNazivTabele() {
        return "dogadjaj";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Dogadjaj d = new Dogadjaj();
            d.setDogadjajID(rs.getInt("dogadjajID"));
            d.setNaziv(rs.getString("naziv"));
            d.setDatum(rs.getDate("datum").toLocalDate());
            
            // Create Mesto object
            int mestoId = rs.getInt("mesto");
            Mesto m = new Mesto();
            m.setMestoID(mestoId);
            try {
                String mestoNaziv = rs.getString("mestoNaziv");
                if (mestoNaziv != null) {
                    m.setNaziv(mestoNaziv);
                }
            } catch (Exception e) {
                // Column doesn't exist, skip
            }
            d.setMesto(m);
            
            // Create Ansambl object
            int ansamblId = rs.getInt("ansambl");
            if (!rs.wasNull()) {
                Ansambl a = new Ansambl();
                a.setAnsamblID(ansamblId);
                try {
                    String ansamblNaziv = rs.getString("imeAnsambla");
                    if (ansamblNaziv != null) {
                        a.setImeAnsambla(ansamblNaziv);
                    }
                } catch (Exception e) {
                    // Column doesn't exist, skip
                }
                d.setAnsambl(a);
            }
            
            lista.add(d);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv, datum, mesto, ansambl";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        String n = (naziv == null) ? "NULL" : "'" + naziv.replace("'", "''") + "'";
        String d = (datum == null) ? "NULL" : "'" + datum.toString() + "'";
        String m = (mesto == null) ? "NULL" : String.valueOf(mesto.getMestoID());
        String a = (ansambl == null) ? "NULL" : String.valueOf(ansambl.getAnsamblID());
        return n + ", " + d + ", " + m + ", " + a;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "dogadjajID=" + dogadjajID;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        Dogadjaj d = new Dogadjaj();
        d.setDogadjajID(rs.getInt("dogadjajID"));
        d.setNaziv(rs.getString("naziv"));
        d.setDatum(rs.getDate("datum").toLocalDate());
        
        // Create Mesto object
        int mestoId = rs.getInt("mesto");
        Mesto m = new Mesto();
        m.setMestoID(mestoId);
        try {
            String mestoNaziv = rs.getString("mestoNaziv");
            if (mestoNaziv != null) {
                m.setNaziv(mestoNaziv);
            }
        } catch (Exception e) {
            // Column doesn't exist, skip
        }
        d.setMesto(m);
        
        // Create Ansambl object
        int ansamblId = rs.getInt("ansambl");
        if (!rs.wasNull()) {
            Ansambl a = new Ansambl();
            a.setAnsamblID(ansamblId);
            try {
                String ansamblNaziv = rs.getString("imeAnsambla");
                if (ansamblNaziv != null) {
                    a.setImeAnsambla(ansamblNaziv);
                }
            } catch (Exception e) {
                // Column doesn't exist, skip
            }
            d.setAnsambl(a);
        }
        
        return d;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        String n = (naziv == null) ? "NULL" : "'" + naziv.replace("'", "''") + "'";
        String d = (datum == null) ? "NULL" : "'" + datum.toString() + "'";
        String m = (mesto == null) ? "NULL" : String.valueOf(mesto.getMestoID());
        String a = (ansambl == null) ? "NULL" : String.valueOf(ansambl.getAnsamblID());
        return "naziv=" + n + ", datum=" + d + ", mesto=" + m + ", ansambl=" + a;
    }

    @Override
    public String toString() {
        return naziv;
    }
}

