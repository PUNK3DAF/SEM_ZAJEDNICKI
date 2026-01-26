
package komunikacija;

import java.io.Serializable;

/**
 *
 * @author vldmrk
 */
public enum Operacije implements Serializable {
    ADMIN_LOGIN,
    UCITAJ_ANSAMBLE,
    UCITAJ_UCESCA, // pomocna operacija
    KREIRAJ_CLANA_DRUSTVA,
    UCITAJ_CLANOVE,
    NADJI_CLANA_DRUSTVA,
    UCITAJ_CLANA_DRUSTVA,
    IZMENI_CLANA_DRUSTVA,
    OBRISI_CLANA_DRUSTVA,
    KREIRAJ_ANSAMBL,
    NADJI_ANSAMBL,
    UCITAJ_ANSAMBL,
    IZMENA_ANSAMBLA,
    OBRISI_ANSAMBL,
    KREIRAJ_ZANR,
    UCITAJ_ZANROVE,
    IZMENI_ZANR,
    OBRISI_ZANR,
    KREIRAJ_ULOGU,
    UCITAJ_ULOGE,
    IZMENI_ULOGU,
    OBRISI_ULOGU
}
