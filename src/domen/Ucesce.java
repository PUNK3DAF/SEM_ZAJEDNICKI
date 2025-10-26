/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author vldmrk
 */
public class Ucesce implements ApstraktniDomenskiObjekat {

    private ClanDrustva clan;
    private Ansambl ansambl;
    private String uloga;

    public Ucesce() {
    }

    public Ucesce(ClanDrustva clan, Ansambl ansambl, String uloga) {
        this.clan = clan;
        this.ansambl = ansambl;
        this.uloga = uloga;
    }

    public ClanDrustva getClan() {
        return clan;
    }

    public void setClan(ClanDrustva clan) {
        this.clan = clan;
    }

    public Ansambl getAnsambl() {
        return ansambl;
    }

    public void setAnsambl(Ansambl ansambl) {
        this.ansambl = ansambl;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Ucesce other = (Ucesce) obj;
        if (!Objects.equals(this.clan, other.clan)) {
            return false;
        }
        return Objects.equals(this.ansambl, other.ansambl);
    }

    @Override
    public String toString() {
        return uloga;
    }

    @Override
    public String vratiNazivTabele() {
        return "ucesce";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "clan,ansambl,uloga";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        String c;
        if (clan == null) {
            c = "NULL";
        } else {
            c = String.valueOf(clan.getClanID());
        }
        String an;
        if (ansambl == null) {
            an = "NULL";
        } else {
            an = String.valueOf(ansambl.getAnsamblID());
        }
        String u = (uloga == null) ? "NULL" : ("'" + uloga.replace("'", "''") + "'");
        return c + "," + an + "," + u;
    }

    @Override
    public String vratiPrimarniKljuc() {
        String c = (clan == null) ? "NULL" : String.valueOf(clan.getClanID());
        String a = (ansambl == null) ? "NULL" : String.valueOf(ansambl.getAnsamblID());
        return "ucesce.clan=" + c + " AND ucesce.ansambl=" + a;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        String u = (uloga == null) ? "NULL" : ("'" + uloga.replace("'", "''") + "'");
        return "uloga=" + u;
    }
}
