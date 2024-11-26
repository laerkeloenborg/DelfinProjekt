import java.util.ArrayList;

public class Kasserer {
    private FileHandler fileHandler;
    private ArrayList<Medlem> medlemsListe;

    public Kasserer() {
        fileHandler = new FileHandler();
        medlemsListe = fileHandler.hentListeAfMedlemmer();
    }

    //TODO: Metode til at finde samlede beløb af alle medlemmernes kontigent
    public int forventetKontigentIndkomst() {
        int samletKontigent = 0;

        if (medlemsListe.isEmpty()) {
            return 0;
        }

        for (Medlem medlem : medlemsListe) {
            if(medlem.getHarBetalt()){
                int medlemsKontigent = medlem.kontigent();
                samletKontigent += medlemsKontigent;
            }
        }
        return samletKontigent;
    }

    //TODO: Metode til at finde samlede beløb af ikke betalte kontigenter
    public int restanceKontingent() {
        int restance = 0;
        if (medlemsListe.isEmpty()) {
            return 0;
        }

        for (Medlem medlem : medlemsListe) {
            if (!medlem.getHarBetalt()) {
                int medlemsKontigent = medlem.kontigent();
                restance += medlemsKontigent;
            }
        }
        return restance;


        //TODO: Metode til at få vist om et medlem har betalt eller ikke betalt
        //TODO: se en liste over medlemmer men uden de unødvendige emner, hvis passiv står der bare navn og passiv
//        public void hentTilKasserer() {
//            fileHandler.hentListeAfMedlemmer();
//

    }




}
