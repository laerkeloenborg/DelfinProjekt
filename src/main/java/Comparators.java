import java.util.Comparator;

public class Comparators {

    public static class sorteringNavn implements Comparator<Medlem> {
        public int compare(Medlem m1, Medlem m2) {
            return m1.getNavn().compareToIgnoreCase(m2.getNavn());
        }
    }

    public static class sorteringAlder implements Comparator<Medlem> {
        public int compare(Medlem m1, Medlem m2) {
            return Integer.compare(m1.cprOmregning(), m2.cprOmregning());
        }
    }

    public static class sorteringMedlemsstatus implements Comparator<Medlem> {
        public int compare(Medlem m1, Medlem m2) {
            return m1.getMedlemsstatus().compareTo(m2.getMedlemsstatus());
        }
    }

    public static class sorteringAldersgruppe implements Comparator<Medlem> {
        public int compare(Medlem m1, Medlem m2) {
            return m1.getALDERSGRUPPE().compareTo(m2.getALDERSGRUPPE());
        }
    }

    public static class sorteringAktivitetsform implements Comparator<Medlem> {
        public int compare(Medlem m1, Medlem m2) {
            return m1.getAktivitetsForm().compareToIgnoreCase(m2.getAktivitetsForm());
        }
    }
}
