package domainmodel;

import java.util.Comparator;

public class ComparatorAktivitetsform implements Comparator<Medlem> {
    public int compare(Medlem m1, Medlem m2) {
        return m1.getAktivitetsForm().compareToIgnoreCase(m2.getAktivitetsForm());
    }
}
