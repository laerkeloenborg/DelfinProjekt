package domainmodel;

import java.util.Comparator;

public class ComparatorNavn implements Comparator<Medlem>{
    //________________________comparator til sortering efter navn - medlemsliste_______________________________________________________
        public int compare(Medlem m1, Medlem m2) {
            return m1.getNavn().compareToIgnoreCase(m2.getNavn());
        }

}
