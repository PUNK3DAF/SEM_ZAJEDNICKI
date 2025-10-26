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
public class ClanDrustva implements ApstraktniDomenskiObjekat {

    private int clanID;
    private String clanIme;
    private String clanPol;
    private int clanGod;
    private String clanBrTel;
    private Administrator admin;

    public ClanDrustva() {
    }

    public ClanDrustva(int clanID, String clanIme, String clanPol, int clanGod, String clanBrTel, Administrator admin) {
        this.clanID = clanID;
        this.clanIme = clanIme;
        this.clanPol = clanPol;
        this.clanGod = clanGod;
        this.clanBrTel = clanBrTel;
        this.admin = admin;
    }

    public int getClanID() {
        return clanID;
    }

    public void setClanID(int clanID) {
        this.clanID = clanID;
    }

    public String getClanIme() {
        return clanIme;
    }

    public void setClanIme(String clanIme) {
        this.clanIme = clanIme;
    }

    public String getClanPol() {
        return clanPol;
    }

    public void setClanPol(String clanPol) {
        this.clanPol = clanPol;
    }

    public int getClanGod() {
        return clanGod;
    }

    public void setClanGod(int clanGod) {
        this.clanGod = clanGod;
    }

    public String getClanBrTel() {
        return clanBrTel;
    }

    public void setClanBrTel(String clanBrTel) {
        this.clanBrTel = clanBrTel;
    }

    public Administrator getAdmin() {
        return admin;
    }

    public void setAdmin(Administrator admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return clanIme;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final ClanDrustva other = (ClanDrustva) obj;
        return this.clanID == other.clanID;
    }

    @Override
    public String vratiNazivTabele() {
        return "clandrustva";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "clanIme,clanPol,clanGod,clanBrTel,admin";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        String ime = (clanIme == null) ? "NULL" : ("'" + clanIme.replace("'", "''") + "'");
        String pol = (clanPol == null) ? "NULL" : ("'" + clanPol.replace("'", "''") + "'");
        String god = String.valueOf(clanGod);
        String tel = (clanBrTel == null) ? "NULL" : ("'" + clanBrTel.replace("'", "''") + "'");
        String a;
        if (admin == null) {
            a = "NULL";
        } else {
            a = String.valueOf(admin.getAdminID());
        }
        return ime + "," + pol + "," + god + "," + tel + "," + a;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "clandrustva.clanID=" + clanID;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        String ime = (clanIme == null) ? "NULL" : ("'" + clanIme.replace("'", "''") + "'");
        String pol = (clanPol == null) ? "NULL" : ("'" + clanPol.replace("'", "''") + "'");
        String god = String.valueOf(clanGod); // int -> uvek broj
        String tel = (clanBrTel == null) ? "NULL" : ("'" + clanBrTel.replace("'", "''") + "'");
        String a;
        if (admin == null) {
            a = "NULL";
        } else {
            a = String.valueOf(admin.getAdminID());
        }
        return "clanIme=" + ime + ",clanPol=" + pol + ",clanGod=" + god + ",clanBrTel=" + tel + ",admin=" + a;
    }

}
