import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
    private Scanner scanner;
    private Controller controller;


    public UI() {
        scanner = new Scanner(System.in);
        controller = new Controller();
    }

    public void start() {
        boolean kører = true;
        while (kører) {
            System.out.println("Velkommen til Svømmeklubben Delfinen" +
                    "\n1 for Formand Menu" +
                    "\n2 for Kasserer Menu" +
                    "\n3 for Træner Menu" +
                    "\n4 for at afslutte" +
                    "\n\nVælg en mulighed (1-4): \n");

            String valg = scanner.nextLine();

            switch (valg) {
                case "1":
                    boolean formandMenuKører = true;
                    while (formandMenuKører) {
                        System.out.println("Formand Menu" +
                                "\n1 for at oprette nyt medlem" +
                                "\n2 for at slette et medlem" +
                                "\n3 for at redigere et medlem" +
                                "\n4 for at se medlemsliste" +
                                "\n5 for at gå tilbage til hovedmenuen" +
                                "\n\nVælg en mulighed: \n");

                        String brugerValg = scanner.nextLine();

                        switch (brugerValg) {
                            case "1":
                                System.out.println("Opret nyt medlem" +
                                        "\nIndtast navn: ");
                                String navn = "";
                                boolean validNavn = false;

                                while (!validNavn) {
                                    try {
                                        navn = scanner.nextLine();
                                        if (!navn.matches("[æøåa-zA-Z]+")) { //Gør at man kun kan skrive bogstaver fra A-Z - Der kan tilføjes ÆØÅ
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

                                System.out.print("Vælg aktivitetsform (motionist/konkurrence): ");
                                String aktivitetsForm = "";
                                boolean validAktivitetsForm = false;

                                while (!validAktivitetsForm) {
                                    try {
                                        aktivitetsForm = scanner.nextLine().toLowerCase();
                                        if (!aktivitetsForm.equals("motionist") && !aktivitetsForm.equals("konkurrence")) {
                                            throw new IllegalArgumentException("Indtast motionist eller konkurrence");
                                        }
                                        validAktivitetsForm = true;
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

                                controller.opretMedlem(navn, cpr, status, aktivitetsForm, brugerBetalt);

                                System.out.println("Medlemmet er blevet oprettet!");
                                break;
                            case "2":
                                System.out.print("Indtast CPR-nummer på det medlem der skal slettes: ");
                                String medlemCpr = scanner.nextLine();
                                controller.sletMedlem(medlemCpr);
                                System.out.println("Medlem er blevet slettet!");
                                break;
                            case "3":
                                System.out.println("Indtast CPR-nummer på det medlem der skal redigeres: ");
                                String findMedlem = scanner.nextLine();
                                Medlem nuværendeMedlem = controller.findSpecifiktMedlem(findMedlem);
                                String nuværendeNavn = controller.findSpecifiktMedlemsNavn(findMedlem);
                                System.out.println("Du kan nu redigere i " + nuværendeNavn + "'s oplysninger.");

                                System.out.println(nuværendeNavn + "'s nuværende informationer");
                                System.out.println(nuværendeMedlem);


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
                                            if (nyVærdi.matches("[æøåa-zA-z]+")) {
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
                                            if (nyVærdi.equalsIgnoreCase("motionist") || nyVærdi.equalsIgnoreCase("konkurrence")) {
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
                                        System.out.println(nuværendeMedlem);
                                    }
                                }
                                controller.gemListeAfMedlemmer();
                                break;
                            case "4":
                                System.out.println("\n\nHvad vil sortere efter: " +
                                        "\n1. Medlemsstatus" +
                                        "\n2. Aldersgruppe" +
                                        "\n3. Aktivitetsform" +
                                        "\n4. Afslut");

                                boolean sortering = true;
                                while (sortering) {
                                    int sorteringsValg = scanner.nextInt();
                                    scanner.nextLine();

                                    if (sorteringsValg == 4) {
                                        sortering = false;
                                        continue;
                                    }

                                    if (sorteringsValg >= 1 && sorteringsValg <= 3) {
                                        controller.sorterMedlemmerValgMetode(sorteringsValg);
                                    } else {
                                        System.out.println("Ugyldigt valg");
                                    }
                                }
                                break;

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
                                "\n2 for at se beløb i restance" +
                                "\n3 for at se medlemmer i restance" +
                                "\n4 for at gå tilbage til hovedmenuen" +
                                "\n\nVælg en mulighed: \n");

                        String brugerValg = scanner.nextLine();

                        switch (brugerValg) {
                            case "1":
                                System.out.println("det forventede indkomst i form af kontingent for svømmeklubben er:  ");
                                System.out.print(controller.forventetKontingent() + " kr. årligt\n");
                                break;
                            case "2":
                                System.out.println("der er lige nu " + controller.restanceBeløb() + " kr. i restance imellem medlemmerne i klubben\n");
                                break;
                            case "3":
                                System.out.println("medlemmer der mangler at betale kontingent er:");
                                System.out.println(controller.medlemmerIRestance());
                                break;
                            case "4":
                                kassererMenuKører = false;
                                break;
                            default:
                                System.out.println("ugyldigt valg, prøv igen");
                                break;
                        }
                    }
                    break;
                case "3":
                    System.out.println("Træner menu kommer her");
                    break;
                case "4":
                    System.out.println("Programmet lukkes ned....");
                    kører = false;
                    break;
                default:
                    System.out.println("Ugyldigt valgt. Indtast 1,2,3");
                    break;
            }
        }
    }


}

