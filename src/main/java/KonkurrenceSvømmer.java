import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class KonkurrenceSvømmer extends Medlem {
    private SvømmeDiscipliner SVØMMEDISCIPLIN;
    private double bedsteTid;
    private boolean harKonkurreret;
    private ArrayList<String> stævner;
    private ArrayList<KonkurrenceResultat> konkurrenceresultater;

    public KonkurrenceSvømmer(String navn, String cpr, MedlemsStatus MEDLEMSSTATUS, boolean harBetalt, String aktivitetsForm) {
        super(navn, cpr, MEDLEMSSTATUS, harBetalt, aktivitetsForm);
    }

    public KonkurrenceSvømmer(String navn, String cpr, MedlemsStatus MEDLEMSSTATUS, boolean harBetalt, String aktivitetsForm, SvømmeDiscipliner SVØMMEDISCIPLIN, double bedsteTid, boolean harKonkurreret) {
        super(navn, cpr, MEDLEMSSTATUS, harBetalt, aktivitetsForm);
        this.SVØMMEDISCIPLIN = SVØMMEDISCIPLIN;
        this.bedsteTid = bedsteTid;
        this.harKonkurreret = harKonkurreret;
        this.stævner = new ArrayList<>();
        this.konkurrenceresultater = new ArrayList<>();
    }


    //_____________________________________________ Getter & Setter ____________________________________________________
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
    public void tilføjKonkurrenceresultatNY(KonkurrenceResultat resultat) {
        this.konkurrenceresultater.add(resultat);
    }

    public ArrayList<KonkurrenceResultat> getKonkurrenceResultaterNY() {
        return this.konkurrenceresultater;
    }

    public void tilføjKonkurrenceresultat(String stævne, int placering, double tid, LocalDate dato) {
        try {
            // Hvis datoen allerede er et LocalDate, så formater den direkte til en String
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String datoStr = dato.format(formatter);  // Konverterer LocalDate til String i formatet yyyy-MM-dd

            // Opret en streng, der repræsenterer resultatet med dato
            String resultat = "Stævne: " + stævne + ", Placering: " + placering + ", Tid: " + tid + ", Dato: " + datoStr;

            // Tjek om resultatet allerede findes i listen
            if (!this.stævner.contains(resultat)) {
                // Hvis resultatet ikke findes, tilføj det
                this.stævner.add(resultat);
            }
        } catch (Exception e) {
            // Håndter eventuelle fejl, der kan opstå, selvom datoen er i LocalDate format
            System.out.println("Fejl ved behandling af resultat: " + e.getMessage());
        }
    }





    @Override
    public String toString() {
        // Grundlæggende oplysninger om svømmeren
        String result = "Navn: " + this.getNavn() +
                ", Aldersgruppe: " + this.getAldersGruppe() +
                ", Aktivitets status: " + (this.getMedlemsstatus() == MedlemsStatus.AKTIV ? "Aktiv" : "Passiv") +
                ", Svømme Disciplin: " + getSVØMMEDISCIPLIN() +
                ", Bedste tid: " + getBedsteTid() +
                ", Har Konkurreret: " + (getHarKonkurreret() ? "ja" : "nej");

        // Hvis der er konkurrenceresultater, tilføj dem til udskriften
        if (!this.stævner.isEmpty()) {
            result += "\nKonkurrenceresultater:";
            for (String resultat : this.stævner) {
                result += "\nStævne: " + resultat.split(",")[0] + // For at få stævnet navnet korrekt
                        ", Placering: " + resultat.split(",")[1] + // For placeringen
                        ", Tid: " + resultat.split(",")[2]; // For tiden
            }
        }

        return result;
   }

    public String toStringTilFormand() {
        return "Navn: " + getNavn() +
                ", CPR: " + getCpr() + "(" + cprOmregningTilAlder() + " år)" +
                ", Aldersgruppe: " + getAldersGruppe() +
                ", Aktivitets status: " + (getMedlemsstatus() == MedlemsStatus.AKTIV ? "Aktiv" : "Passiv") +
                ", Betalingsstatus: " + (this.getHarBetalt() ? "Betalt" : "Ikke betalt") +
                ", Aktivitetsform: " + getAktivitetsForm() + "\n";
    }

    public String toStringTilFil() {
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
                String[] splitResultat = resultatElement.split(", ");
                String stævne = splitResultat[0].split(": ")[1];
                String placering = splitResultat[1].split(": ")[1];
                String tid = splitResultat[2].split(": ")[1];
                String dato = splitResultat[3].split(": ")[1];

                // Tilføj stævne, placering og tid i CSV-format
                resultat += ";" + stævne + ";" + placering + ";" + tid + ";" + dato;
            }
        }

        return resultat;
    }

    public String toStringStævne() {
        StringBuilder sb = new StringBuilder();

        // Formatér svømmerens hovedinformation på én linje
        sb.append(this.getNavn()).append(". ");
        sb.append("Navn: ").append(this.getNavn()).append(", ");
        sb.append("Aldersgruppe: ").append(this.getMedlemsstatus()).append(", ");
        sb.append("Aktivitets status: ").append(this.getMedlemsstatus()).append(", ");
        sb.append("Svømme Disciplin: ").append(this.getSVØMMEDISCIPLIN()).append(", ");
        sb.append("Bedste tid: ").append(this.getBedsteTid()).append(", ");
        sb.append("Har Konkurreret: ").append(this.getHarKonkurreret() ? "ja" : "nej").append("\n");

        // Formatér konkurrenceresultater
        sb.append("Konkurrenceresultater:\n");

        // Tjek om konkurrenceresultater eksisterer
        if (this.konkurrenceresultater.isEmpty()) {
            sb.append("Ingen konkurrenceresultater registreret.");
        } else {
            for (KonkurrenceResultat resultat : this.konkurrenceresultater) {
                sb.append("Stævne: ").append(resultat.getStævne()).append(", ");
                sb.append("Placering: ").append(resultat.getPlacering()).append(", ");
                sb.append("Tid: ").append(resultat.getTid()).append("\n");
                sb.append("Dato: ").append(resultat.getDato()).append("\n");
            }
        }

        return sb.toString();
    }

}
