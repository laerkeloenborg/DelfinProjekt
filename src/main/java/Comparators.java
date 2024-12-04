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
    public static class sorteringSvømmedisciplin implements Comparator<Medlem> {
        public int compare(Medlem k1, Medlem k2){
            return ((KonkurrenceSvømmer)k1).getSVØMMEDISCIPLIN().compareTo(((KonkurrenceSvømmer)k2).getSVØMMEDISCIPLIN());
        }
    }

    //______________________comparator til sortering af svømmetider - konkurrencesvømmer_______________________________________________
    public static class sorteringSvømmetider implements Comparator<Medlem>{
        public int compare(Medlem k1, Medlem k2){
            return Double.compare(((KonkurrenceSvømmer)k1).getBedsteTid(),((KonkurrenceSvømmer)k2).getBedsteTid());
        }
    }

    //____________________comparator til sortering af konkurrence status - konkurrencesvømmer_________________________________________
    public static  class sorteringKonkurrencestatus implements Comparator<Medlem>{
        public int compare(Medlem k1, Medlem k2){
            return Boolean.compare(((KonkurrenceSvømmer)k1).getHarKonkurreret(), ((KonkurrenceSvømmer)k2).getHarKonkurreret());
        }
    }




}
