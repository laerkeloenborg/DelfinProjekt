import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class Medlem {
    private String navn;
    private String cpr;
    private Medlemsstatus MEDLEMSSTATUS;
    private Alderstype ALDERSTYPE;
    private String aktivitetsForm;

    public Medlem(String navn, String cpr, Medlemsstatus MEDLEMSSTATUS, String aktivitetsForm) {
        this.navn = navn;
        this.cpr = cpr;
        this.MEDLEMSSTATUS = MEDLEMSSTATUS;
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

  public Medlemsstatus getMedlemsstatus(){
        return MEDLEMSSTATUS;
  }

  public void setMedlemsstatus(Medlemsstatus MEDLEMSSTATUS){
        this.MEDLEMSSTATUS = MEDLEMSSTATUS;
  }

  public Alderstype getALDERSTYPE(){
      int alder = this.cprOmregning();
        if(alder < 18){ //TODO: spørgsmål til PO, vi antager at når man fylder 18 så skifter det til SENIOR
            setALDERSTYPE(Alderstype.JUNIOR);
        } else{
            setALDERSTYPE(Alderstype.SENIOR);
        }

        return ALDERSTYPE;
  }

  public void setALDERSTYPE(Alderstype ALDERSTYPE){
        this.ALDERSTYPE = ALDERSTYPE;
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
    public int cprOmregning() {
        LocalDate nu = LocalDate.now();
        String cpr = this.getCpr();
        int dag = Integer.parseInt(cpr.substring(0, 2));
        int måned = Integer.parseInt(cpr.substring(2, 4));
        int år = Integer.parseInt(cpr.substring(4, 6));
        if (år >= 0 && år <= LocalDate.now().getYear() % 100) {
            år += 2000;
        } else {
            år += 1900;
        }
        LocalDate fødselsdato = LocalDate.of(år, måned, dag);
        int alder = Period.between(fødselsdato, nu).getYears();
        return alder;
    }

    public int betalKontigent(){
        int kontigent = 0;
        int alder = this.cprOmregning();

        if(getMedlemsstatus().equals(Medlemsstatus.AKTIV)){
            if (getALDERSTYPE().equals(Alderstype.JUNIOR)){
                kontigent = 1000;
            } else if(getALDERSTYPE().equals(Alderstype.SENIOR)){
                if (alder > 60){
                    int rabat = 1600 * 25 / 100;
                    kontigent = 1600 - rabat;
                } else {
                    kontigent = 1600;
                }
            }
        } else if(getMedlemsstatus().equals(Medlemsstatus.PASSIV)){
            kontigent = 500;
        }

        return kontigent;
    }

    @Override
    public String toString() {
        return "Navn: " + getNavn() +
                ", Alder: " + cprOmregning() + " år" +
                ", Aktivitets status: " + (MEDLEMSSTATUS==Medlemsstatus.AKTIV ? "Aktiv" : "Passiv") +
                ", Aktivitetsform: " + getAktivitetsForm();
    }
}





