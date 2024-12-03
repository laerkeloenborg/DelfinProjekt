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

    //TODO: exceptions
public ArrayList<KonkurrenceSvømmer> top5(ArrayList<KonkurrenceSvømmer> topSvømmere, AldersGruppe ALDERSGRUPPE, SvømmeDiscipliner SVØMMEDISCIPLIN){
        ArrayList<KonkurrenceSvømmer> bestemteSvømmere = new ArrayList<>();
        for (KonkurrenceSvømmer konkurrenceSvømmer : topSvømmere){
            if(konkurrenceSvømmer.getAldersGruppe().equals(ALDERSGRUPPE) && konkurrenceSvømmer.getSVØMMEDISCIPLIN().equals(SVØMMEDISCIPLIN)){
                bestemteSvømmere.add(konkurrenceSvømmer);
            }
        }

        ArrayList<KonkurrenceSvømmer> top5 = new ArrayList<>();
        for(int i = 0; i < Math.min(5,bestemteSvømmere.size());i++){
            top5.add(bestemteSvømmere.get(i));
        }

        return top5;
}


public String printTop5(ArrayList<KonkurrenceSvømmer> topSvømmere){
        String string = "";
        int tæller = 1;

        for (KonkurrenceSvømmer konkurrenceSvømmer : topSvømmere){
            string += tæller++ + konkurrenceSvømmer.toString();
        }
        return string;
}

public ArrayList<KonkurrenceSvømmer> getKonkurrenceSvømmerListe(){
        return konkurrenceSvømmerListe;
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
