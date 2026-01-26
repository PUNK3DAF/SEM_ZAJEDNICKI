package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Zanr implements ApstraktniDomenskiObjekat {

    private int zanrID;
    private String naziv;

    public Zanr() {
    }

    public Zanr(int zanrID, String naziv) {
        this.zanrID = zanrID;
        this.naziv = naziv;
    }

    public int getZanrID() {
        return zanrID;
    }

    public void setZanrID(int zanrID) {
        this.zanrID = zanrID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.zanrID;
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
        final Zanr other = (Zanr) obj;
        return this.zanrID == other.zanrID;
    }

    @Override
    public String vratiNazivTabele() {
        return "zanr";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("zanrID");
            String naz = rs.getString("naziv");

            Zanr z = new Zanr();
            z.setZanrID(id);
            z.setNaziv(naz);
            lista.add(z);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        String naz = (naziv == null) ? "NULL" : ("'" + naziv.replace("'", "''") + "'");
        return naz;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "zanr.zanrID=" + zanrID;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        String naz = (naziv == null) ? "NULL" : ("'" + naziv.replace("'", "''") + "'");
        return "naziv=" + naz;
    }
}
