/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.List;
import java.sql.SQLException;

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
    private int obrisan;
    private Administrator admin;

    public ClanDrustva() {
        this.obrisan = 0;
    }

    public ClanDrustva(int clanID, String clanIme, String clanPol, int clanGod, String clanBrTel, Administrator admin) {
        this.clanID = clanID;
        this.clanIme = clanIme;
        this.clanPol = clanPol;
        this.clanGod = clanGod;
        this.clanBrTel = clanBrTel;
        this.admin = admin;
        this.obrisan = 0;
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

    public int getObrisan() {
        return obrisan;
    }

    public void setObrisan(int obrisan) {
        this.obrisan = obrisan;
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
        List<ApstraktniDomenskiObjekat> lista = new java.util.ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("clanID");
            String ime = rs.getString("clanIme");
            String pol = rs.getString("clanPol");
            int god = rs.getInt("clanGod");
            if (rs.wasNull()) {
                god = 0;
            }
            String tel = rs.getString("clanBrTel");

            Administrator a = null;
            int adminId = rs.getInt("admin");
            if (!rs.wasNull()) {
                a = new Administrator();
                a.setAdminID(adminId);
            }

            int ob;
            try {
                ob = rs.getInt("obrisan");
                if (rs.wasNull()) {
                    ob = 0;
                }
            } catch (SQLException e) {
                ob = 0;
            }

            ClanDrustva c = new ClanDrustva();
            c.setClanID(id);
            c.setClanIme(ime);
            c.setClanPol(pol);
            c.setClanGod(god);
            c.setClanBrTel(tel);
            c.setAdmin(a);
            c.setObrisan(ob);
            lista.add(c);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "clanIme,clanPol,clanGod,clanBrTel,admin,obrisan";
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
        String o = String.valueOf(obrisan);
        return ime + "," + pol + "," + god + "," + tel + "," + a + "," + o;
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
        String god = String.valueOf(clanGod);
        String tel = (clanBrTel == null) ? "NULL" : ("'" + clanBrTel.replace("'", "''") + "'");
        String a;
        if (admin == null) {
            a = "NULL";
        } else {
            a = String.valueOf(admin.getAdminID());
        }
        String o = String.valueOf(obrisan);
        return "clanIme=" + ime + ",clanPol=" + pol + ",clanGod=" + god + ",clanBrTel=" + tel + ",admin=" + a + ",obrisan=" + o;
    }

}
