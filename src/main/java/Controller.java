import java.util.ArrayList;

public class Controller {
    private Formand formand;
    private Kasserer kasserer;

    public Controller() {
        formand = new Formand();
        kasserer = new Kasserer();
    }

    public void opretMedlem(String navn, String cpr, MedlemsStatus status, String aktivitetsForm) {
        formand.tilføjMedlem(navn, cpr, status, aktivitetsForm);
    }

    public void sletMedlem(String cpr) {
        formand.sletMedlem(cpr);
    }

    public void redigerMedlem(String cpr, String nytNavn, MedlemsStatus nyStatus, String nyAktivitetsForm) {
        formand.redigerMedlem(cpr, nytNavn, nyStatus, nyAktivitetsForm);
    }

    public void visMedlemmer() {
        formand.visMedlemmer();
    }

    public ArrayList<Medlem> getMedlemsListe() {
        return formand.getMedlemsListe();
    }


}
