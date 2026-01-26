package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Mesto implements ApstraktniDomenskiObjekat {

    private int mestoID;
    private String naziv;
    private String adresa;

    public Mesto() {
    }

    public Mesto(int mestoID, String naziv, String adresa) {
        this.mestoID = mestoID;
        this.naziv = naziv;
        this.adresa = adresa;
    }

    public int getMestoID() {
        return mestoID;
    }

    public void setMestoID(int mestoID) {
        this.mestoID = mestoID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String vratiNazivTabele() {
        return "mesto";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Mesto m = new Mesto();
            m.setMestoID(rs.getInt("mestoID"));
            m.setNaziv(rs.getString("naziv"));
            m.setAdresa(rs.getString("adresa"));
            lista.add(m);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv,adresa";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        String n = (naziv == null) ? "NULL" : "'" + naziv.replace("'", "''") + "'";
        String a = (adresa == null) ? "NULL" : "'" + adresa.replace("'", "''") + "'";
        return n + "," + a;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "mestoID=" + mestoID;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        Mesto m = new Mesto();
        m.setMestoID(rs.getInt("mestoID"));
        m.setNaziv(rs.getString("naziv"));
        m.setAdresa(rs.getString("adresa"));
        return m;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        String n = (naziv == null) ? "NULL" : "'" + naziv.replace("'", "''") + "'";
        String a = (adresa == null) ? "NULL" : "'" + adresa.replace("'", "''") + "'";
        return "naziv=" + n + ",adresa=" + a;
    }

    @Override
    public String toString() {
        if (naziv != null && !naziv.trim().isEmpty()) {
            return naziv;
        }
        return "Mesto #" + mestoID;
    }
}
