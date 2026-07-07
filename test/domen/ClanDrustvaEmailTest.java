package domen;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClanDrustvaEmailTest {

    @Test
    public void formirajEmailSpajaImeIPrezimeUMalaSlova() {
        assertEquals("milanpetrovic@gmail.com", ClanDrustva.formirajEmail("Milan Petrovic"));
    }

    @Test
    public void formirajEmailUklanjaRazmakeISpecijalneZnake() {
        assertEquals("djordjepetrovic@gmail.com", ClanDrustva.formirajEmail("Djordje Petrovic"));
    }

    @Test
    public void validanEmailMoraDaBudeGmailUIspravnomFormatu() {
        assertTrue(ClanDrustva.jeValidanEmail("milanpetrovic@gmail.com"));
    }
}
