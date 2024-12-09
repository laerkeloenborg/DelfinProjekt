import java.util.ArrayList;
import java.util.Collections;

public class Træner {

    private FileHandler fileHandler;
    private ArrayList<KonkurrenceSvømmer> konkurrenceSvømmerListe;
    private ArrayList<Medlem> medlemsListen;

    public Træner() {
        fileHandler = new FileHandler();
        konkurrenceSvømmerListe = fileHandler.hentListeAfKonkurrenceSvømmere();
        medlemsListen = fileHandler.hentListeAfMedlemmer();
    }


    public String ændringAfKonkurrenceSvømmer(Medlem konkurrenceSvømmer, int valg, String nyInfo) {
        switch (valg) {
            case 1:
                double nySvømmetid = Double.parseDouble(nyInfo);
                ((KonkurrenceSvømmer)konkurrenceSvømmer).setBedsteTid(nySvømmetid);
                fileHandler.gemListeAfMedlemmer(medlemsListen);
                break;
            case 2:
                SvømmeDiscipliner nySvømmedisciplin = SvømmeDiscipliner.valueOf(nyInfo);
                ((KonkurrenceSvømmer)konkurrenceSvømmer).setSVØMMEDISCIPLIN(nySvømmedisciplin);
                fileHandler.gemListeAfMedlemmer(medlemsListen);
                break;

            case 3:
                Boolean nyKonkurrenceStatus = nyInfo.equalsIgnoreCase("ja");
                ((KonkurrenceSvømmer)konkurrenceSvømmer).setHarKonkurreret(nyKonkurrenceStatus);
                fileHandler.gemListeAfMedlemmer(medlemsListen);
                break;
            default:
                return "Ugyldigt valg";
        }
        return "";
    }

    public void sorteringTid() {
        Comparators.sorteringSvømmeTider comparator = new Comparators.sorteringSvømmeTider();
        Collections.sort(konkurrenceSvømmerListe, comparator);
    }

    public void sortertingKonkurrenceStatus() {
        Comparators.sorteringKonkurrenceStatus comparator = new Comparators.sorteringKonkurrenceStatus();
        Collections.sort(konkurrenceSvømmerListe, comparator);
    }


    //________________________metode til at finde et specifikt medlems navn_____________________________________________
    public String findSpecifiktKonkurrenceSvømmersNavn(String info) {
        String medlemNavn = "";
        for (Medlem medlem : konkurrenceSvømmerListe) {
            if (medlem.getNavn().equalsIgnoreCase(info)) {
                medlemNavn = medlem.getNavn();
            }
        }
        return medlemNavn;
    }


    //________________________metode til at finde et specifikt medlem___________________________________________________
    public Medlem findSpecifiktKonkurrenceSvømmer(String info) {
        for (Medlem medlem : konkurrenceSvømmerListe) {
            if (medlem.getNavn().equalsIgnoreCase(info)) {
                return medlem;
            }
        }
        return null;
    }

    //TODO: exceptions
    public String printTop5(AldersGruppe ALDERSGRUPPE, SvømmeDiscipliner SVØMMEDISCIPLIN){
            ArrayList<KonkurrenceSvømmer> konkurrenceSvømmere = konkurrenceSvømmerListe;
            Collections.sort(konkurrenceSvømmere, new Comparators.sorteringSvømmeTider());

            String string = "";
            int tæller = 1;
            ArrayList<KonkurrenceSvømmer> bestemteSvømmere = new ArrayList<>();
            for (KonkurrenceSvømmer konkurrenceSvømmer : konkurrenceSvømmere) {
                if (konkurrenceSvømmer.getAldersGruppe().equals(ALDERSGRUPPE) && konkurrenceSvømmer.getSVØMMEDISCIPLIN().equals(SVØMMEDISCIPLIN)){
                    bestemteSvømmere.add(konkurrenceSvømmer);
                }
            }
            ArrayList<KonkurrenceSvømmer> top5 = new ArrayList<>();
            for (int i = 0; i < Math.min(5, bestemteSvømmere.size()); i++) {
                top5.add(bestemteSvømmere.get(i));
            }

            for (Medlem konkurrenceSvømmer : top5) {
                string += tæller++ + ". " + konkurrenceSvømmer.toString();
            }
            return string;
    }

    public ArrayList<KonkurrenceSvømmer> getKonkurrenceSvømmerListe() {
        return konkurrenceSvømmerListe;
    }

    public String printJuniorHold() {
        String string = "";
        int tæller = 1;
        for (Medlem konkurrenceSvømmer : konkurrenceSvømmerListe) { //TODO, fiks så se de kun kommer frem hvis de har konkurreret
            if (konkurrenceSvømmer.getAldersGruppe().equals(AldersGruppe.JUNIOR)) {
                string += tæller++ + ". " + konkurrenceSvømmer + "\n";
            }
        }
        return string;
    }

    public String printSeniorHold() {
        String string = "";
        int tæller = 1;
        for (Medlem konkurrenceSvømmer : konkurrenceSvømmerListe) {
            if (konkurrenceSvømmer.getAldersGruppe().equals(AldersGruppe.SENIOR)) {
                string += tæller++ + ". " + konkurrenceSvømmer + "\n";
            }
        }
        return string;
    }

    public ArrayList<KonkurrenceSvømmer> hentSeniorSvømmere() {
        ArrayList<KonkurrenceSvømmer> seniorSvømmere = new ArrayList<>();
        for (KonkurrenceSvømmer svømmer : konkurrenceSvømmerListe) {
            if (svømmer.getAldersGruppe().equals(AldersGruppe.SENIOR)) {
                seniorSvømmere.add(svømmer);
            }
        }
        return seniorSvømmere;
    }
    public ArrayList<KonkurrenceSvømmer> hentJuniorSvømmere() {
        ArrayList<KonkurrenceSvømmer> juniorSvømmere = new ArrayList<>();
        for (KonkurrenceSvømmer svømmer : konkurrenceSvømmerListe) {
            if (svømmer.getAldersGruppe().equals(AldersGruppe.JUNIOR)) {
                juniorSvømmere.add(svømmer);
            }
        }
        return juniorSvømmere;
    }

    public String hentKonkurrenceSvømmereFraFil() {
        String string = "";
        int tæller = 1;
        for (KonkurrenceSvømmer konkurrenceSvømmer : konkurrenceSvømmerListe) {
            string += tæller++ + ". " + konkurrenceSvømmer.toString();
        }
        return string;
    }

    // Metode til at gemme konkurrenceSvømmere
    public void gemKonkurrenceSvømmere(ArrayList<KonkurrenceSvømmer> konkurrenceSvømmerListe) {
        fileHandler.gemKonkurrenceSvømmere(konkurrenceSvømmerListe);
    }

    // Metode til at hente konkurrenceSvømmere
    public String hentKonkurrenceSvømmere() {
        String string = "";
        int tæller = 1;
        for (KonkurrenceSvømmer konkurrenceSvømmer : fileHandler.hentKonkurrenceSvømmere()){
            string += tæller++ + ". " + konkurrenceSvømmer.toStringStævne() + "\n";
        }
        return string;
    }




}
