package domainmodel;

import java.util.Comparator;

public class ComparatorKonkurrenceStatus implements Comparator<Medlem> {
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
