package domen;

import java.sql.ResultSet;
import java.text.Normalizer;
import java.util.Locale;
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
    private String clanEmail;
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

    public String getClanEmail() {
        return clanEmail;
    }

    public void setClanEmail(String clanEmail) {
        this.clanEmail = clanEmail;
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

    public static String formirajEmail(String punoIme) {
        if (punoIme == null) {
            return null;
        }

        String transliterated = punoIme
                .replace("Đ", "Dj")
                .replace("đ", "dj")
                .replace("Č", "C")
                .replace("č", "c")
                .replace("Ć", "C")
                .replace("ć", "c")
                .replace("Š", "S")
                .replace("š", "s")
                .replace("Ž", "Z")
                .replace("ž", "z");

        String normalized = Normalizer.normalize(transliterated, Normalizer.Form.NFD)
                .replaceAll("\\p{M}+", "")
                .toLowerCase(Locale.ROOT)
                .replaceAll("[^a-z0-9]+", "");

        if (normalized.isEmpty()) {
            return null;
        }

        return normalized + "@gmail.com";
    }

    public static boolean jeValidanEmail(String email) {
        return email != null && email.matches("^[a-z0-9]+(?:[._-][a-z0-9]+)*@gmail\\.com$");
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
            String email = null;
            try {
                email = rs.getString("clanEmail");
            } catch (Exception ex) {
                email = null;
            }
            if (email == null || email.trim().isEmpty()) {
                email = formirajEmail(ime);
            }

            Administrator a = null;
            int adminId = rs.getInt("admin");
            if (!rs.wasNull()) {
                a = new Administrator();
                a.setAdminID(adminId);
            }

            ClanDrustva c = new ClanDrustva();
            c.setClanID(id);
            c.setClanIme(ime);
            c.setClanPol(pol);
            c.setClanGod(god);
            c.setClanBrTel(tel);
            c.setClanEmail(email);
            c.setAdmin(a);
            lista.add(c);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "clanIme,clanPol,clanGod,clanBrTel,clanEmail,admin";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        String ime = (clanIme == null) ? "NULL" : ("'" + clanIme.replace("'", "''") + "'");
        String pol = (clanPol == null) ? "NULL" : ("'" + clanPol.replace("'", "''") + "'");
        String god = String.valueOf(clanGod);
        String tel = (clanBrTel == null) ? "NULL" : ("'" + clanBrTel.replace("'", "''") + "'");
        String email = (clanEmail == null) ? formirajEmail(clanIme) : clanEmail;
        String em = (email == null) ? "NULL" : ("'" + email.replace("'", "''") + "'");
        String a;
        if (admin == null) {
            a = "NULL";
        } else {
            a = String.valueOf(admin.getAdminID());
        }
        return ime + "," + pol + "," + god + "," + tel + "," + em + "," + a;
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
        String email = (clanEmail == null) ? formirajEmail(clanIme) : clanEmail;
        String em = (email == null) ? "NULL" : ("'" + email.replace("'", "''") + "'");
        String a;
        if (admin == null) {
            a = "NULL";
        } else {
            a = String.valueOf(admin.getAdminID());
        }
        return "clanIme=" + ime + ",clanPol=" + pol + ",clanGod=" + god + ",clanBrTel=" + tel + ",clanEmail=" + em + ",admin=" + a;
    }

}
