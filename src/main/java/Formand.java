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

    // metode til at slette medlem via cpr
    public void sletMedlem(String cpr) {
        for (Medlem medlem : medlemsListen) {
            if (medlem.getCpr().equals(cpr)) {
                medlemsListen.remove(medlem);
                fileHandler.gemListeAfMedlemmer(medlemsListen);
            }
        }
    }

    public String redigerMedlem(Medlem medlem, int choice, String newValue) {
        switch (choice) {
            case 1:
                medlem.setNavn(newValue);
                break;
            case 2:

            int nyAlder = Integer.parseInt(newValue);
                medlem.setCpr(newValue);
                break;
            case 3:
                medlem.setMedlemsstatus(MedlemsStatus.parseMedlemsStatus(newValue));
                break;
            case 4:
                medlem.setAktivitetsForm(newValue);
                break;
            case 5:
                boolean harBetalt = newValue.equalsIgnoreCase("ja");
                medlem.setHarBetalt(harBetalt);
                break;
            default:
                return "Ugyldigt valg";
        }
        return " ";
    }


    public String findSpecifiktMedlemsNavn(String cpr) {
        String medlemNavn = "";
        for (Medlem medlem : medlemsListen) {
            if (medlem.getCpr().equalsIgnoreCase(cpr)) {
                medlemNavn = medlem.getNavn();
            }
        }
        return medlemNavn;
    }

    public Medlem findSpecifiktMedlem(String cpr) {
        for (Medlem medlem : medlemsListen) {
            if (medlem.getCpr().equalsIgnoreCase(cpr)) {
                return medlem;
            }
        }
        return null;
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
