package domen;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UcesceTest {

    @Test
    public void vratiVrednostiZaUbacivanjeKoristiIdentifikatore() {
        ClanDrustva clan = new ClanDrustva();
        clan.setClanID(5);

        Ansambl ansambl = new Ansambl();
        ansambl.setAnsamblID(8);

        Uloga uloga = new Uloga();
        uloga.setUlogaID(13);

        Ucesce ucesce = new Ucesce(clan, ansambl, uloga);

        assertEquals("5,8,13", ucesce.vratiVrednostiZaUbacivanje());
    }

    @Test
    public void vratiPrimarniKljucKoristiClanIAnsambl() {
        ClanDrustva clan = new ClanDrustva();
        clan.setClanID(2);

        Ansambl ansambl = new Ansambl();
        ansambl.setAnsamblID(9);

        Ucesce ucesce = new Ucesce(clan, ansambl, null);

        assertEquals("ucesce.clan=2 AND ucesce.ansambl=9", ucesce.vratiPrimarniKljuc());
    }

    @Test
    public void toStringVracaNazivUloge() {
        Uloga uloga = new Uloga();
        uloga.setNaziv("Solista");

        Ucesce ucesce = new Ucesce();
        ucesce.setUloga(uloga);

        assertEquals("Solista", ucesce.toString());
    }
}
