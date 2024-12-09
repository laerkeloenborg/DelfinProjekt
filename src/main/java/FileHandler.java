import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
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
        // Hent eksisterende svømmere fra filen
        ArrayList<KonkurrenceSvømmer> eksisterendeSvømmere = hentKonkurrenceSvømmere();

        // Gennemgå de svømmere, der skal gemmes, og opdater dem i eksisterendeSvømmere
        for (KonkurrenceSvømmer nySvømmer : konkurrenceSvømmerListe) {
            boolean findesAllerede = false;

            // Tjek om svømmeren allerede findes i den eksisterende liste
            for (KonkurrenceSvømmer eksisterendeSvømmer : eksisterendeSvømmere) {
                // Brug svømmerens navn (eller et unikt id) til at finde den eksisterende svømmer
                if (eksisterendeSvømmer.getNavn().equals(nySvømmer.getNavn())) {
                    // Hvis svømmeren findes, opdaterer vi kun deres stævneresultater
                    for (String resultat : nySvømmer.getKonkurrenceResultater()) {
                        // Opdel resultatstrengen for at få stævne, placering og tid
                        String[] dele = resultat.split(", ");
                        String stævne = dele[0].split(": ")[1]; // Hent stævnenavnet
                        int placering = Integer.parseInt(dele[1].split(": ")[1]); // Hent placeringen
                        double tid = Double.parseDouble(dele[2].split(": ")[1]); // Hent tiden
                        String datoStr = dele[3].split(": ")[1];
                        LocalDate dato = LocalDate.parse(datoStr);

                        // Først tjekke om stævnet allerede findes i den eksisterende svømmer
                        boolean stævneFindesAllerede = false;
                        for (String eksisterendeResultat : eksisterendeSvømmer.getKonkurrenceResultater()) {
                            if (eksisterendeResultat.contains(stævne) && eksisterendeResultat.contains(String.valueOf(placering))) {
                                stævneFindesAllerede = true;
                                break;
                            }
                        }

                        // Hvis stævnet ikke findes, tilføj det til svømmeren
                        if (!stævneFindesAllerede) {
                            eksisterendeSvømmer.tilføjKonkurrenceresultat(stævne, placering, tid, dato);
                        }
                    }
                    findesAllerede = true;
                    break;
                }
            }

            // Hvis svømmeren ikke findes i den eksisterende liste, tilføjes den
            if (!findesAllerede) {
                eksisterendeSvømmere.add(nySvømmer);
            }
        }

        // Når vi har opdateret svømmerne, skriv de opdaterede svømmere tilbage i filen
        try (PrintWriter writer = new PrintWriter(new FileWriter("KonkurrenceListeFil.csv", false))) {
            // Skriv hver svømmer til filen (uden at duplikere)
            for (KonkurrenceSvømmer svømmer : eksisterendeSvømmere) {
                writer.println(svømmer.toStringTilKonkurrenceFil());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return eksisterendeSvømmere;
    }

    // ________________________metode til at hente liste af konkurrenceSvømmere fra fil________________________
    public ArrayList<KonkurrenceSvømmer> hentKonkurrenceSvømmere() {
        ArrayList<KonkurrenceSvømmer> konkurrenceSvømmereListe = new ArrayList<>();
        File fil = new File("KonkurrenceListeFil.csv");

        if (!fil.exists()) {
            try {
                fil.createNewFile(); // Opret filen, hvis den ikke eksisterer
            } catch (IOException e) {
                throw new RuntimeException("Fejl ved oprettelse af filen.", e);
            }
        }

        try (Scanner scanner = new Scanner(fil)) {
            while (scanner.hasNext()) {
                String linje = scanner.nextLine();
                String[] attributter = linje.split(";");

                // Debugging: Tjek hvad vi får fra filen
                //System.out.println("Læs linje: " + linje);
                //System.out.println("Splittet attributter: " + Arrays.toString(attributter));

                // Basisattributter for en konkurrencesvømmer
                String navn = attributter[0];
                String cpr = attributter[1];
                MedlemsStatus medlemsStatus = MedlemsStatus.parseMedlemsStatus(attributter[3]);
                boolean harBetalt = Boolean.parseBoolean(attributter[4]);
                String aktivitetsform = attributter[5];
                SvømmeDiscipliner svømmeDisciplin = SvømmeDiscipliner.parseSvømmeDescipliner(attributter[6]);
                double bedsteTid = Double.parseDouble(attributter[7]);
                boolean harKonkurreret = Boolean.parseBoolean(attributter[8]);

                // Opret svømmeren
                KonkurrenceSvømmer svømmer = new KonkurrenceSvømmer(navn, cpr, medlemsStatus, harBetalt, aktivitetsform, svømmeDisciplin, bedsteTid, harKonkurreret);

                // Håndter konkurrenceresultater (fra index 9 og frem)
                if (attributter.length > 9) {
                    for (int i = 9; i < attributter.length; i += 4) {
                        String stævne = attributter[i];
                        int placering = Integer.parseInt(attributter[i + 1]);
                        double tid = Double.parseDouble(attributter[i + 2]);

                        String dato = attributter[i + 3];
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate datoNY = LocalDate.parse(dato, formatter);

                        // Debugging: Tjek hvilke resultater vi forsøger at tilføje
                        //System.out.println("Læser konkurrenceresultat: Stævne: " + stævne + ", Placering: " + placering + ", Tid: " + tid);

                        // Tilføj konkurrenceresultat til svømmeren
                        svømmer.tilføjKonkurrenceresultatNY(new KonkurrenceResultat(stævne, placering, tid, datoNY));
                    }
                }

                // Tilføj svømmeren til listen
                konkurrenceSvømmereListe.add(svømmer);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Filen blev ikke fundet.", e);
        }

        // Debugging: Tjek om vi har konkurrenceresultater for alle svømmere
        for (KonkurrenceSvømmer svømmer : konkurrenceSvømmereListe) {
            //System.out.println("Svømmer: " + svømmer.getNavn());
            if (svømmer.getKonkurrenceResultaterNY().isEmpty()) {
                //System.out.println("Ingen konkurrenceresultater");
            } else {
                //System.out.println("Konkurrenceresultater:");
                for (KonkurrenceResultat resultat : svømmer.getKonkurrenceResultaterNY()) {
                    //System.out.println("Stævne: " + resultat.getStævne() + ", Placering: " + resultat.getPlacering() + ", Tid: " + resultat.getTid());
                }
            }
        }

        return konkurrenceSvømmereListe;
    }
}
