import java.util.ArrayList;

public class Formand {
    private ArrayList<Medlem> testListe;
    private FileHandler fileHandler;

    public Formand() {
        fileHandler = new FileHandler();
        testListe = fileHandler.hentListeAfMedlemmer();
    }
}