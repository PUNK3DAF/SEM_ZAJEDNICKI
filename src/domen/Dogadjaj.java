/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vldmrk
 */
public class Dogadjaj implements ApstraktniDomenskiObjekat {

    private int dogadjajID;
    private String naziv;
    private LocalDate datum;
    private int mestoID;
    private Mesto mesto;

    public Dogadjaj() {
    }

    public Dogadjaj(int dogadjajID, String naziv, LocalDate datum, int mestoID) {
        this.dogadjajID = dogadjajID;
        this.naziv = naziv;
        this.datum = datum;
        this.mestoID = mestoID;
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

    public int getMestoID() {
        return mestoID;
    }

    public void setMestoID(int mestoID) {
        this.mestoID = mestoID;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
        if (mesto != null) {
            this.mestoID = mesto.getMestoID();
        }
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
            d.setMestoID(rs.getInt("mestoID"));
            
            // If mesto name is available from joined result, create Mesto object
            try {
                String mestoNaziv = rs.getString("mestoNaziv");
                if (mestoNaziv != null) {
                    Mesto m = new Mesto();
                    m.setMestoID(d.getMestoID());
                    m.setNaziv(mestoNaziv);
                    d.setMesto(m);
                }
            } catch (Exception e) {
                // Column doesn't exist, skip
            }
            lista.add(d);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv, datum, mestoID";
    }return n + ", " + d + ", " + mestoID
    @Override
    public String vratiVrednostiZaUbacivanje() {
        String n = (naziv == null) ? "NULL" : "'" + naziv.replace("'", "''") + "'";
        String d = (datum == null) ? "NULL" : "'" + datum.toString() + "'";
        String m = (mesto == null || mesto.getMestoID() == null) ? "NULL" : mesto.getMestoID().toString();
        return n + ", " + d + ", " + m;
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
        
        d.setMestoID(rs.getInt("mestoID"));
        
        // If mesto name is available from joined result, create Mesto object
        try {
            String mestoNaziv = rs.getString("mestoNaziv");
            if (mestoNaziv != null) {
                Mesto m = new Mesto();
                m.setMestoID(d.getMestoID());
                m.setNaziv(mestoNaziv);
                d.setMesto(m);
            }
        } catch (Exception e) {
            // Column doesn't exist, skip
        return d;
    }
return "naziv=" + n + ", datum=" + d + ", mestoID=" + mestoID
    public String vratiVrednostiZaIzmenu() {
        String n = (naziv == null) ? "NULL" : "'" + naziv.replace("'", "''") + "'";
        String d = (datum == null) ? "NULL" : "'" + datum.toString() + "'";
        String m = (mesto == null || mesto.getMestoID() == null) ? "NULL" : mesto.getMestoID().toString();
        return "naziv=" + n + ", datum=" + d + ", mestoID=" + m;
    }

    @Override
    public String toString() {
        return naziv;
    }
}

