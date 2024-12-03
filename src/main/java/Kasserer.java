import java.util.ArrayList;

public class Kasserer {
    private FileHandler fileHandler;
    private ArrayList<Medlem> medlemsListe;

    //___________________________konstruktør____________________________________________________________________________
    public Kasserer() {
        fileHandler = new FileHandler();
        medlemsListe = fileHandler.hentListeAfMedlemmer();
    }

    //___________________________metode til at finde samlet beløb af betalte kontingenter_______________________________
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

    //___________________________metode til at finde det samlede forventede kontingent til klubben______________________
    public int samletForventetKontingent() {
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

    //___________________________metode til at se medlemmer som har betalt kontingent___________________________________
    public String medlemmerDerHarBetalt() {
        String udskriv = " ";
        int counter = 1;
        for (Medlem medlem : medlemsListe) {
            if (medlem.getHarBetalt()) {
                udskriv += counter++ + ". " + medlem.getNavn() + ", " + medlem.getCpr() + "(" + medlem.cprOmregningTilAlder() +
                        " år), " + medlem.getMedlemsstatus() + ", " + medlem.kontingent() + "kr. \n ";
            }
        }
        return udskriv.isEmpty() ? "ingen medlemmer har betalt" : udskriv;
    }


    //___________________________metode til at finde samlet beløb af ikke betalte kontingenter__________________________
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


    //___________________________metode til at se alle medlemmer der er i restance______________________________________
    public String medlemmerIRestance() {
        String udskriv = " ";
        int tæller = 1;
        for (Medlem medlem : medlemsListe) {
            if (!medlem.getHarBetalt()) {
                udskriv += tæller++ + ". " + medlem.getNavn() + ", " + medlem.getCpr() + "(" + medlem.cprOmregningTilAlder() +
                        " år), " + medlem.getMedlemsstatus() + ", -" + medlem.kontingent() + " kr.\n ";
            }
        }
        return udskriv.isEmpty() ? "ingen medlemmer i restance" : udskriv;
    }


}
