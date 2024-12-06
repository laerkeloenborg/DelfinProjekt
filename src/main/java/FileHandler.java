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


    //_______________________KONKURRENCESVØMMERLISTE FILEN______________________________________________________________

    //________________________metode til at gemme liste af konkurrenceSvømmere til fil__________________________________
    public ArrayList<KonkurrenceSvømmer> gemListeAfKonkurrenceSvømmere(ArrayList<KonkurrenceSvømmer> konkurrenceSvømmerListe) {
        PrintStream output = null;
        try {
            output = new PrintStream(new File("medlemsListe.csv"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (KonkurrenceSvømmer konkurrenceSvømmer : konkurrenceSvømmerListe) {
            output.println(konkurrenceSvømmer.toStringTilFil());
        }
        return konkurrenceSvømmerListe;
    }


    //________________________metode til  at hente listen af konkurrenceSvømmere fra fil________________________________
    public ArrayList<KonkurrenceSvømmer> hentListeAfKonkurrenceSvømmere() {
        ArrayList<KonkurrenceSvømmer> konkurrenceSvømmerListe = new ArrayList<>();
        Scanner scanner = null;
        File fil = new File("medlemsListe.csv");
        try {
            scanner = new Scanner(fil);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        KonkurrenceSvømmer konkurrenceSvømmer = null;
        while (scanner.hasNext()) {
            String linje = scanner.nextLine();
            String[] attributter = linje.split(";");

            if (attributter[5].equalsIgnoreCase("konkurrence svømmer")) {
                konkurrenceSvømmer = new KonkurrenceSvømmer(attributter[0],
                        (attributter[1]),
                        MedlemsStatus.parseMedlemsStatus(attributter[3]),
                        Boolean.parseBoolean(attributter[4]),
                        attributter[5],
                        SvømmeDiscipliner.parseSvømmeDescipliner(attributter[6]),
                        Double.parseDouble(attributter[7]),
                        Boolean.parseBoolean(attributter[8]));

                konkurrenceSvømmerListe.add(konkurrenceSvømmer);
            }
        }
        scanner.close();
        return konkurrenceSvømmerListe;
    }

    //-----------------------------METODE TIL AT GEMME OG HENTE KONKURRENCELISTE------------------------------------//
    public ArrayList<KonkurrenceSvømmer> gemKonkurrenceSvømmere(ArrayList<KonkurrenceSvømmer> konkurrenceSvømmerListe) {
        PrintStream output = null;
        try {
            output = new PrintStream(new File("KonkurrenceListeFil.csv"));  // Gem til en separat fil for konkurrenceSvømmere
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (KonkurrenceSvømmer konkurrenceSvømmer : konkurrenceSvømmerListe) {
            output.println(konkurrenceSvømmer.toStringTilKonkurrenceFil());  // Gem konkurrenceSvømmere til fil
        }
        return konkurrenceSvømmerListe;  // Returner listen
    }

    // ________________________metode til at hente liste af konkurrenceSvømmere fra fil________________________
    public ArrayList<KonkurrenceSvømmer> hentKonkurrenceSvømmere() {
        ArrayList<KonkurrenceSvømmer> konkurrenceSvømmerListe = new ArrayList<>();
        Scanner scanner = null;
        File fil = new File("KonkurrenceListeFil.csv");

        try {
            scanner = new Scanner(fil);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Filen blev ikke fundet.", e);
        }

        // Gennemgår hver linje i filen
        while (scanner.hasNext()) {
            String linje = scanner.nextLine();
            String[] attributter = linje.split(";");

            // Opretter en KonkurrenceSvømmer
            KonkurrenceSvømmer konkurrenceSvømmer = new KonkurrenceSvømmer(
                    attributter[0],  // Navn
                    attributter[1],  // CPR
                    MedlemsStatus.parseMedlemsStatus(attributter[3]),  // Medlemsstatus
                    Boolean.parseBoolean(attributter[4]),  // Har betalt
                    attributter[5],  // Aktivitet (Konkurrence Svømmer)
                    SvømmeDiscipliner.parseSvømmeDescipliner(attributter[6]),  // Svømmedisciplin
                    Double.parseDouble(attributter[7]),  // Bedste tid
                    Boolean.parseBoolean(attributter[8])  // Har konkurreret
            );

            // Hent konkurrence resultater, hvis de findes (efter 8. index)
            for (int i = 9; i < attributter.length; i += 3) {
                if (i + 2 < attributter.length) {  // Sørg for at der er nok elementer
                    String stævne = attributter[i];  // Stævnenavn
                    int placering = Integer.parseInt(attributter[i + 1]);  // Placering (kan bruges senere hvis nødvendigt)
                    double tid = Double.parseDouble(attributter[i + 2]);  // Tid (kan bruges senere hvis nødvendigt)

                    // Tilføj stævne som en string til stævner listen
                    konkurrenceSvømmer.tilføjStævne(stævne, placering, tid);
                }
            }

            // Tilføj konkurrencesvømmeren til listen
            konkurrenceSvømmerListe.add(konkurrenceSvømmer);
        }

        scanner.close();  // Luk scanner
        return konkurrenceSvømmerListe;  // Returner listen af konkurrenceSvømmere
    }
}



