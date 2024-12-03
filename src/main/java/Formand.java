import java.util.ArrayList;
import java.util.Collections;


public class Formand {
    private ArrayList<Medlem> medlemsListen;
    private ArrayList<KonkurrenceSvømmer> konkurrenceSvømmerListe;
    private FileHandler fileHandler;

    //___________________________konstruktør____________________________________________________________________________
    public Formand() {
        fileHandler = new FileHandler();
        medlemsListen = fileHandler.hentListeAfMedlemmer();

    }


    //________________________metode til at tilføje et medlem___________________________________________________________
    public void tilføjMedlem(String navn, String cpr, MedlemsStatus MEDLEMSSTATUS, boolean harBetalt, String aktivitetsForm) {
        Medlem nytMedlem = new Medlem(navn, cpr, MEDLEMSSTATUS, harBetalt, aktivitetsForm);
        medlemsListen.add(nytMedlem);
        fileHandler.gemListeAfMedlemmer(medlemsListen);
    }

    public void tilføjKonkurrenceSvømmer(String navn, String cpr, MedlemsStatus MEDLEMSSTATUS, boolean harBetalt, String aktivitetsform, SvømmeDiscipliner svømmeDisciplin, double bedsteTid, boolean harKonkurreret){
        KonkurrenceSvømmer nyKonkurrenceSvømmer = new KonkurrenceSvømmer(navn, cpr, MEDLEMSSTATUS, harBetalt, aktivitetsform, svømmeDisciplin, bedsteTid, harKonkurreret);
        konkurrenceSvømmerListe.add(nyKonkurrenceSvømmer);
        fileHandler.gemListeAfKonkurrenceSvømmere(konkurrenceSvømmerListe);
    }


    //________________________metode til at gemme medlem i tekstfil_____________________________________________________
    public ArrayList<Medlem> gemMedlem() {
        return fileHandler.gemListeAfMedlemmer(medlemsListen);
    }

    public ArrayList<KonkurrenceSvømmer> gemKonkurrenceSvømmer(){
        return fileHandler.gemListeAfKonkurrenceSvømmere(konkurrenceSvømmerListe);
    }


    //________________________metode til at slette medlem via CPR_______________________________________________________
    public boolean sletMedlem(String cpr) {
        for (Medlem medlem : medlemsListen) {
            if (medlem.getCpr().equals(cpr)) {
                medlemsListen.remove(medlem);
                fileHandler.gemListeAfMedlemmer(medlemsListen);
                return true;
            }
        }
        return false;
    }


    //________________________metode til at redigere i et medlems oplysninger___________________________________________
    public String redigerMedlem(Medlem medlem, int valg, String nyVærdi) {
        switch (valg) {
            case 1:
                medlem.setNavn(nyVærdi);
                break;
            case 2:
                medlem.setCpr(nyVærdi);
                break;
            case 3:
                medlem.setMedlemsstatus(MedlemsStatus.parseMedlemsStatus(nyVærdi));
                break;
            case 4:
                medlem.setAktivitetsForm(nyVærdi);
                break;
            case 5:
                boolean harBetalt = nyVærdi.equalsIgnoreCase("ja");
                medlem.setHarBetalt(harBetalt);
                break;
            default:
                return "Ugyldigt valg";
        }
        return " ";
    }


    //________________________metode til at finde et specifikt medlems navn_____________________________________________
    public String findSpecifiktMedlemsNavn(String cpr) {
        String medlemNavn = "";
        for (Medlem medlem : medlemsListen) {
            if (medlem.getCpr().equalsIgnoreCase(cpr)) {
                medlemNavn = medlem.getNavn();
            }
        }
        return medlemNavn;
    }


    //________________________metode til at finde et specifikt medlem___________________________________________________
    public Medlem findSpecifiktMedlem(String cpr) {
        for (Medlem medlem : medlemsListen) {
            if (medlem.getCpr().equalsIgnoreCase(cpr)) {
                return medlem;
            }
        }
        return null;
    }


    //________________________metode til at sorterer i medlemmer efter eget valg________________________________________
    public void sorterMedlemmerValgMetode(int valg) {
        switch (valg) {
            case 1:
                Collections.sort(medlemsListen, new Comparators.sorteringMedlemsstatus());
                break;
            case 2:
                Collections.sort(medlemsListen, new Comparators.sorteringAldersgruppe());
                break;
            case 3:
                Collections.sort(medlemsListen, new Comparators.sorteringAktivitetsform());
                break;
        }
        visMedlemmer();
    }


    //________________________metode til at sorterer efter navn_________________________________________________________
    public void sorteringNavn() {
        Collections.sort(medlemsListen, new Comparators.sorteringNavn());
    }


    //________________________metode til at printe medlemmer ___________________________________________________________
    public ArrayList<Medlem> visMedlemmer() {
        if (medlemsListen.isEmpty()) {
            return null;
        } else {
            return medlemsListen;
        }
    }

    //_______________________metode til at se antallet af medlemmer i klubben___________________________________________
    public int antalMedlemmer() {
        return medlemsListen.size();
    }

}
