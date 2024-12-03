public class KonkurrenceSvømmer extends Medlem{
    private SvømmeDiscipliner SVØMMEDISCIPLIN;
    private double bedsteTid;
    private boolean harKonkurreret;

    public KonkurrenceSvømmer(String navn, String cpr, MedlemsStatus MEDLEMSSTATUS, String aktivitetsForm, boolean harBetalt){
        super(navn, cpr, MEDLEMSSTATUS,aktivitetsForm, harBetalt);
    }

    public KonkurrenceSvømmer(String navn, String cpr, MedlemsStatus MEDLEMSSTATUS, String aktivitetsForm, boolean harBetalt, SvømmeDiscipliner SVØMMEDISCIPLIN, double bedsteTid, boolean harKonkurreret){
       super(navn, cpr, MEDLEMSSTATUS, aktivitetsForm, harBetalt);
       this.SVØMMEDISCIPLIN = SVØMMEDISCIPLIN;
       this.bedsteTid = bedsteTid;
       this.harKonkurreret = harKonkurreret;
    }

    //_____________________________________________ Getter & Setter ____________________________________________________
    public SvømmeDiscipliner getSVØMMEDISCIPLIN(){
        return SVØMMEDISCIPLIN;
    }

    public void setSVØMMEDISCIPLIN(SvømmeDiscipliner SVØMMEDISCIPLIN){
        this.SVØMMEDISCIPLIN = SVØMMEDISCIPLIN;
    }

    public double getBedsteTid(){
        return bedsteTid;
    }

    public void setBedsteTid(double bedsteTid){
        this.bedsteTid = bedsteTid;
    }

    public boolean getHarKonkurreret(){
        return harKonkurreret;
    }

    public void setHarKonkurreret(boolean harKonkurreret){
        this.harKonkurreret = harKonkurreret;
    }

    //__________________________________________________________________________________________________________________


    public String toStringTilFil() {
        return this.getNavn() + ";" +
                this.getCpr() + ";" +
                this.getAldersGruppe() + ";" +
                (this.getMedlemsstatus() == MedlemsStatus.AKTIV ? "Aktiv" : "Passiv") + ";" +
                this.getHarBetalt()+ ";" +
                this.getAktivitetsForm() + ";" +
                this.getSVØMMEDISCIPLIN() + ";" +
                this.getBedsteTid() + ";" +
                (this.getHarKonkurreret() ? "har konkurreret" : "har ikke konkurreret");
    }

}
