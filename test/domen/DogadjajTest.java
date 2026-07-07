package domen;

import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DogadjajTest {

    @Test
    public void vratiVrednostiZaUbacivanjeFormiraSqlVrednosti() {
        Mesto mesto = new Mesto();
        mesto.setMestoID(7);

        Ansambl ansambl = new Ansambl();
        ansambl.setAnsamblID(11);

        Dogadjaj dogadjaj = new Dogadjaj();
        dogadjaj.setNaziv("Koncert");
        dogadjaj.setDatum(LocalDate.of(2026, 7, 7));
        dogadjaj.setMesto(mesto);
        dogadjaj.setAnsambl(ansambl);

        assertEquals("'Koncert', '2026-07-07', 7, 11", dogadjaj.vratiVrednostiZaUbacivanje());
    }

    @Test
    public void vratiVrednostiZaIzmenuFormiraSqlVrednosti() {
        Mesto mesto = new Mesto();
        mesto.setMestoID(2);

        Ansambl ansambl = new Ansambl();
        ansambl.setAnsamblID(3);

        Dogadjaj dogadjaj = new Dogadjaj();
        dogadjaj.setNaziv("Probe");
        dogadjaj.setDatum(LocalDate.of(2026, 1, 15));
        dogadjaj.setMesto(mesto);
        dogadjaj.setAnsambl(ansambl);

        assertEquals("naziv='Probe', datum='2026-01-15', mesto=2, ansambl=3", dogadjaj.vratiVrednostiZaIzmenu());
    }

    @Test
    public void toStringVracaNaziv() {
        Dogadjaj dogadjaj = new Dogadjaj();
        dogadjaj.setNaziv("Gostovanje");

        assertEquals("Gostovanje", dogadjaj.toString());
    }
}
