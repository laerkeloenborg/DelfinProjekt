package domainmodel;

import java.util.Comparator;

public class ComparatorAldersgruppe implements Comparator<Medlem> {
    public int compare(Medlem m1, Medlem m2) {
        return m1.getAldersGruppe().compareTo(m2.getAldersGruppe());
    }
}
