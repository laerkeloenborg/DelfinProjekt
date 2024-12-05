public class KonkurrenceSvømmer extends Medlem {
    private SvømmeDiscipliner SVØMMEDISCIPLIN;
    private double bedsteTid;
    private boolean harKonkurreret;

    public KonkurrenceSvømmer(String navn, String cpr, MedlemsStatus MEDLEMSSTATUS, boolean harBetalt, String aktivitetsForm) {
        super(navn, cpr, MEDLEMSSTATUS, harBetalt, aktivitetsForm);
    }

    public KonkurrenceSvømmer(String navn, String cpr, MedlemsStatus MEDLEMSSTATUS, boolean harBetalt, String aktivitetsForm, SvømmeDiscipliner SVØMMEDISCIPLIN, double bedsteTid, boolean harKonkurreret) {
        super(navn, cpr, MEDLEMSSTATUS, harBetalt, aktivitetsForm);
        this.SVØMMEDISCIPLIN = SVØMMEDISCIPLIN;
        this.bedsteTid = bedsteTid;
        this.harKonkurreret = harKonkurreret;
    }

    //_____________________________________________ Getter & Setter ____________________________________________________
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


    public String toStringTilTræner() {
        return "Navn: " + this.getNavn() +
                ", Aldersgruppe: " + this.getAldersGruppe() +
                ", Aktivitets status: " + (this.getMedlemsstatus() == MedlemsStatus.AKTIV ? "Aktiv" : "Passiv") +
                ", Svømme Disciplin: " + getSVØMMEDISCIPLIN() +
                ", Bedstetid: " + getBedsteTid() +
                ", Har Konkurreret: " + (getHarKonkurreret() ? "ja" : "nej") + "\n";
    }

    @Override
    public String toString() {
        return "Navn: " + getNavn() +
                ", CPR: " + getCpr() + "(" + cprOmregningTilAlder() + " år)" +
                ", Aldersgruppe: " + getAldersGruppe() +
                ", Aktivitets status: " + (getMedlemsstatus() == MedlemsStatus.AKTIV ? "Aktiv" : "Passiv") +
                ", Betalingsstatus: " + (this.getHarBetalt() ? "Betalt" : "Ikke betalt") +
                ", Aktivitetsform: " + getAktivitetsForm();
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

}
