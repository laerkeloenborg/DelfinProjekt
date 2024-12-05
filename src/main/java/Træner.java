import java.util.ArrayList;
import java.util.Collections;

public class Træner {

   private Listen listen;

    public Træner() {
       this.listen = new Listen();
    }


    public String ændringAfKonkurrenceSvømmer(Medlem konkurrenceSvømmer, int valg, String nyInfo) {
        switch (valg) {
            case 1:
                double nySvømmetid = Double.parseDouble(nyInfo);
                ((KonkurrenceSvømmer) konkurrenceSvømmer).setBedsteTid(nySvømmetid);
                break;
            case 2:
                Boolean nyKonkurrenceStatus = nyInfo.equalsIgnoreCase("ja");
                ((KonkurrenceSvømmer) konkurrenceSvømmer).setHarKonkurreret(nyKonkurrenceStatus);
                break;

            case 3:
                SvømmeDiscipliner nySvømmedisciplin = SvømmeDiscipliner.valueOf(nyInfo);
                ((KonkurrenceSvømmer) konkurrenceSvømmer).setSVØMMEDISCIPLIN(nySvømmedisciplin);
                break;
            default:
                return "Ugyldigt valg";
        }
        return "";
    }

    //________________________metode til at finde et specifikt medlems navn_____________________________________________
    public String findSpecifiktKonkurrenceSvømmersNavn(String info) {
        String medlemNavn = "";
        for (Medlem medlem : listen.getKonkurrenceSvømmer()) {
            if (medlem.getNavn().equalsIgnoreCase(info)) {
                medlemNavn = medlem.getNavn();
            }
        }
        return medlemNavn;
    }


    //________________________metode til at finde et specifikt medlem___________________________________________________
    public Medlem findSpecifiktKonkurrenceSvømmer(String info) {
        for (Medlem medlem : listen.getKonkurrenceSvømmer()) {
            if (medlem.getNavn().equalsIgnoreCase(info)) {
                return medlem;
            }
        }
        return null;
    }



    public String printTop5(AldersGruppe ALDERSGRUPPE, SvømmeDiscipliner SVØMMEDISCIPLIN) {
        ArrayList<KonkurrenceSvømmer> konkurrenceSvømmere = listen.getKonkurrenceSvømmer();
        Collections.sort(konkurrenceSvømmere, new Comparators.sorteringSvømmeTider());
        String string = "";
        int tæller = 1;
        ArrayList<Medlem> bestemteSvømmere = new ArrayList<>();
        for (Medlem konkurrenceSvømmer : konkurrenceSvømmere) {


            if (!(konkurrenceSvømmer instanceof KonkurrenceSvømmer)) {
                break;
            }

            if (konkurrenceSvømmer.getAldersGruppe().equals(ALDERSGRUPPE) && ((KonkurrenceSvømmer)konkurrenceSvømmer).getSVØMMEDISCIPLIN().equals(SVØMMEDISCIPLIN)) {
                bestemteSvømmere.add(konkurrenceSvømmer);
            }
        }
        ArrayList<Medlem> top5 = new ArrayList<>();
        for (int i = 0; i < Math.min(5, bestemteSvømmere.size()); i++) {
            top5.add(bestemteSvømmere.get(i));
        }

        for (Medlem konkurrenceSvømmer : top5) {
            string += tæller++ + ". " + ((KonkurrenceSvømmer) konkurrenceSvømmer).toStringTilTræner();
        }
        return string;
    }


    public ArrayList<KonkurrenceSvømmer> getKonkurrenceSvømmerListe() {
        return listen.getKonkurrenceSvømmer();
    }


    public String printJuniorHoldEfterTid() {
        ArrayList<KonkurrenceSvømmer> konkurrenceSvømmerListe = listen.getKonkurrenceSvømmer();
        Collections.sort(konkurrenceSvømmerListe, new Comparators.sorteringSvømmeTider());
        String string = "";
        int tæller = 1;
        for (Medlem konkurrenceSvømmer : listen.getKonkurrenceSvømmer()) {
            if (konkurrenceSvømmer.getAldersGruppe().equals(AldersGruppe.JUNIOR)) {
                string += tæller++ + ". " + ((KonkurrenceSvømmer) konkurrenceSvømmer).toStringTilTræner();
            }
        }
        return string;
    }

    public String printJuniorHoldEfterKonkurrence() {
        ArrayList<KonkurrenceSvømmer> konkurrenceSvømmerListe = listen.getKonkurrenceSvømmer();
        Collections.sort(konkurrenceSvømmerListe, new Comparators.sorteringKonkurrenceStatus());
        String string = "";
        int tæller = 1;
        for (Medlem konkurrenceSvømmer : listen.getKonkurrenceSvømmer()) {
            if (konkurrenceSvømmer.getAldersGruppe().equals(AldersGruppe.JUNIOR)) {
                string += tæller++ + ". " + ((KonkurrenceSvømmer) konkurrenceSvømmer).toStringTilTræner();
            }
        }
        return string;
    }

    public String printSeniorHoldEfterTid() {
        ArrayList<KonkurrenceSvømmer> konkurrenceSvømmerListe = listen.getKonkurrenceSvømmer();
        Collections.sort(konkurrenceSvømmerListe, new Comparators.sorteringSvømmeTider());
        String string = "";
        int tæller = 1;
        for (Medlem konkurrenceSvømmer : listen.getKonkurrenceSvømmer()) {
            if (konkurrenceSvømmer.getAldersGruppe().equals(AldersGruppe.SENIOR)) {
                string += tæller++ + ". " + ((KonkurrenceSvømmer) konkurrenceSvømmer).toStringTilTræner();
            }
        }
        return string;
    }

    public String printSeniorHoldEFterKonkurrence() {
        ArrayList<KonkurrenceSvømmer> konkurrenceSvømmerListe = listen.getKonkurrenceSvømmer();
        Collections.sort(konkurrenceSvømmerListe, new Comparators.sorteringKonkurrenceStatus());
        String string = "";
        int tæller = 1;
        for (Medlem konkurrenceSvømmer : listen.getKonkurrenceSvømmer()) {
            if (konkurrenceSvømmer.getAldersGruppe().equals(AldersGruppe.SENIOR)) {
                string += tæller++ + ". " + ((KonkurrenceSvømmer) konkurrenceSvømmer).toStringTilTræner();
            }
        }
        return string;
    }





}
