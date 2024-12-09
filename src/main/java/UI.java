import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
    private Scanner scanner;
    private Controller controller;

    //________________________konstuktør________________________________________________________________________________
    public UI() {
        scanner = new Scanner(System.in);
        controller = new Controller();
    }

    //________________________start af UserInterfacet___________________________________________________________________
    public void start() {
        boolean kører = true;
        while (kører) {
            System.out.println("Velkommen til Svømmeklubben Delfinen" +
                    "\n1. Formand Menu" +
                    "\n2. Kasserer Menu" +
                    "\n3. Træner Menu" +
                    "\n4. For at afslutte" +
                    "\n\nVælg en mulighed (1-4): \n");

            String valg = scanner.nextLine();

            switch (valg) {
                //________________________formandens menu_______________________________________________________________
                case "1":
                    boolean formandMenuKører = true;
                    while (formandMenuKører) {
                        System.out.println("Formand Menu" +
                                "\n1. for at oprette nyt medlem" +
                                "\n2. for at slette et medlem" +
                                "\n3. for at redigere et medlem" +
                                "\n4. for at se medlemsliste" +
                                "\n5. for at gå tilbage til hovedmenuen" +
                                "\n\nVælg en mulighed: \n");

                        String brugerValg = scanner.nextLine();

                        switch (brugerValg) {
                            //_______________________opret nyt medlem___________________________________________________
                            case "1":
                                System.out.println("Opret nyt medlem" +
                                        "\nIndtast navn: ");
                                String navn = "";
                                boolean validNavn = false;

                                while (!validNavn) {
                                    try {
                                        navn = scanner.nextLine();
                                        if (!navn.matches("[æøåa-zA-Z\\s]+")) { //Gør at man kun kan skrive bogstaver fra A-Å og lave mellemrum
                                            throw new IllegalArgumentException("Navnet må kun indenholde bogstaver");
                                        }
                                        validNavn = true;
                                    } catch (IllegalArgumentException ime) {
                                        System.out.println("Fejl: " + ime.getMessage());
                                    }
                                }


                                System.out.print("Indtast CPR (6 cifre): ");
                                String cpr = "";
                                boolean validCpr = false;

                                while (!validCpr) {
                                    try {
                                        cpr = scanner.nextLine();
                                        if (!cpr.matches("[0-9]{6}")) { //Tager kun i mod tal fra 0-9 og skal være 6 langt
                                            throw new IllegalArgumentException("CPR skal være tal og 6 cifre langt");
                                        }

                                        int dag = Integer.parseInt(cpr.substring(0, 2));
                                        int måned = Integer.parseInt(cpr.substring(2, 4));
                                        int år = Integer.parseInt(cpr.substring(4, 6));

                                        if (år >= 0 && år <= LocalDate.now().getYear() % 100) {
                                            år += 2000;
                                        } else {
                                            år += 1900;
                                        }
                                        LocalDate.of(år, måned, dag);
                                        validCpr = true;
                                    } catch (IllegalArgumentException iae) {
                                        System.out.println("Fejl: " + iae.getMessage());
                                    } catch (DateTimeException dte) {
                                        System.out.println("Fejl: " + "CPR indenholder en ugyldig dato");
                                    }
                                }


                                System.out.print("Vælg medlemsstatus (aktiv/passiv): ");
                                String statusInput = "";
                                boolean validStatus = false;
                                MedlemsStatus status = null;

                                while (!validStatus) {
                                    try {
                                        statusInput = scanner.nextLine().toLowerCase();
                                        if (!statusInput.equals("aktiv") && !statusInput.equals("passiv")) {
                                            throw new IllegalArgumentException("Indtast aktiv eller passiv");
                                        }
                                        status = statusInput.equals("aktiv") ? MedlemsStatus.AKTIV : MedlemsStatus.PASSIV;
                                        validStatus = true;
                                    } catch (IllegalArgumentException iae) {
                                        System.out.println("Fejl: " + iae.getMessage());
                                    }
                                }

                                System.out.println("Har medlemmet betalt? (ja/nej):  ");
                                String harBetalt = "";
                                boolean validBetaling = false;
                                boolean brugerBetalt = false;

                                while (!validBetaling) {
                                    try {
                                        harBetalt = scanner.nextLine().toLowerCase();
                                        if (harBetalt.equals("ja")) {
                                            brugerBetalt = true;
                                            validBetaling = true;
                                        } else if (harBetalt.equals("nej")) {
                                            brugerBetalt = false;
                                            validBetaling = true;
                                        } else {
                                            throw new IllegalArgumentException("Indtast ja eller nej");
                                        }
                                    } catch (IllegalArgumentException iae) {
                                        System.out.println("Fejl: " + iae.getMessage());
                                    }
                                }
                                System.out.print("Vælg aktivitetsform (motionist/konkurrence): ");
                                String aktivitetsForm = "";
                                SvømmeDiscipliner svømmeDisciplin = null;
                                double bedsteTid = 0;
                                String harKonkurreret = "";
                                boolean konkurreret = false;
                                boolean validAktivitetsForm = false;

                                while (!validAktivitetsForm) {
                                    try {
                                        aktivitetsForm = scanner.nextLine().toLowerCase();
                                        if (!aktivitetsForm.equals("motionist") && !aktivitetsForm.equals("konkurrence")) {
                                            throw new IllegalArgumentException("Prøv igen");
                                        }
                                        if (aktivitetsForm.equals("motionist")) {
                                            validAktivitetsForm = true;
                                        } else if (aktivitetsForm.equals("konkurrence")) {
                                            System.out.println("Indtast svømmedisciplin (Brystsvømning, Butterfly, Crawl, Rygcrawl): ");
                                            String statusInput1 = "";
                                            boolean validStatus1 = false;
                                            // SvømmeDiscipliner svømmeDiscipliner = null; //TODO SKAL DEN VÆRE DER?

                                            while (!validStatus1) {
                                                try {
                                                    statusInput1 = scanner.nextLine().toUpperCase();
                                                    switch (statusInput1) {
                                                        case "BRYSTSVØMNING":
                                                            svømmeDisciplin = SvømmeDiscipliner.BRYSTSVØMNING;
                                                            break;
                                                        case "BUTTERFLY":
                                                            svømmeDisciplin = SvømmeDiscipliner.BUTTERFLY;
                                                            break;
                                                        case "CRAWL":
                                                            svømmeDisciplin = SvømmeDiscipliner.CRAWL;
                                                            break;
                                                        case "RYGCRAWL":
                                                            svømmeDisciplin = SvømmeDiscipliner.RYGCRAWL;
                                                            break;
                                                        default:
                                                            throw new IllegalArgumentException("Indtast en gyldig svømmedisciplin (Brystsvømning, Butterfly, Crawl, Rygcrawl)");
                                                    }
                                                    validStatus1 = true;
                                                } catch (IllegalArgumentException iae) {
                                                    System.out.println("Fejl: " + iae.getMessage());
                                                }
                                            }
                                            System.out.println("Valgt disciplin: " + svømmeDisciplin);

                                            System.out.println("Indtast bedste tid");
                                            bedsteTid = scanner.nextDouble();
                                            scanner.nextLine();

                                            System.out.println("Indtast om medlemmet har konkurret (ja/nej");
                                            harKonkurreret = scanner.nextLine().trim().toLowerCase();
                                            if (harKonkurreret.equals("ja")) {
                                                konkurreret = true;
                                                validStatus1 = true;
                                                validAktivitetsForm = true;
                                            } else if (harKonkurreret.equals("nej")) {
                                                konkurreret = false;
                                                validStatus1 = true;
                                                validAktivitetsForm = true;
                                            }
                                        }
                                    } catch (IllegalArgumentException iae) {
                                        System.out.println("Fejl FEJL FEJL " + iae.getMessage());
                                    }
                                }
                                if (aktivitetsForm.equals("konkurrence")) {
                                    controller.opretKonkurrenceSvømmer(navn, cpr, status, brugerBetalt, aktivitetsForm, svømmeDisciplin, bedsteTid, konkurreret);

                                } else {
                                    controller.opretMedlem(navn, cpr, status, brugerBetalt, aktivitetsForm);
                                }


                                System.out.println("Medlemmet er blevet oprettet!");
                                break;
                            //________________________slet et medlem____________________________________________________
                            case "2":
                                boolean sletning = true;
                                while (sletning) {
                                    System.out.print("indtast CPR-nummer på det medlem der skal slettes: ");
                                    String medlemCpr = scanner.nextLine();
                                    if (controller.sletMedlem(medlemCpr)) {
                                        System.out.println("medlemmet er blevet slettet!");
                                        sletning = false;
                                    } else {
                                        System.out.println("medlemmet findes ikke, vil du prøve med et nyt CPRnr?");
                                        System.out.println("Indtast ja eller nej");
                                        String svar = scanner.nextLine().toLowerCase();
                                        if (!svar.equals("ja")) {
                                            sletning = false;
                                        }
                                    }
                                }
                                break;
                            //_______________________redigering af medlem_______________________________________________
                            case "3":
                                boolean cprIndtasting = true;

                                while (cprIndtasting) {
                                    System.out.println("Indtast navn på det medlem der skal redigeres: ");
                                    String findMedlem = scanner.nextLine();
                                    Medlem nuværendeMedlem = controller.findSpecifiktMedlem(findMedlem);
                                    String nuværendeNavn = controller.findSpecifiktMedlemsNavn(findMedlem);

                                    if (controller.getMedlemsListen().contains(nuværendeMedlem)) {
                                        System.out.println("Du kan nu redigere i " + nuværendeNavn + "'s oplysninger.");
                                        System.out.println(nuværendeNavn + "'s nuværende informationer");
                                        System.out.println(controller.visMedlemOplysninger(nuværendeNavn));
                                        boolean redigering = true;
                                        while (redigering) {
                                            System.out.println("\n\nHvad vil du gerne redigere: " +
                                                    "\n1. Navn" +
                                                    "\n2. CPR" +
                                                    "\n3. Medlemsstatus" +
                                                    "\n4. Aktivitetsform" +
                                                    "\n5. Betalingsstatus" +
                                                    "\n6. Afslut redigering");


                                            int valgAfRedigering = scanner.nextInt();
                                            scanner.nextLine();


                                            if (valgAfRedigering == 6) {
                                                redigering = false;
                                                continue;
                                            }

                                            boolean validInput = false;
                                            String nyVærdi = "";

                                            if (valgAfRedigering == 1) {
                                                while (!validInput) {
                                                    System.out.println("Indtast nyt navn");
                                                    nyVærdi = scanner.nextLine();
                                                    if (nyVærdi.matches("[æøåa-zA-z\\s]+")) { //Gør at man kun kan skrive bogstaver fra A-Å og lave mellemrum
                                                        validInput = true;
                                                    } else {
                                                        System.out.println("Navnet må kun indenholde bogstaver");
                                                    }
                                                }
                                            } else if (valgAfRedigering == 2) {
                                                while (!validInput) {
                                                    System.out.println("Indast nyt CPR (6 cifre)");
                                                    nyVærdi = scanner.nextLine();
                                                    if (nyVærdi.matches("[0-9]{6}")) {
                                                        try {
                                                            int dag = Integer.parseInt(nyVærdi.substring(0, 2));
                                                            int måned = Integer.parseInt(nyVærdi.substring(2, 4));
                                                            int år = Integer.parseInt(nyVærdi.substring(4, 6));

                                                            if (år >= 0 && år <= LocalDate.now().getYear() % 100) {
                                                                år += 2000;
                                                            } else {
                                                                år += 1900;
                                                            }
                                                            LocalDate.of(år, måned, dag);
                                                            validInput = true;
                                                        } catch (DateTimeException dte) {
                                                            System.out.println("Fejl: CPR indeholder en ugyldig dato");
                                                        }
                                                    } else {
                                                        System.out.println("CPR må kun indenholde tal og skal være 6 cifre langt");
                                                    }

                                                }
                                            } else if (valgAfRedigering == 3) {
                                                while (!validInput) {
                                                    System.out.println("Indtast ny medlemsstatus (aktiv/passiv)");
                                                    nyVærdi = scanner.nextLine();
                                                    if (nyVærdi.equalsIgnoreCase("aktiv") || nyVærdi.equalsIgnoreCase("passiv")) {
                                                        validInput = true;
                                                    } else {
                                                        System.out.println("Medlemsstatus skal være aktiv eller passiv");
                                                    }
                                                }
                                            } else if (valgAfRedigering == 4) {
                                                while (!validInput) {
                                                    System.out.println("Indtast ny aktivitetsform (motionist/konkurrence)");
                                                    nyVærdi = scanner.nextLine();
                                                    if (nyVærdi.equalsIgnoreCase("motionist")) {
                                                        validInput = true;
                                                    } else if (nyVærdi.equalsIgnoreCase("konkurrence svømmer")) {
                                                        validInput = true;
                                                    } else {
                                                        System.out.println("Aktivitetsform skal være motionist eller konkurrence");
                                                    }
                                                }
                                            } else if (valgAfRedigering == 5) {
                                                while (!validInput) {
                                                    System.out.println("Indtast om medlemmet har betalt (ja/nej)");
                                                    nyVærdi = scanner.nextLine();
                                                    if (nyVærdi.equalsIgnoreCase("ja") || nyVærdi.equalsIgnoreCase("nej")) {
                                                        validInput = true;
                                                    } else {
                                                        System.out.println("Betalingsstatus skal være ja eller nej");
                                                    }
                                                }
                                            }
                                            if (validInput) {
                                                controller.redigerMedlem(nuværendeMedlem, valgAfRedigering, nyVærdi);
                                                System.out.println("Opdateret informationer: ");
                                                System.out.println(controller.visMedlemOplysninger(nuværendeNavn));
                                                cprIndtasting = false;
                                            }
                                        }
                                    } else {
                                        System.out.println("Dette medlem findes ikke på listen");
                                        System.out.println("Prøv igen...");
                                    }
                                }
                                controller.gemListeAfMedlemmer();
                                break;
                            //________________________sorter i listen af medlemmer__________________________________
                            case "4":
                                controller.sorteringNavn();
                                System.out.println(controller.visMedlemmerne());

                                boolean sortering = true;
                                while (sortering) {
                                    System.out.println("\n\nHvad vil du sortere efter: " +
                                            "\n1. Medlemsstatus" +
                                            "\n2. Aldersgruppe" +
                                            "\n3. Aktivitetsform" +
                                            "\n4. Gå tilbage til formand menu");

                                    try {
                                        int sorteringsValg = scanner.nextInt();
                                        scanner.nextLine();

                                        if (sorteringsValg == 4) {
                                            sortering = false;
                                            continue;
                                        }

                                        if (sorteringsValg >= 1 && sorteringsValg <= 3) {
                                            controller.sorterMedlemmerValgMetode(sorteringsValg);
                                            System.out.println(controller.visMedlemmerne());
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Indtast et tal mellem 1-4");
                                        scanner.nextLine();
                                    }
                                }
                                break;
                            //________________________tilbage til hovedmenu_________________________________________
                            case "5":
                                formandMenuKører = false;
                                break;
                            default:
                                System.out.println("ugyldigt valg, prøv igen");
                                break;
                        }
                    }

                    break;
                //______________________________kasserer Menu______________________________________________________
                case "2":
                    boolean kassererMenuKører = true;
                    while (kassererMenuKører) {
                        System.out.println("Kasserer Menu:" +
                                "\n1 for at se den forventede indkomst i kontingent til klubben" +
                                "\n2 for at se medlemmer der har betalt" +
                                "\n3 for at se medlemmer i restance" +
                                "\n4 for at se antallet af medlemmer i klubben" +
                                "\n5 for at gå tilbage til hovedmenuen" +
                                "\n\nVælg en mulighed: \n");

                        String brugerValg = scanner.nextLine();

                        switch (brugerValg) {
                            //________________________forventet indkomst i svømmeklubben________________________________
                            case "1":
                                System.out.println("det forventede indkomst i form af kontingent for svømmeklubben er:  " +
                                        controller.forventetKontingent() + " kr. årligt\n");
                                break;
                            //________________________medlemmer der har betalt kontingent_______________________________
                            case "2":
                                System.out.println("medlemmer der har betalt kontingent: ");
                                System.out.println(controller.medlemmerDerHarBetalt());
                                System.out.println("der er lige nu indbetalt: " + controller.indbetaltKontingentForNu());
                                break;
                            //________________________medlemmer i restance______________________________________________
                            case "3":
                                System.out.println("medlemmer der mangler at betale kontingent er:");
                                System.out.println(controller.medlemmerIRestance());
                                System.out.println("der er lige nu " + controller.restanceBeløb() + " kr. i restance, i klubben\n");
                                break;
                            //________________________antal af medlemmer i svømmeklubben________________________________
                            case "4":
                                System.out.println("der er " + controller.antalAfMedlemmer() + " medlemmer i klubben pr. dags dato");
                                break;
                            //________________________tilbage til hovedmenu_____________________________________________
                            case "5":
                                kassererMenuKører = false;
                                break;
                            default:
                                System.out.println("ugyldigt valg, prøv igen");
                                break;
                        }
                    }
                    break;
                //________________________træner menu___________________________________________________________________
                case "3":
                    boolean trænerMenuKører = true;
                    while (trænerMenuKører) {
                        System.out.println("Træner Menu:" +
                                "\n1 for at se en oversigt over klubbens konkurrencesvømmere" +
                                "\n2 for at se en oversigt over svømmernes bedste resultater" +
                                "\n3 for at se en oversigt over svømmere som har deltaget i konkurrencer" +
                                "\n4 for at se en oversigt over top5 svømmere inden for hver disciplin" +
                                "\n5 for at redigere i konkurrencesvømmerne" +
                                "\n6 for at gå tilbage til hovedmenuen" +
                                "\n\nVælg en mulighed: \n");

                        String brugerValg = scanner.nextLine();

                        switch (brugerValg) {

                            case "1": //TODO: refaktorer
                                System.out.println("Liste over klubbens konkurrencesvømmere: ");
                                controller.sorteringNavn();
                                System.out.println(controller.hentKonkurrenceSvømmere());
                                break;
                            case "2":
                                controller.sorteringTid();
                                System.out.println("Liste over svømmernes bedste resultater: ");

                                System.out.println("Junior holdet: ");
                                System.out.println(controller.visJuniorHold());

                                System.out.println("Senior holdet: ");
                                System.out.println(controller.visSeniorHold());
                                break;
                            case "3":
                                controller.sorteringKonkurrenceStatus();
                                System.out.println("Liste over svømmere som har deltaget i konkurrence");

                                System.out.println("Junior holdet: ");
                                System.out.println(controller.visJuniorHold());

                                System.out.println("Senior holdet: ");
                                System.out.println(controller.visSeniorHold());

                                System.out.print("Vil du tilføje et resultat for en svømmer? (ja/nej): ");
                                String svar1 = scanner.next();

                                if (svar1.equalsIgnoreCase("ja")) {
                                    System.out.println("Vælg om det skal være fra junior eller senior");
                                    String svar = scanner.next();

                                    if (svar.equalsIgnoreCase("senior")) {
                                        System.out.println(controller.visSeniorHold());
                                        System.out.print("Vælg en svømmer fra senior holdet ved at indtaste svømmerens nummer: \n");
                                        int svømmerValg = scanner.nextInt();
                                        scanner.nextLine(); // Ryd scanner-bufferen

                                        ArrayList<KonkurrenceSvømmer> seniorSvømmere = controller.hentSeniorHold();

                                        if (svømmerValg >= 1 && svømmerValg <= seniorSvømmere.size()) {
                                            KonkurrenceSvømmer valgtSvømmer = seniorSvømmere.get(svømmerValg - 1);
                                            System.out.println("Du har valgt: " + valgtSvømmer);

                                            // Indtast konkurrenceresultater
                                            System.out.print("Indtast stævnenavn: ");
                                            String stævne = scanner.nextLine();

                                            System.out.print("Indtast placering: ");
                                            int placering = scanner.nextInt();

                                            System.out.print("Indtast tid (i sekunder): ");
                                            double tid = scanner.nextDouble();

                                            scanner.nextLine();  // Ryd scanner-bufferen

                                           // Spørg om datoen
                                            System.out.print("Indtast dato for konkurrencen (yyyy-MM-dd): ");
                                            String datoStr = scanner.nextLine();
                                            LocalDate dato = LocalDate.parse(datoStr);

                                           // Tilføj resultatet med datoen
                                            valgtSvømmer.tilføjKonkurrenceresultat(stævne, placering, tid, dato);

                                            System.out.println("Resultat tilføjet til " + valgtSvømmer.getNavn() + "\n\n");
                                            System.out.println("Liste over alle konkurrencemedlemmer:");
                                        } else {
                                            System.out.println("Ugyldigt valg af svømmer.");
                                        }
                                    } else if (svar.equalsIgnoreCase("junior")) {
                                        System.out.println(controller.visJuniorHold());
                                        System.out.print("Vælg en svømmer fra junior holdet ved at indtaste svømmerens nummer: \n");
                                        int svømmerValg1 = scanner.nextInt();
                                        scanner.nextLine(); // Ryd scanner-bufferen

                                        ArrayList<KonkurrenceSvømmer> juniorSvømmere = controller.hentJuniorHold();

                                        if (svømmerValg1 >= 1 && svømmerValg1 <= juniorSvømmere.size()) {
                                            KonkurrenceSvømmer valgtSvømmer = juniorSvømmere.get(svømmerValg1 - 1);
                                            System.out.println("Du har valgt: " + valgtSvømmer);

                                            // Indtast konkurrenceresultater
                                            System.out.print("Indtast stævnenavn: ");
                                            String stævne = scanner.nextLine();

                                            System.out.print("Indtast placering: ");
                                            int placering = scanner.nextInt();

                                            System.out.print("Indtast tid (i sekunder): ");
                                            double tid = scanner.nextDouble();

                                            scanner.nextLine();  // Ryd scanner-bufferen

                                           // Spørg om datoen
                                            System.out.print("Indtast dato for konkurrencen (yyyy-MM-dd): ");
                                            String datoStr = scanner.nextLine();
                                            LocalDate dato = LocalDate.parse(datoStr);

                                           // Tilføj resultatet med datoen
                                            valgtSvømmer.tilføjKonkurrenceresultat(stævne, placering, tid, dato);

                                            System.out.println("Resultat tilføjet til " + valgtSvømmer.getNavn() + "\n\n");
                                            System.out.println("Liste over alle konkurrencemedlemmer:");
                                            //System.out.println(controller.visJuniorHold());
                                        } else {
                                            System.out.println("Ugyldigt valg af svømmer.");
                                        }
                                    } else {
                                        System.out.println("Ugyldigt valg. Vælg enten 'junior' eller 'senior'.");
                                    }
                                }
                                // Saml begge hold i én liste og gem dem
                                ArrayList<KonkurrenceSvømmer> alleSvømmere = new ArrayList<>();
                                alleSvømmere.addAll(controller.hentJuniorHold()); //TODO: forklaring af addAll
                                alleSvømmere.addAll(controller.hentSeniorHold());
                                controller.gemKonkurrenceSvømmere(alleSvømmere);
                                break;
                            case "4":
                                boolean svømmediscipliner = true;
                                while (svømmediscipliner) {
                                    System.out.println("I hvilken svømmedisciplin vil du se top 5 svømmere?\n" +
                                            "1 Butterfly\n" +
                                            "2 Crawl\n" +
                                            "3 Rygcrawl\n" +
                                            "4 Brystsvømning\n" +
                                            "5 tilbage til træner menu");

                                    int top5 = scanner.nextInt();
                                    switch (top5) {
                                        case 1:
                                            System.out.println("Junior holdet: ");
                                            System.out.println(controller.printTop5(AldersGruppe.JUNIOR, SvømmeDiscipliner.BUTTERFLY));

                                            System.out.println("Senior holdet: ");
                                            System.out.println(controller.printTop5(AldersGruppe.SENIOR, SvømmeDiscipliner.BUTTERFLY));
                                            break;
                                        case 2:
                                            System.out.println("Junior holdet: ");
                                            System.out.println(controller.printTop5(AldersGruppe.JUNIOR, SvømmeDiscipliner.CRAWL));

                                            System.out.println("Senior holdet: ");
                                            System.out.println(controller.printTop5(AldersGruppe.SENIOR, SvømmeDiscipliner.CRAWL));
                                            break;
                                        case 3:
                                            System.out.println("Junior holdet: ");
                                            System.out.println(controller.printTop5(AldersGruppe.JUNIOR, SvømmeDiscipliner.RYGCRAWL));

                                            System.out.println("Senior holdet: ");
                                            System.out.println(controller.printTop5(AldersGruppe.SENIOR, SvømmeDiscipliner.RYGCRAWL));
                                            break;
                                        case 4:
                                            System.out.println("Junior holdet: ");
                                            System.out.println(controller.printTop5(AldersGruppe.JUNIOR, SvømmeDiscipliner.BRYSTSVØMNING));

                                            System.out.println("Senior holdet: ");
                                            System.out.println(controller.printTop5(AldersGruppe.SENIOR, SvømmeDiscipliner.BRYSTSVØMNING));
                                            break;
                                        case 5:
                                            svømmediscipliner = false;
                                            break;
                                        default:
                                            System.out.println("vælg mellem 1 og 5");
                                            break;
                                    }

                                }

                                break;

                            case "5":
                                boolean findSvømmer = true;
                                while (findSvømmer) {
                                    System.out.println("Indtast fulde navn på den konkurrencesvømmer du vil redigere: ");
                                    String findKonkurrenceSvømmer = scanner.nextLine().trim();
                                    Medlem nuværendeKonkurrenceSvømmer = controller.findSpecifiktKonkurrenceSvømmer(findKonkurrenceSvømmer);
                                    String nuværendeSvømmerNavn = controller.findSpecifiktKonkurrenceSvømmersNavn(findKonkurrenceSvømmer);

                                    if (nuværendeKonkurrenceSvømmer != null) {
                                        System.out.println("Du kan nu redigere i " + nuværendeSvømmerNavn + "'s svømme oplysninger: ");
                                        System.out.println(nuværendeKonkurrenceSvømmer);

                                        boolean ændreKonkurrenceSvømmer = true;
                                        while (ændreKonkurrenceSvømmer) {
                                            System.out.println("Vælg hvilken kategori du vil ændre i: " +
                                                    "\n1 for at redigere i resultater" +
                                                    "\n2 for at redigere svømmedisciplin" +
                                                    "\n3 for at redigere om svømmeren er konkurrencesvømmer" +
                                                    "\n4 for at gå tilbage til trænermenuen" +
                                                    "\n\nVælg en mulighed: \n");

                                            String brugerValg2 = scanner.nextLine();


                                            switch (brugerValg2) {
                                                case "1":
                                                    System.out.println("Du kan nu ændre i svømmerens resultater");
                                                    System.out.println(nuværendeSvømmerNavn + "'s nuværende bedste svømmetid: " + ((KonkurrenceSvømmer) nuværendeKonkurrenceSvømmer).getBedsteTid());
                                                    System.out.println("Indtast ny bedste svømme tid: ");
                                                    double nySvømmetid = scanner.nextDouble();
                                                    scanner.nextLine();
                                                    String formatteretNySvømmetid = String.valueOf(nySvømmetid);
                                                    controller.ændringAfKonkurrenceSvømmer(nuværendeKonkurrenceSvømmer, 1, formatteretNySvømmetid);
                                                    System.out.println(nuværendeSvømmerNavn + "'s opdateret bedste svømmetid: " + ((KonkurrenceSvømmer) nuværendeKonkurrenceSvømmer).getBedsteTid());
                                                    break;

                                                case "2":
                                                    System.out.println("Du kan nu ændre i svømmedisciplin");
                                                    System.out.println(nuværendeSvømmerNavn + "'s nuværende svømmedisciplin: " + ((KonkurrenceSvømmer) nuværendeKonkurrenceSvømmer).getSVØMMEDISCIPLIN());
                                                    System.out.println("Indtast ny svømmedisciplin: ");
                                                    SvømmeDiscipliner nySvømmedisciplinValg = SvømmeDiscipliner.parseSvømmeDescipliner(scanner.next());
                                                    scanner.nextLine();
                                                    String nySvømmedisciplin = String.valueOf(nySvømmedisciplinValg);
                                                    controller.ændringAfKonkurrenceSvømmer(nuværendeKonkurrenceSvømmer, 2, nySvømmedisciplin);
                                                    System.out.println(nuværendeSvømmerNavn + "'s opdateret svømmedisciplin:  " + ((KonkurrenceSvømmer) nuværendeKonkurrenceSvømmer).getSVØMMEDISCIPLIN());
                                                    break;
                                                case "3":
                                                    System.out.println("Du kan nu ændre konkurrencestatus");
                                                    System.out.println(nuværendeSvømmerNavn + "'s nuværende konkurrencestatus: ");
                                                    System.out.println("Har " + nuværendeSvømmerNavn + " konkurreret før? (ja/nej)");
                                                    String nyKonkurrencestatus = scanner.nextLine();
                                                    controller.ændringAfKonkurrenceSvømmer(nuværendeKonkurrenceSvømmer, 3, nyKonkurrencestatus);
                                                    if (nyKonkurrencestatus.equalsIgnoreCase("ja")) {
                                                        System.out.println(nuværendeSvømmerNavn + "'s opdateret konkurrencestatus: ja (Har konkurreret)");
                                                    } else if (nyKonkurrencestatus.equalsIgnoreCase("nej")) {
                                                        System.out.println(nuværendeSvømmerNavn + "'s opdateret konkurrencestatus: nej (Har ikke konkurreret)");
                                                    } else {
                                                        System.out.println("Ugyldig værdi. Prøv igen");
                                                    }
                                                    break;

                                                case "4":
                                                    ændreKonkurrenceSvømmer = false;
                                                    break;
                                                default:
                                                    System.out.println("ugyldigt valg, prøv igen");
                                                    break;
                                            }

                                        }
                                        break;
                                    }
                                }
                                break;
                            case "6":
                                trænerMenuKører = false;
                                break;
                            default:
                                System.out.println("ugyldigt valg, prøv igen");
                                break;
                        }
                    }
                    break;

                //________________________luk programmet ned____________________________________________________________
                case "4":
                    System.out.println("Programmet lukkes ned....");
                    kører = false;
                    break;
                default:
                    System.out.println("Ugyldigt valgt. Indtast 1,2,3 eller 4");
                    break;
            }

        }
    }
}




