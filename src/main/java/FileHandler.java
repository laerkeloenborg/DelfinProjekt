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
            output = new PrintStream(new File("medlemsListe.csv"));
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
        File fil = new File("medlemsListe.csv");
        try {
            scanner = new Scanner(fil);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Medlem medlem = null;
        while (scanner.hasNext()) {
            String linje = scanner.nextLine();
            String[] attributter = linje.split(";");
            if (attributter[5].equalsIgnoreCase("konkurrence svømmer")) {
                medlem = new KonkurrenceSvømmer(attributter[0],
                        (attributter[1]),
                        MedlemsStatus.parseMedlemsStatus(attributter[3]),
                        Boolean.parseBoolean(attributter[4]),
                        attributter[5],
                        SvømmeDiscipliner.parseSvømmeDescipliner(attributter[6]),
                        Double.parseDouble(attributter[7]),
                        Boolean.parseBoolean(attributter[8]));

            } else {
                medlem = new Medlem(attributter[0],
                        (attributter[1]),
                        MedlemsStatus.parseMedlemsStatus(attributter[3]),
                        Boolean.parseBoolean(attributter[4]),
                        attributter[5]);
            }
            medlemsListe.add(medlem);
        }
        scanner.close();
        return medlemsListe;
    }


}
