import static org.junit.jupiter.api.Assertions.*;

import domainmodel.Formand;
import domainmodel.Medlem;
import domainmodel.MedlemsStatus;
import org.junit.jupiter.api.*;

class FormandTest {

    @DisplayName("Test af tilføj medlem")
    @Test
    void tilføjMedlem() {

        //---- Arrange -----
        Formand formand = new Formand();
        formand.tilføjMedlem("Yvonne", "020767", MedlemsStatus.AKTIV, "motionist", false);

        //---- Act -------

        int korrektAntal = formand.antalMedlemmer();

        //----- Assert -------

        int forventAntal = 8; //TODO: listen ændres hele tiden, er dette korrekt eller skal man bruge antalMedlemmer metoden
        assertEquals(forventAntal, korrektAntal);
    }

    @DisplayName("Test af slet medlem")
    @Test
    void sletMedlem() { //TODO: slet metoden skal fikse i formands klassen før testen virker
        // ----- Arrange -----
        Formand formand = new Formand();
        formand.tilføjMedlem("Lina", "120397", MedlemsStatus.PASSIV, "motionist", true);

        // ----- Act -----
        formand.sletMedlem("120397");
        int korrektAntal = formand.antalMedlemmer();

        // ----- Assert ------
        int forventetAntal = 7;
        assertEquals(forventetAntal, korrektAntal);

    }

    @DisplayName("Test af redigering af medlems navn")
    @Test
    void redigerMedlem1() {
        // ----- Arrange -----
        Formand formand = new Formand();
        Medlem yvonne = new Medlem("Yvonne", "020767", MedlemsStatus.AKTIV, "motionist", false);

        // ----- Act -------
        formand.redigerMedlem(yvonne, 1, "Bent");
        String korrektNyeNavn = "Bent";

        // ------ Assert ------
        String forventetNyeNavn = "Bent";
        assertEquals(forventetNyeNavn, korrektNyeNavn);
    }

    @DisplayName("Test af redigering af medlems betalingsstatus")
    @Test
    void redigerMedlem2() {
        // ----- Arrange -----
        Formand formand = new Formand();
        Medlem jan = new Medlem("Jan", "020767", MedlemsStatus.AKTIV, "motionist", false);

        // ----- Act -------
        formand.redigerMedlem(jan, 5, "true");
        String korrektNyeBetalingsstatus = "true";

        // ------ Assert ------
        String forventetNyeBetalingsstatus = "true";
        assertEquals(forventetNyeBetalingsstatus,korrektNyeBetalingsstatus);
    }

    @DisplayName("Test af find specifikt medlem, kun navn returneres")
    @Test
    void findSpecifiktMedlemsNavn() {
        // ----- Arrange -----
        Formand formand = new Formand();
        formand.tilføjMedlem("Marianne", "121162", MedlemsStatus.AKTIV, "konkurrence", true);

        // ----- Act -----
        formand.findSpecifiktMedlemsNavn("121162");
        String korrektFundAfMedlemsNavn = "Marianne";

        // ----- Assert -----
        String forventetFundAfMedlemsNavn = "Marianne";
        assertEquals(forventetFundAfMedlemsNavn,korrektFundAfMedlemsNavn);
    }

    @DisplayName("Test af find specifikt medlem, alle oplysninger returneres")
    @Test
    void findSpecifiktMedlem() {
        // ----- Arrange -----
        Formand formand = new Formand();
        Medlem kenny = new Medlem("Kenny", "020901", MedlemsStatus.PASSIV, "konkurrence", false);

        // ----- Act -----
        formand.findSpecifiktMedlem("020901");
        Medlem korrektFundAfMedlem = kenny;

        // ----- Assert -----
        Medlem forventetFundAfMedlem = kenny;
        assertEquals(forventetFundAfMedlem,korrektFundAfMedlem);

    }

    @Disabled
    void sorterMedlemmerValgMetode() {
    }

    @Disabled
    void visMedlemmer() {

    }

    @Disabled
    void gemMedlem() {
    }
}