import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KassererTest {

    @DisplayName("Test af det nuværende indbetalte kontingent")
    @Test
    void indbetaltKontingentForNu() {
        // ----- Arrange -----
        Kasserer kasserer = new Kasserer();

        // ----- Act -----
        int korrekteIndbetaltKontigentForNu = kasserer.indbetaltKontingentForNu();

        // ----- Assert -----
        int forventetIndbetaltKontigentForNu = 3700;
        assertEquals(forventetIndbetaltKontigentForNu,korrekteIndbetaltKontigentForNu);
    }

    @DisplayName("Test af samlet forventet kontigent årligt")
    @Test
    void samletForventetKontingent() {
        // ----- Arrange -----
        Kasserer kasserer = new Kasserer();

        // ----- Act -----
       int korrekteSamletForventetKontingent = kasserer.samletForventetKontingent();

        // ----- Assert -----
        int forventetSamletForventetKontingent = 6900;
        assertEquals(forventetSamletForventetKontingent,korrekteSamletForventetKontingent);

    }


    @DisplayName("Test af restance kontingent")
    @Test
    void restanceKontingent() {
        // ----- Arrange -----
        Kasserer kasserer = new Kasserer();

        // ----- Act -----
        int korrekteRestanceKontingent = kasserer.restanceKontingent();

        // ----- Assert -----
        int forventetRestanceKontingent = 3200;
        assertEquals(forventetRestanceKontingent,korrekteRestanceKontingent);

    }

    @Disabled
    void medlemmerIRestance() {
    }

    @Disabled
    void medlemmerDerHarBetalt() {

    }
}