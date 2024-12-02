public class KonkurrenceSvømmer extends Medlem{
    private SvømmeDiscipliner SVØMMEDISCIPLIN;
    private double bedsteTid;

    public KonkurrenceSvømmer(String navn, String cpr, MedlemsStatus MEDLEMSSTATUS, String aktivitetsForm, boolean harBetalt){
        super(navn, cpr, MEDLEMSSTATUS,aktivitetsForm, harBetalt);
    }

    public KonkurrenceSvømmer(String navn, String cpr, MedlemsStatus MEDLEMSSTATUS, String aktivitetsForm, boolean harBetalt, SvømmeDiscipliner SVØMMEDISCIPLIN, double bedsteTid){
       super(navn, cpr, MEDLEMSSTATUS, aktivitetsForm, harBetalt);
       this.SVØMMEDISCIPLIN = SVØMMEDISCIPLIN;
       this.bedsteTid = bedsteTid;
    }

    //_____________________________________________ Getter & Setter ____________________________________________________
    public SvømmeDiscipliner getSVØMMEDISCIPLIN(){
        return SVØMMEDISCIPLIN;
    }

    public double getBedsteTid(){
        return bedsteTid;
    }

    public void setBedsteTid(double bedsteTid){
        this.bedsteTid = bedsteTid;
    }

    //__________________________________________________________________________________________________________________


}
