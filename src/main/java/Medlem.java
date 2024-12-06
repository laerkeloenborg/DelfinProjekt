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
    public Medlem(String navn, String cpr, MedlemsStatus MEDLEMSSTATUS, boolean harBetalt, String aktivitetsForm) {
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

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public MedlemsStatus getMedlemsstatus() {
        return MEDLEMSSTATUS;
    }

    public void setMedlemsstatus(MedlemsStatus MEDLEMSSTATUS) {
        this.MEDLEMSSTATUS = MEDLEMSSTATUS;
    }


    public AldersGruppe getAldersGruppe() {
        int alder = this.cprOmregningTilAlder();
        if (alder < 18) {
            setAldersGruppe(AldersGruppe.JUNIOR);
        } else {
            setAldersGruppe(AldersGruppe.SENIOR);
        }

        return ALDERSGRUPPE;
    }

    public void setAldersGruppe(AldersGruppe ALDERSGRUPPE) {
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

    public boolean getHarBetalt() {
        return harBetalt;
    }

    public void setHarBetalt(boolean harBetalt) {
        this.harBetalt = harBetalt;
    }
    //__________________________________________________________________________________________________________________

    //________________________metode til omregning af CPR til alder_____________________________________________________
    public int cprOmregningTilAlder() {
        LocalDate nu = LocalDate.now();
        String cpr = this.getCpr();
        int dag = Integer.parseInt(cpr.substring(0, 2));
        int måned = Integer.parseInt(cpr.substring(2, 4));
        int år = Integer.parseInt(cpr.substring(4, 6));
        if (år >= 0 && år <= LocalDate.now().getYear() % 100) { // ved % får vi resten efter en heltalsdivision med 100. dvs. at vi får 24 ved nuværende år.
            år += 2000; //hvis år er større end eller ligmed 0 og mindre end 24 sætter mand 20 foran de sidste to cifre i sit cpr.
        } else {
            år += 1900;//og 19 foran de sidste to hvis år er større end 24.
        }
        LocalDate fødselsdato = LocalDate.of(år, måned, dag);
        int alder = Period.between(fødselsdato, nu).getYears();
        return alder;

    }


    //___________________metode til at se hvad det enkelte medlem skal betale i kontingent______________________________
    public int kontingent() {
        int kontingent = 0;
        int alder = this.cprOmregningTilAlder();

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
                ", CPR: " + getCpr() + "(" + cprOmregningTilAlder() + " år)" +
                ", Aldersgruppe: " + getAldersGruppe() +
                ", Aktivitets status: " + (MEDLEMSSTATUS == MedlemsStatus.AKTIV ? "Aktiv" : "Passiv") +
                ", Betalingsstatus: " + (this.getHarBetalt() ? "Betalt" : "Ikke betalt") +
                ", Aktivitetsform: " + getAktivitetsForm() + "\n";
    }


    //________________________toString metode, som skriver til fil______________________________________________________
    public String toStringTilFil() {
        return this.navn + ";" +
                this.cpr + ";" +
                this.getAldersGruppe() + ";" +
                (this.MEDLEMSSTATUS == MedlemsStatus.AKTIV ? "Aktiv" : "Passiv") + ";" +
                this.getHarBetalt() + ";" +
                this.getAktivitetsForm();
    }

}






