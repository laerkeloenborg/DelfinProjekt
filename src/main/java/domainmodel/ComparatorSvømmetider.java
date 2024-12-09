package domainmodel;

import java.util.Comparator;

public class ComparatorSvømmetider implements Comparator<Medlem> {
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
