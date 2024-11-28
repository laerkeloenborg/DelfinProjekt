import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedlemTest {

    @Test
    void cprOmregning() {
        // ----- Arrange -----
        Medlem john = new Medlem("John","021270", MedlemsStatus.PASSIV,"motionist",true);

        // ----- Act -----
        int korrekteAlder = john.cprOmregning();

        // ----- Assert -----
        int forventetAlder = 53;
        assertEquals(forventetAlder,korrekteAlder);
    }

    @Test
    void kontingent() {
        // ----- Arrange -----
        Medlem annika = new Medlem("Annika","071010", MedlemsStatus.AKTIV,"motionist",true);

        // ----- Act -----
        int korrekteKontingent = annika.kontingent();

        // ----- Assert -----
        int forventetKontingent = 1000;
        assertEquals(forventetKontingent,korrekteKontingent);

    }

}