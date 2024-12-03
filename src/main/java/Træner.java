import java.util.ArrayList;
import java.util.Collections;

public class Træner {

    private FileHandler fileHandler;
    private ArrayList<KonkurrenceSvømmer> konkurrenceSvømmerListe;

    public Træner() {
        fileHandler = new FileHandler();
        konkurrenceSvømmerListe = fileHandler.hentListeAfKonkurrenceSvømmere();
    }


    public String ændringAfKonkurrenceSvømmer(KonkurrenceSvømmer konkurrenceSvømmer, int valg, String nyInfo) {
        switch (valg) {
            case 1:
                double nySvømmetid = Double.parseDouble(nyInfo);
                konkurrenceSvømmer.setBedsteTid(nySvømmetid);
                break;
            case 2:
                Boolean nyKonkurrenceStatus = nyInfo.equalsIgnoreCase("ja");
                konkurrenceSvømmer.setHarKonkurreret(nyKonkurrenceStatus);
                break;

            case 3:
                SvømmeDiscipliner nySvømmedisciplin = SvømmeDiscipliner.valueOf(nyInfo);
                konkurrenceSvømmer.setSVØMMEDISCIPLIN(nySvømmedisciplin);
                break;
            default:
                return "Ugyldigt valg";
        }
        return "";
    }

    public void sorteringTid() {
        Comparators.sorteringSvømmetider comparator = new Comparators.sorteringSvømmetider();
        Collections.sort(konkurrenceSvømmerListe, comparator);
    }

    public void sortertingKonkurrenceStatus() {
        Comparators.sorteringKonkurrencestatus comparator = new Comparators.sorteringKonkurrencestatus();
        Collections.sort(konkurrenceSvømmerListe, comparator);
    }

    public String printJuniorHold() {
        String string = "";
        int tæller = 1;
        for (KonkurrenceSvømmer konkurrenceSvømmer : konkurrenceSvømmerListe) {
            if (konkurrenceSvømmer.getAldersGruppe().equals(AldersGruppe.JUNIOR)) {
                string += tæller++ + konkurrenceSvømmer.toString();
            }
        }
        return string;
    }

    public String printSeniorHold() {
        String string = "";
        int tæller = 1;
        for (KonkurrenceSvømmer konkurrenceSvømmer : konkurrenceSvømmerListe) {
            if (konkurrenceSvømmer.getAldersGruppe().equals(AldersGruppe.SENIOR)) {
                string += tæller++ + konkurrenceSvømmer.toString();
            }
        }
        return string;
    }


    public String hentKonkurrenceSvømmereFraFil() {
        String string = "";
        int tæller = 1;
        for (KonkurrenceSvømmer konkurrenceSvømmer : konkurrenceSvømmerListe) {
            string += tæller++ + konkurrenceSvømmer.toString();
        }
        return string;
    }

}
