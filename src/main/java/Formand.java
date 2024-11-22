import java.util.ArrayList;

public class Formand {
    private ArrayList<Medlem> medlemsListe;
    private FileHandler fileHandler;

    public Formand() {
        fileHandler = new FileHandler();
        medlemsListe = fileHandler.hentListeAfMedlemmer();
    }
}