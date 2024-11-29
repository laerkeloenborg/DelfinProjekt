import java.util.Comparator;

public class Comparators {

    //________________________comparator til sortering efter navn_______________________________________________________
    public static class sorteringNavn implements Comparator<Medlem> {
        public int compare(Medlem m1, Medlem m2) {
            return m1.getNavn().compareToIgnoreCase(m2.getNavn());
        }
    }



    //________________________comparator til sortering efter medlems sattus_____________________________________________
    public static class sorteringMedlemsstatus implements Comparator<Medlem> {
        public int compare(Medlem m1, Medlem m2) {
            return m1.getMedlemsstatus().compareTo(m2.getMedlemsstatus());
        }
    }


    //________________________comparator til sortering efter aldersgruppe_______________________________________________
    public static class sorteringAldersgruppe implements Comparator<Medlem> {
        public int compare(Medlem m1, Medlem m2) {
            return m1.getAldersGruppe().compareTo(m2.getAldersGruppe());
        }
    }


    //________________________comparator til sortering efter aktivitetsform_____________________________________________
    public static class sorteringAktivitetsform implements Comparator<Medlem> {
        public int compare(Medlem m1, Medlem m2) {
            return m1.getAktivitetsForm().compareToIgnoreCase(m2.getAktivitetsForm());
        }
    }
}
