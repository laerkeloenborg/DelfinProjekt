package domainmodel;

import java.util.Comparator;

public class Comparators {

    //TODO: fjern static klasser
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

    public static class sorteringSvømDisciplin implements Comparator<Medlem> {
        public int compare(Medlem k1, Medlem k2) {
            if (k1 instanceof KonkurrenceSvømmer && k2 instanceof KonkurrenceSvømmer) {
                return Double.compare(((KonkurrenceSvømmer) k1).getBedsteTid(), ((KonkurrenceSvømmer) k2).getBedsteTid());
            } else if (k1 instanceof KonkurrenceSvømmer) {
                return 1;
            } else if (k2 instanceof KonkurrenceSvømmer) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    //______________________comparator til sortering af svømmetider - konkurrencesvømmer_______________________________________________

    public static class sorteringSvømmeTider implements Comparator<Medlem> {
        public int compare(Medlem k1, Medlem k2) {
            if (k1 instanceof KonkurrenceSvømmer && k2 instanceof KonkurrenceSvømmer) {
                return Double.compare(((KonkurrenceSvømmer) k1).getBedsteTid(), ((KonkurrenceSvømmer) k2).getBedsteTid());
            } else if (k1 instanceof KonkurrenceSvømmer) {
                return 1;
            } else if (k2 instanceof KonkurrenceSvømmer) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    //____________________comparator til sortering af konkurrence status - konkurrencesvømmer_________________________________________

    public static class sorteringKonkurrenceStatus implements Comparator<Medlem> {
        public int compare(Medlem k1, Medlem k2) {
            if (k1 instanceof KonkurrenceSvømmer && k2 instanceof KonkurrenceSvømmer) {
                return Boolean.compare(((KonkurrenceSvømmer) k1).getHarKonkurreret(), ((KonkurrenceSvømmer) k2).getHarKonkurreret());
            } else if (k1 instanceof KonkurrenceSvømmer) {
                return 1;
            } else if (k2 instanceof KonkurrenceSvømmer) {
                return -1;
            } else {
                return 0;
            }
        }


    }


}
