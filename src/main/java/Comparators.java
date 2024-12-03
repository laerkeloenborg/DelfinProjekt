import java.util.Comparator;

public class Comparators {

    //________________________comparator til sortering efter navn - medlemsliste_______________________________________________________
    public static class sorteringNavn implements Comparator<Medlem> {
        public int compare(Medlem m1, Medlem m2) {
            return m1.getNavn().compareToIgnoreCase(m2.getNavn());
        }
    }



    //________________________comparator til sortering efter medlems status - medlemsliste_____________________________________________
    public static class sorteringMedlemsstatus implements Comparator<Medlem> {
        public int compare(Medlem m1, Medlem m2) {
            return m1.getMedlemsstatus().compareTo(m2.getMedlemsstatus());
        }
    }


    //________________________comparator til sortering efter aldersgruppe - medlemsliste_______________________________________________
    public static class sorteringAldersgruppe implements Comparator<Medlem> {
        public int compare(Medlem m1, Medlem m2) {
            return m1.getAldersGruppe().compareTo(m2.getAldersGruppe());
        }
    }


    //________________________comparator til sortering efter aktivitetsform - medlemsliste_____________________________________________
    public static class sorteringAktivitetsform implements Comparator<Medlem> {
        public int compare(Medlem m1, Medlem m2) {
            return m1.getAktivitetsForm().compareToIgnoreCase(m2.getAktivitetsForm());
        }
    }

    //_______________________comparator til sortering af svømmedisciplin - konkurrencesvømmer__________________________________________
    public static class sorteringSvømmedisciplin implements Comparator<KonkurrenceSvømmer> {
        public int compare(KonkurrenceSvømmer k1, KonkurrenceSvømmer k2){
            return k1.getSVØMMEDISCIPLIN().compareTo(k2.getSVØMMEDISCIPLIN());
        }
    }

    //______________________comparator til sortering af svømmetider - konkurrencesvømmer_______________________________________________
    public static class sorteringSvømmetider implements Comparator<KonkurrenceSvømmer>{
        public int compare(KonkurrenceSvømmer k1, KonkurrenceSvømmer k2){
            return Double.compare(k1.getBedsteTid(),k2.getBedsteTid());
        }
    }

    //____________________comparator til sortering af konkurrence status - konkurrencesvømmer_________________________________________
    public static  class sorteringKonkurrencestatus implements Comparator<KonkurrenceSvømmer>{
        public int compare(KonkurrenceSvømmer k1, KonkurrenceSvømmer k2){
            return Boolean.compare(k1.getHarKonkurreret(), k2.getHarKonkurreret());
        }
    }



}
