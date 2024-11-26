import java.util.ArrayList;

public class Controller {
    private Formand formand;
    private Kasserer kasserer;

    public Controller() {
        formand = new Formand();
        kasserer = new Kasserer();
    }

    public void opretMedlem(String navn, String cpr, MedlemsStatus status, String aktivitetsForm, boolean harBetalt) {
        formand.tilføjMedlem(navn, cpr, status, aktivitetsForm, harBetalt);
    }

    public void sletMedlem(String cpr) {
        formand.sletMedlem(cpr);
    }

    public void redigerMedlem(String cpr, String nytNavn, MedlemsStatus nyStatus, String nyAktivitetsForm, boolean harBetalt) {
        formand.redigerMedlem(cpr, nytNavn, nyStatus, nyAktivitetsForm, harBetalt);
    }

    public void visMedlemmer() {
        formand.visMedlemmer();
    }

    public void getMedlemsListe() {
         formand.visMedlemmer();
    }


}
