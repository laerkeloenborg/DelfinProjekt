import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {


    //________________________metode til at gemme liste med medlemmer til fil___________________________________________
    public ArrayList<Medlem> gemListeAfMedlemmer(ArrayList<Medlem> medlemsListe) {
        PrintStream output = null;
        try {
            output = new PrintStream(new File("medlemsListe"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (Medlem medlem : medlemsListe) {
            output.println(medlem.toStringTilFil());
        }
        return medlemsListe;
    }


    //________________________metode til  at hente listen med medlemmer fra fil_________________________________________
    //TODO: kommentér
    public ArrayList<Medlem> hentListeAfMedlemmer() {
        ArrayList<Medlem> medlemsListe = new ArrayList<>();
        Scanner scanner = null;
        File fil = new File("medlemsListe");
        try {
            scanner = new Scanner(fil);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Medlem medlem = null;
        while (scanner.hasNext()) {
            String linje = scanner.nextLine();
            String[] attributter = linje.split(";");

            medlem = new Medlem(attributter[0],
                    (attributter[1]),
                    MedlemsStatus.parseMedlemsStatus(attributter[3]),
                    attributter[4],
                    Boolean.parseBoolean(attributter[5]));

            medlemsListe.add(medlem);
        }
        scanner.close();
        return medlemsListe;
    }


    //_______________________KONKURRENCESVØMMERLISTE FILEN______________________________________________________________

    //________________________metode til at gemme liste af konkurrenceSvømmere til fil__________________________________
    public ArrayList<Medlem> gemListeAfKonkurrenceSvømmere(ArrayList<Medlem> konkurrenceSvømmerListe) {
        PrintStream output = null;
        try {
            output = new PrintStream(new File("konkurrenceSvømmerListe.csv"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (Medlem medlem : konkurrenceSvømmerListe) {
            output.println(medlem.toStringTilFil());
        }
        return konkurrenceSvømmerListe;
    }


    //________________________metode til  at hente listen af konkurrenceSvømmere fra fil________________________________
    public ArrayList<KonkurrenceSvømmer> hentListeAfKonkurrenceSvømmere() {
        ArrayList<KonkurrenceSvømmer> konkurrenceSvømmerListe = new ArrayList<>();
        Scanner scanner = null;
        File fil = new File("medlemsListe");
        try {
            scanner = new Scanner(fil);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        KonkurrenceSvømmer konkurrenceSvømmer = null;
        while (scanner.hasNext()) {
            String linje = scanner.nextLine();
            String[] attributter = linje.split(";");

            if (attributter[4].equalsIgnoreCase("konkurrence svømmer")) {
                konkurrenceSvømmer = new KonkurrenceSvømmer(attributter[0],
                        (attributter[1]),
                        MedlemsStatus.parseMedlemsStatus(attributter[3]),
                        attributter[4],
                        Boolean.parseBoolean(attributter[5]),
                        SvømmeDiscipliner.parseSvømmeDescipliner(attributter[6]),
                        Double.parseDouble(attributter[7]),
                        Boolean.parseBoolean(attributter[8]));

                konkurrenceSvømmerListe.add(konkurrenceSvømmer);
            }
        }
        scanner.close();
        return konkurrenceSvømmerListe;
    }
}
