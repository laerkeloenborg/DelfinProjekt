import java.util.ArrayList;

public class Kasserer {
    private FileHandler fileHandler;
    private ArrayList<Medlem> medlemsListe;

    public Kasserer() {
        fileHandler = new FileHandler();
        medlemsListe = fileHandler.hentListeAfMedlemmer();
    }

    //TODO: Metode til at finde samlede beløb af alle medlemmernes kontigent
    public int forventetKontingentIndkomst() {
        int samletKontingent = 0;

        if (medlemsListe.isEmpty()) {
            return 0;
        }

        for (Medlem medlem : medlemsListe) {
            if (medlem.getHarBetalt()) {
                int medlemsKontingent = medlem.kontingent();
                samletKontingent += medlemsKontingent;
            }
        }
        return samletKontingent;
    }

    //TODO: Metode til at finde samlede beløb af ikke betalte kontigenter
    public int restanceKontingent() {
        int restance = 0;
        if (medlemsListe.isEmpty()) {
            return 0;
        }

        for (Medlem medlem : medlemsListe) {
            if (!medlem.getHarBetalt()) {
                int medlemsKontingent = medlem.kontingent();
                restance += medlemsKontingent;
            }
        }
        return restance;
    }


    //TODO: indsæt kontigent
    public String hentTilKasserer() {
        String udskriv = "";
        for (Medlem medlem : medlemsListe) {
            udskriv = medlem.getNavn() + ", " +
                    medlem.cprOmregning() + "år," +
                    medlem.getHarBetalt();
        }
        return udskriv;
    }


}
