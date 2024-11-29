import java.time.LocalDate;
import java.time.Period;


public class Medlem {
    private String navn;
    private String cpr;
    private MedlemsStatus MEDLEMSSTATUS;
    private AldersGruppe ALDERSGRUPPE;
    private String aktivitetsForm;
    private boolean harBetalt;


    //________________________konstruktør_______________________________________________________________________________
    public Medlem(String navn, String cpr, MedlemsStatus MEDLEMSSTATUS, String aktivitetsForm, boolean harBetalt) {
        this.navn = navn;
        this.cpr = cpr;
        this.MEDLEMSSTATUS = MEDLEMSSTATUS;
        this.aktivitetsForm = aktivitetsForm;
        this.harBetalt = harBetalt;
    }


    //________________________GETTERE & SETTERE_________________________________________________________________________
    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    //cpr skal være specifik 6 cifre ellers exception
    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

  public MedlemsStatus getMedlemsstatus(){
        return MEDLEMSSTATUS;
  }

  public void setMedlemsstatus(MedlemsStatus MEDLEMSSTATUS){
        this.MEDLEMSSTATUS = MEDLEMSSTATUS;
  }


    public AldersGruppe getAldersGruppe() {
        int alder = this.cprOmregning();
        if (alder < 18) {
            setAldersGruppe(AldersGruppe.JUNIOR);
        } else {
            setAldersGruppe(AldersGruppe.SENIOR);
        }

        return ALDERSGRUPPE;
  }

  public void setAldersGruppe(AldersGruppe ALDERSGRUPPE){
        this.ALDERSGRUPPE = ALDERSGRUPPE;
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

    public boolean getHarBetalt(){
        return harBetalt;
    }

    public void setHarBetalt(boolean harBetalt){
        this.harBetalt = harBetalt;
    }
    //__________________________________________________________________________________________________________________


    //________________________metode til omregning af CPR til alder_____________________________________________________
    public int cprOmregning() {
        LocalDate nu = LocalDate.now();
        String cpr = this.getCpr();
        int dag = Integer.parseInt(cpr.substring(0, 2));
        int måned = Integer.parseInt(cpr.substring(2, 4));
        int år = Integer.parseInt(cpr.substring(4, 6));
        if (år >= 0 && år <= LocalDate.now().getYear() % 100) { //TODO: kommentar til %
            år += 2000;
        } else {
            år += 1900;
        }
        LocalDate fødselsdato = LocalDate.of(år, måned, dag);
        int alder = Period.between(fødselsdato, nu).getYears();
        return alder;
    }


    //___________________metode til at se hvad det enkelte medlem skal betale i kontingent______________________________
    public int kontingent() {
        int kontingent = 0;
        int alder = this.cprOmregning();

        if (getMedlemsstatus().equals(MedlemsStatus.AKTIV)) {
            if (getAldersGruppe().equals(AldersGruppe.JUNIOR)) {
                kontingent = 1000;
            } else if (getAldersGruppe().equals(AldersGruppe.SENIOR)) {
                if (alder > 60) {
                    int rabat = 1600 * 25 / 100;
                    kontingent = 1600 - rabat;
                } else {
                    kontingent = 1600;
                }
            }
        } else if (getMedlemsstatus().equals(MedlemsStatus.PASSIV)) {
            kontingent = 500;
        }

        return kontingent;
    }


    //________________________toString metode, som udskriver et medlem til userinterfacet_______________________________
    @Override
    public String toString() {
        return "Navn: " + getNavn() +
                ", CPR(alder): " + getCpr() +"(" + cprOmregning() + " år)" +
                ", Aldersgruppe: " + getAldersGruppe() +
                ", Aktivitets status: " + (MEDLEMSSTATUS == MedlemsStatus.AKTIV ? "Aktiv" : "Passiv") +
                ", Aktivitetsform: " + getAktivitetsForm() +
                ", Betalingsstatus: " + (this.getHarBetalt() ? "Betalt" : "Ikke betalt");
    }


    //________________________toString metode, som skriver til fil______________________________________________________
    public String toStringTilFil() {
        return this.navn + ";" +
                this.cpr + ";" +
                this.getAldersGruppe() + ";" +
                (this.MEDLEMSSTATUS == MedlemsStatus.AKTIV ? "Aktiv" : "Passiv") + ";" +
                this.getAktivitetsForm() + ";" +
                this.getHarBetalt();
    }
}





