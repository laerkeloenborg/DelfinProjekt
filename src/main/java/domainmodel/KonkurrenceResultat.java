package domainmodel;

import java.time.LocalDate;

public class KonkurrenceResultat {
    private String stævne;
    private int placering;
    private double tid;
    private LocalDate dato;

    public KonkurrenceResultat(String stævne, int placering, double tid, LocalDate dato) {
        this.stævne = stævne;
        this.placering = placering;
        this.tid = tid;
        this.dato = dato;
    }

    public String getStævne() {
        return stævne;
    }

    public int getPlacering() {
        return placering;
    }

    public double getTid() {
        return tid;
    }

    public LocalDate getDato() {
        return dato;
    }

    @Override
    public String toString() {
        return "Stævne: " + stævne + ", Placering: " + placering + ", Tid: " + tid + ", Dato:" + dato;
    }
}