import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Medlem {
    private String navn;
    private String cpr;
    private boolean aktivitetsStatus;
    private boolean aktivitetsForm;

    public Medlem(String navn, String cpr, boolean aktivitetsStatus, boolean aktivitetsForm) {
        this.navn = navn;
        this.cpr = cpr;
        this.aktivitetsStatus = aktivitetsStatus;
        this.aktivitetsForm = aktivitetsForm;
    }


    //------------------ GETTER & SETTER ----------------
    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public boolean getAktivitetsStatus() {
        return aktivitetsStatus;
    }

    public void setAktivitetsStatus(boolean aktivitetsStatus) {
        this.aktivitetsStatus = aktivitetsStatus;
    }

    public boolean getAktivitetsForm() {
        return aktivitetsForm;
    }

    public void setAktivitetsForm(boolean aktivitetsForm) {
        this.aktivitetsForm = aktivitetsForm;
    }


    //Metode til omregning af cpr til alder
    public String cprOmregning() {
        LocalDate dato = LocalDate.now();
        DateTimeFormatter formaterDato = DateTimeFormatter.ofPattern("ddMMyy");
        String formatteretDato = dato.format(formaterDato);
        int resultat = Integer.parseInt(formatteretDato) - Integer.parseInt(this.getCpr());
        String resultat2 = String.valueOf(resultat);
        String deSidsteTo = resultat2.substring(resultat2.length() - 2);
        return deSidsteTo;
    }


    @Override
    public String toString() {
        return "navn: " + getNavn() +
                " Alder: " + cprOmregning() +
                " aktivitets status: " + getAktivitetsStatus() +
                " aktivitetsform: " + getAktivitetsForm();
    }
}





