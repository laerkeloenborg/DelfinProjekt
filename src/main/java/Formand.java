import java.util.ArrayList;

public class Formand {
    private ArrayList<Medlem> medlemsListen;
    private FileHandler fileHandler;

    public Formand() {
        fileHandler = new FileHandler();
        medlemsListen = fileHandler.hentListeAfMedlemmer();
    }

    // metode til at tilføje et medlem
    public void tilføjMedlem(String navn, String cpr, MedlemsStatus MEDLEMSSTATUS, String aktivitetsForm, boolean harBetalt) {
        Medlem nytMedlem = new Medlem(navn, cpr, MEDLEMSSTATUS, aktivitetsForm, harBetalt);
        medlemsListen.add(nytMedlem);
        fileHandler.gemListeAfMedlemmer(medlemsListen);
    }

    public void formandUI(boolean harBetalt){

    }

    // metode til at slette medlem via cpr
    public void sletMedlem(String cpr) {
        for (Medlem medlem : medlemsListen) {
            if (medlem.getCpr().equals(cpr)) {
                medlemsListen.remove(medlem);
                fileHandler.gemListeAfMedlemmer(medlemsListen);
            }
        }
    }

    // metode til at redigere medlem
    public void redigerMedlem(String cpr, String nytNavn, MedlemsStatus NY_MEDLEMSSTATUS, String nyAktivitetsForm, boolean nyHarBetalt) {
        for (Medlem medlem : medlemsListen) {
            if (medlem.getCpr().equals(cpr)) {
                medlem.setNavn(nytNavn);
                medlem.setMedlemsstatus(NY_MEDLEMSSTATUS);
                medlem.setAktivitetsForm(nyAktivitetsForm);
                medlem.setHarBetalt(nyHarBetalt);
                fileHandler.gemListeAfMedlemmer(medlemsListen);
            }
        }
    }

    // metode til at printe medlemmer
    public void visMedlemmer() {
        if (medlemsListen.isEmpty()) {
            System.out.println("Ingen medlemmer registreret");
        } else {
            for (Medlem medlem : medlemsListen) {
                System.out.println(medlem);
            }
        }
    }
}
