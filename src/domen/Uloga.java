package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Uloga implements ApstraktniDomenskiObjekat {

    private int ulogaID;
    private String naziv;

    public Uloga() {
    }

    public Uloga(int ulogaID, String naziv) {
        this.ulogaID = ulogaID;
        this.naziv = naziv;
    }

    public int getUlogaID() {
        return ulogaID;
    }

    public void setUlogaID(int ulogaID) {
        this.ulogaID = ulogaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "uloga";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Uloga u = new Uloga();
            u.setUlogaID(rs.getInt("ulogaID"));
            u.setNaziv(rs.getString("naziv"));
            lista.add(u);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        String n = (naziv == null) ? "NULL" : "'" + naziv.replace("'", "''") + "'";
        return n;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "ulogaID=" + ulogaID;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        Uloga u = new Uloga();
        u.setUlogaID(rs.getInt("ulogaID"));
        u.setNaziv(rs.getString("naziv"));
        return u;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        String n = (naziv == null) ? "NULL" : "'" + naziv.replace("'", "''") + "'";
        return "naziv=" + n;
    }

    @Override
    public String toString() {
        return naziv;
    }
}
