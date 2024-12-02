public class KonkurrenceSvømmer extends Medlem{
    SvømmeDiscipliner SVØMMEDISCIPLIN;

    public KonkurrenceSvømmer(String navn, String cpr, MedlemsStatus MEDLEMSSTATUS, String aktivitetsForm, boolean harBetalt){
        super(navn, cpr, MEDLEMSSTATUS,aktivitetsForm, harBetalt);
    }

    public KonkurrenceSvømmer(String navn, String cpr, MedlemsStatus MEDLEMSSTATUS, String aktivitetsForm, boolean harBetalt, SvømmeDiscipliner SVØMMEDISCIPLIN){
       super(navn, cpr, MEDLEMSSTATUS, aktivitetsForm, harBetalt);
       this.SVØMMEDISCIPLIN = SVØMMEDISCIPLIN;
    }


}
