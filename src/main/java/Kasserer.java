import java.util.ArrayList;

public class Kasserer {
    private FileHandler fileHandler;
    private ArrayList<Medlem> medlemsListe;

    public Kasserer() {
        fileHandler = new FileHandler();
        medlemsListe = fileHandler.hentListeAfMedlemmer();
    }

    //TODO: Metode til at finde samlede beløb af alle medlemmernes kontigent
    public int indbetaltKontingentForNu() {
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

    public int samletForventetKontingent(){
        int allesSamledeKontingent = 0;
        int allesSamledeKontingent2 = 0;

        if (medlemsListe.isEmpty()) {
            return 0;
        }

        for (Medlem medlem : medlemsListe) {
            if (medlem.getHarBetalt()) {
                int medlemmersKontingent = medlem.kontingent();
                allesSamledeKontingent += medlemmersKontingent;
            } else if (!medlem.getHarBetalt()) {
                int medlemmersKokntingentIkkeBetalt = medlem.kontingent();
                allesSamledeKontingent2 += medlemmersKokntingentIkkeBetalt;
            }
        }
        return allesSamledeKontingent + allesSamledeKontingent2;
    }

    public String medlemmerDerHarBetalt(){
        String udskriv = " ";
        int counter = 1;
        for (Medlem medlem : medlemsListe) {
            if (medlem.getHarBetalt()) {
                udskriv += counter++ + ". " + medlem.getNavn() + ", " + medlem.getCpr() + ", " + medlem.kontingent() + "\n ";
            }
        }
        return udskriv.isEmpty() ? "ingen medlemmer har betalt" : udskriv;
    }


    // Metode til at finde samlede beløb af ikke betalte kontigenter
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



    public String medlemmerIRestance() {
        String udskriv = " ";
        int counter = 1;
        for (Medlem medlem : medlemsListe) {
            if (!medlem.getHarBetalt()) {
                udskriv += counter++ + ". " + medlem.getNavn() + ", " + medlem.getCpr() + ", -" + medlem.kontingent() + "\n ";
            }
        }
        return udskriv.isEmpty() ? "ingen medlemmer i restnace" : udskriv;
    }


    //TODO: indsæt kontigent
//    public String hentTilKasserer() {
//        String udskriv = "";
//        for (Medlem medlem : medlemsListe) {
//            udskriv = medlem.getNavn() + ", " +
//                    medlem.cprOmregning() + "år," +
//                    medlem.getHarBetalt();
//        }
//        return udskriv;
//    }


}
