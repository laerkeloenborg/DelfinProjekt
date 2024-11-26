import java.util.ArrayList;

public class Formand {
    private ArrayList<Medlem> medlemsListe;
    private FileHandler fileHandler;

    public Formand() {
        fileHandler = new FileHandler();
        medlemsListe = fileHandler.hentListeAfMedlemmer();
    }

    // metode til at tilføje et medlem
    public void tilføjMedlem(String navn, String cpr, MedlemsStatus MEDLEMSSTATUS, String aktivitetsForm, boolean harBetalt) {
        Medlem nytMedlem = new Medlem(navn, cpr, MEDLEMSSTATUS, aktivitetsForm, harBetalt);
        medlemsListe.add(nytMedlem);
        fileHandler.gemListeAfMedlemmer(medlemsListe);
    }

    // metode til at slette medlem via cpr
    public void sletMedlem(String cpr) {
        for (Medlem medlem : medlemsListe) {
            if (medlem.getCpr().equals(cpr)) {
                medlemsListe.remove(medlem);
                fileHandler.gemListeAfMedlemmer(medlemsListe);
            }
        }
    }

    // metode til at redigere medlem
    public void redigerMedlem(String cpr, String nytNavn, MedlemsStatus NY_MEDLEMSSTATUS, String nyAktivitetsForm, boolean nyHarBetalt) {
        for (Medlem medlem : medlemsListe) {
            if (medlem.getCpr().equals(cpr)) {
                medlem.setNavn(nytNavn);
                medlem.setMedlemsstatus(NY_MEDLEMSSTATUS);
                medlem.setAktivitetsForm(nyAktivitetsForm);
                medlem.setHarBetalt(nyHarBetalt);
                fileHandler.gemListeAfMedlemmer(medlemsListe);
            }
        }
    }

    // metode til at printe medlemmer
    public void visMedlemmer() {
        if (medlemsListe.isEmpty()) {
            System.out.println("Ingen medlemmer registreret");
        } else {
            for (Medlem medlem : medlemsListe) {
                System.out.println(medlem);
            }
        }
    }
}
