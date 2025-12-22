package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author vldmrk
 */
public class Administrator implements ApstraktniDomenskiObjekat {

    private int adminID;
    private String adminUsername;
    private String adminPassword;
    private String adminIme;

    public Administrator() {
    }

    public Administrator(int adminID, String adminUsername, String adminPassword, String adminIme) {
        this.adminID = adminID;
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
        this.adminIme = adminIme;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminIme() {
        return adminIme;
    }

    public void setAdminIme(String adminIme) {
        this.adminIme = adminIme;
    }

    @Override
    public String toString() {
        return adminIme;
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
        final Administrator other = (Administrator) obj;
        if (!Objects.equals(this.adminUsername, other.adminUsername)) {
            return false;
        }
        return Objects.equals(this.adminPassword, other.adminPassword);
    }

    @Override
    public String vratiNazivTabele() {
        return "administrator";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            int adminId = rs.getInt("adminID");
            String username = rs.getString("adminUsername");
            String pass = rs.getString("adminPassword");
            String ime = rs.getString("adminIme");

            Administrator a = new Administrator();
            a.setAdminID(adminId);
            a.setAdminUsername(username);
            a.setAdminPassword(pass);
            a.setAdminIme(ime);

            lista.add(a);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "adminUsername,adminPassword,adminIme";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        String u = (adminUsername == null) ? "NULL" : ("'" + adminUsername.replace("'", "''") + "'");
        String p = (adminPassword == null) ? "NULL" : ("'" + adminPassword.replace("'", "''") + "'");
        String i = (adminIme == null) ? "NULL" : ("'" + adminIme.replace("'", "''") + "'");
        return u + "," + p + "," + i;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "administrator.adminID=" + adminID;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        String u = (adminUsername == null) ? "NULL" : ("'" + adminUsername.replace("'", "''") + "'");
        String p = (adminPassword == null) ? "NULL" : ("'" + adminPassword.replace("'", "''") + "'");
        String i = (adminIme == null) ? "NULL" : ("'" + adminIme.replace("'", "''") + "'");
        return "adminUsername=" + u + ",adminPassword=" + p + ",adminIme=" + i;
    }

}
