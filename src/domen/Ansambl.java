package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private List<Ucesce> ucesca; // pomocno polje
    private int obrisan;

    public Ansambl() {
        obrisan = 0;
    }

    public Ansambl(int ansamblID, String imeAnsambla, String opisAnsambla, Administrator admin) {
        this.ansamblID = ansamblID;
        this.imeAnsambla = imeAnsambla;
        this.opisAnsambla = opisAnsambla;
        this.admin = admin;
        this.obrisan = 0;
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

    public int getObrisan() {
        return obrisan;
    }

    public void setObrisan(int obrisan) {
        this.obrisan = obrisan;
    }

    public List<Ucesce> getUcesca() {
        return ucesca;
    }

    public void setUcesca(List<Ucesce> ucesca) {
        this.ucesca = ucesca;
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
        return "ansambl";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("ansamblID");
            String ime = rs.getString("imeAnsambla");
            String opis = rs.getString("opisAnsambla");

            Administrator a = null;
            int adminId = rs.getInt("admin");
            if (!rs.wasNull()) {
                a = new Administrator();
                a.setAdminID(adminId);
            }

            int ob = 0;
            try {
                ob = rs.getInt("obrisan");
                if (rs.wasNull()) {
                    ob = 0;
                }
            } catch (SQLException e) {
                ob = 0;
            }

            Ansambl ans = new Ansambl();
            ans.setAnsamblID(id);
            ans.setImeAnsambla(ime);
            ans.setOpisAnsambla(opis);
            ans.setAdmin(a);
            ans.setObrisan(ob);
            lista.add(ans);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "imeAnsambla,opisAnsambla,admin,obrisan";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        String ime = (imeAnsambla == null) ? "NULL" : ("'" + imeAnsambla.replace("'", "''") + "'");
        String opis = (opisAnsambla == null) ? "NULL" : ("'" + opisAnsambla.replace("'", "''") + "'");
        String a;
        if (admin == null) {
            a = "NULL";
        } else {
            a = String.valueOf(admin.getAdminID());
        }
        String o = String.valueOf(obrisan);
        return ime + "," + opis + "," + a + "," + o;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "ansambl.ansamblID=" + ansamblID;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        String ime = (imeAnsambla == null) ? "NULL" : ("'" + imeAnsambla.replace("'", "''") + "'");
        String opis = (opisAnsambla == null) ? "NULL" : ("'" + opisAnsambla.replace("'", "''") + "'");
        String a;
        if (admin == null) {
            a = "NULL";
        } else {
            a = String.valueOf(admin.getAdminID()); // adminID je int
        }
        String o = String.valueOf(obrisan);
        return "imeAnsambla=" + ime + ",opisAnsambla=" + opis + ",admin=" + a + ",obrisan=" + o;
    }

}
