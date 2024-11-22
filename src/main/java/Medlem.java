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
    public String getNavn(){
        return navn;
    }
    public void setNavn(String navn){
        this.navn = navn;
    }

    //TODO: LAV EN EXCEPTION SÅ MAN SKAL SKRIVE 6 TAL
    public String getCpr() {
       return cpr;
    }
    public void setCpr(String cpr){
        this.cpr = cpr;
    }

    public boolean getAktivitetsStatus(){
        return aktivitetsStatus;
    }
    public void setAktivitetsStatus(boolean aktivitetsStatus){
        this.aktivitetsStatus = aktivitetsStatus;
    }

    public String getAktivitetsForm() {
        if(aktivitetsForm.equalsIgnoreCase("konkurrence")){
            setAktivitetsForm("Konkurrence svømmer");
        } else if (aktivitetsForm.equalsIgnoreCase("motionist")){
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
        String formatteretDato = dato.format(formaterDato);
        int resultat = Integer.parseInt(formatteretDato) - Integer.parseInt(this.getCpr());
        String resultat2 = String.valueOf(resultat);
        String deSidsteTo = resultat2.substring(resultat2.length() - 2);
        return deSidsteTo;
    }


    @Override
    public String toString() {
        return "navn: "+ getNavn() +
                " Alder: " + cprOmregning() +
                " aktivitets status: " + getAktivitetsStatus() +
                " aktivitetsform: "+ getAktivitetsForm();
    }
}





