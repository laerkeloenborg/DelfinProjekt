import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

public ArrayList<Medlem> gemListeAfMedlemmer(ArrayList<Medlem> navnPåListe) {
    PrintStream output = null;
    try {
        output = new PrintStream(new File("medlemsListe"));
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }
    for (Medlem medlem : navnPåListe) {
        output.println(medlem);
    }
    return navnPåListe;
}

public ArrayList<Medlem> hentListeAfMedlemmer(){
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
                Boolean.parseBoolean(attributes[2]),
                (attributes[3]));

        medlemsListe.add(medlem);
    }
    scanner.close();
    return medlemsListe;
}
}
