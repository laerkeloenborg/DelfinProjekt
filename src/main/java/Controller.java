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

    public void redigerMedlem2(Medlem medlem, int valg, String newValue){
        formand.redigerMedlem2(medlem, valg, newValue);
    }

    public void visMedlemmer() {
        formand.visMedlemmer();
    }






    public String findSpecifiktMedlemsNavn(String cpr){
        return formand.findSpecifiktMedlemsNavn(cpr);
    }

    public Medlem findSpecifiktMedlem(String cpr){
        return formand.findSpecifiktMedlem(cpr);
    }



    public void sorterMedlemmerValgMetode(int valg) {
        formand.sorterMedlemmerValgMetode(valg);
    }




}
