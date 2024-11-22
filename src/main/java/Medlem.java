import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Medlem {
    private String navn;
    private String cpr;
    private boolean aktivitetsStatus;
    private String aktivitetsForm;

    public Medlem(String navn, String cpr, boolean aktivitetsStatus, String aktivitetsForm) {
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

    //cpr skal være specifik 6 cifre ellers exception
    public String getCpr() {
        int cprLængde = cpr.length();
        if (cprLængde != 6) {
            throw new RuntimeException("Cpr nummeret skal være 6 cifre");
        }
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

    public String getAktivitetsForm() {
        if (aktivitetsForm.equalsIgnoreCase("konkurrence")) {
            setAktivitetsForm("Konkurrence svømmer");
        } else if (aktivitetsForm.equalsIgnoreCase("motionist")) {
            setAktivitetsForm("Motionist");
        }
        return aktivitetsForm;
    }

    public void setAktivitetsForm(String aktivitetsForm) {
        this.aktivitetsForm = aktivitetsForm;
    }

    //Metode til omregning af cpr til alder
    public String cprOmregning() {
        LocalDate dato = LocalDate.now();
        DateTimeFormatter formaterDato = DateTimeFormatter.ofPattern("ddMMyy");
        String formatteretDato = dato.format(formaterDato); //nuværende dato formatteret
        int resultat = Integer.parseInt(formatteretDato) - Integer.parseInt(this.getCpr());
        String resultat2 = String.valueOf(resultat);
        String deSidsteTo = resultat2.substring(resultat2.length() - 2);
        return deSidsteTo;
    }


    public String betalKontigent(){
        LocalDate indmeldingsDato = LocalDate.now();
        DateTimeFormatter formaterDato = DateTimeFormatter.ofPattern("yyyy");
        String formateretDato = indmeldingsDato.format(formaterDato);
        int kontigent = 1000;

        for(int i = 0; formateretDato.length() == 4;i++){
            int årstal = Integer.parseInt(formateretDato);

        }


        return formateretDato;

    }


    @Override
    public String toString() {
        return "Navn: " + getNavn() +
                ", Alder: " + cprOmregning() + " år" +
                ", Aktivitets status: " + (getAktivitetsStatus() ? "Aktiv" : "Passiv") +
                ", Aktivitetsform: " + getAktivitetsForm();
    }
}





