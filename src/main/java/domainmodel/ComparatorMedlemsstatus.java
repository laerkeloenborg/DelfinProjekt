package domainmodel;

import java.util.Comparator;

public class ComparatorMedlemsstatus implements Comparator<Medlem> {
    public int compare(Medlem m1, Medlem m2) {
        return m1.getMedlemsstatus().compareTo(m2.getMedlemsstatus());
    }
}
