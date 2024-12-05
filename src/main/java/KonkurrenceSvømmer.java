import java.util.ArrayList;

public class KonkurrenceSvømmer extends Medlem {
    private SvømmeDiscipliner SVØMMEDISCIPLIN;
    private double bedsteTid;
    private boolean harKonkurreret;
    private ArrayList<String> stævner;

    public KonkurrenceSvømmer(String navn, String cpr, MedlemsStatus MEDLEMSSTATUS, boolean harBetalt, String aktivitetsForm) {
        super(navn, cpr, MEDLEMSSTATUS, harBetalt, aktivitetsForm);
    }

    public KonkurrenceSvømmer(String navn, String cpr, MedlemsStatus MEDLEMSSTATUS, boolean harBetalt, String aktivitetsForm, SvømmeDiscipliner SVØMMEDISCIPLIN, double bedsteTid, boolean harKonkurreret) {
        super(navn, cpr, MEDLEMSSTATUS, harBetalt, aktivitetsForm);
        this.SVØMMEDISCIPLIN = SVØMMEDISCIPLIN;
        this.bedsteTid = bedsteTid;
        this.harKonkurreret = harKonkurreret;
        this.stævner = new ArrayList<>();
    }

    //_____________________________________________ Getter & Setter ____________________________________________________
    // Metode til at tilføje stævne til listen
    public void tilføjStævne(String stævne, int placering, double tid) {
        // Her tilføjes kun stævnenavnet som en string
        this.stævner.add(stævne);
    }

    public ArrayList<String> getStævner() {
        return this.stævner;
    }

    public void tilføjKonkurrenceresultat(String stævne, int placering, double tid) {
        String resultat = "Stævne: " + stævne + ", Placering: " + placering + ", Tid: " + tid;
        this.stævner.add(resultat);
    }

    // Getter til at hente listen af resultater
    public ArrayList<String> getKonkurrenceResultater() {
        return stævner;
    }

    public SvømmeDiscipliner getSVØMMEDISCIPLIN() {
        return SVØMMEDISCIPLIN;
    }

    public void setSVØMMEDISCIPLIN(SvømmeDiscipliner SVØMMEDISCIPLIN) {
        this.SVØMMEDISCIPLIN = SVØMMEDISCIPLIN;
    }

    public double getBedsteTid() {
        return bedsteTid;
    }

    public void setBedsteTid(double bedsteTid) {
        this.bedsteTid = bedsteTid;
    }

    public boolean getHarKonkurreret() {
        return harKonkurreret;
    }

    public void setHarKonkurreret(boolean harKonkurreret) {
        this.harKonkurreret = harKonkurreret;
    }

    //__________________________________________________________________________________________________________________

    @Override
    public String toString() {
        // Grundlæggende oplysninger om svømmeren
        String result = "Navn: " + this.getNavn() +
                ", Aldersgruppe: " + this.getAldersGruppe() +
                ", Aktivitets status: " + (this.getMedlemsstatus() == MedlemsStatus.AKTIV ? "Aktiv" : "Passiv") +
                ", Svømme Disciplin: " + getSVØMMEDISCIPLIN() +
                ", Bedstetid: " + getBedsteTid() +
                ", Har Konkurreret: " + (getHarKonkurreret() ? "ja" : "nej");

        // Hvis der er konkurrenceresultater, tilføj dem til udskriften
        if (!this.stævner.isEmpty()) {
            result += "\nKonkurrenceresultater:";
            for (String resultat : this.stævner) {
                result += "\n" + resultat;
            }
        }

        return result;
    }


    public String toStringTilFil() {
        return this.getNavn() + ";" +
                this.getCpr() + ";" +
                this.getAldersGruppe() + ";" +
                (this.getMedlemsstatus() == MedlemsStatus.AKTIV ? "Aktiv" : "Passiv") + ";" +
                this.getHarBetalt() + ";" +
                this.getAktivitetsForm() + ";" +
                SvømmeDiscipliner.ToString(this.getSVØMMEDISCIPLIN()) + ";" +
                this.getBedsteTid() + ";" +
                this.getHarKonkurreret();
    }

    public String toStringTilKonkurrenceFil() {
        // Start med de eksisterende attributter
        String resultat = this.getNavn() + ";" +
                this.getCpr() + ";" +
                this.getAldersGruppe() + ";" +
                (this.getMedlemsstatus() == MedlemsStatus.AKTIV ? "Aktiv" : "Passiv") + ";" +
                this.getHarBetalt() + ";" +
                this.getAktivitetsForm() + ";" +
                SvømmeDiscipliner.ToString(this.getSVØMMEDISCIPLIN()) + ";" +
                this.getBedsteTid() + ";" +
                this.getHarKonkurreret();

        // Hent konkurrenceresultaterne
        ArrayList<String> konkurrenceresultater = this.getKonkurrenceResultater();

        if (konkurrenceresultater != null && !konkurrenceresultater.isEmpty()) {
            for (String resultatElement : konkurrenceresultater) {
                // For hver konkurrenceresultat tilføj det til CSV-strengen
                // Fjern "Stævne: ", "Placering: " og "Tid: " så vi kun har relevante data
                String[] splitResultat = resultatElement.split(", ");
                String stævne = splitResultat[0].split(": ")[1];
                String placering = splitResultat[1].split(": ")[1];
                String tid = splitResultat[2].split(": ")[1];

                // Tilføj stævne, placering og tid i CSV-format
                resultat += ";" + stævne + ";" + placering + ";" + tid;
            }
        }

        return resultat;
    }
}
