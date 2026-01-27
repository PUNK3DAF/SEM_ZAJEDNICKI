/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author vldmrk
 */
public class Dogadjaj extends ApstraktniDomenskiObjekat implements Serializable {

    private Integer dogadjajID;
    private String naziv;
    private LocalDate datum;
    private Mesto mesto;

    public Dogadjaj() {
    }

    public Dogadjaj(Integer dogadjajID, String naziv, LocalDate datum, Mesto mesto) {
        this.dogadjajID = dogadjajID;
        this.naziv = naziv;
        this.datum = datum;
        this.mesto = mesto;
    }

    public Integer getDogadjajID() {
        return dogadjajID;
    }

    public void setDogadjajID(Integer dogadjajID) {
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

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String getNazivTabele() {
        return "dogadjaj";
    }

    @Override
    public String getNazivKljuca() {
        return "dogadjajID";
    }

    @Override
    public String getVrednostKljuca() {
        return dogadjajID.toString();
    }

}
