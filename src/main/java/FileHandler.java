import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {


    private

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
        File file = new File("medlemsListe");
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Medlem medlem = null;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] attributes = line.split(";");

            medlem = new Medlem(attributes[0],
                    (attributes[1]),
                    MedlemsStatus.parseMedlemsStatus(attributes[3]),
                    attributes[4],
                    Boolean.parseBoolean(attributes[5]));

            medlemsListe.add(medlem);
        }
        scanner.close();
        return medlemsListe;
    }


}
