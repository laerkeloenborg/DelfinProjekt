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

                                String navn = scanner.nextLine();

                                System.out.print("Indtast CPR (6 cifre): ");
                                String cpr = scanner.nextLine();

                                System.out.print("Vælg medlemsstatus (aktiv/passiv): ");
                                String statusInput = scanner.nextLine().toLowerCase();
                                MedlemsStatus status = statusInput.equals("aktiv") ? MedlemsStatus.AKTIV : MedlemsStatus.PASSIV;

                                System.out.print("Vælg aktivitetsform (motionist/konkurrence): ");
                                String aktivitetsForm = scanner.nextLine().toLowerCase();

                                System.out.println("Har medlemmet betalt? (ja/nej):  ");
                                String harBetalt = scanner.nextLine().toLowerCase();
                                boolean brugerBetalt;
                                if (harBetalt.equalsIgnoreCase("ja")) {
                                    brugerBetalt = true;
                                } else {
                                    brugerBetalt = false;
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

                                    if (valgAfRedigering == 2) {
                                        System.out.println("Indtast ny information: ");
                                        String ny = scanner.nextLine();
                                        Medlem medlem1 = nuværendeMedlem;
                                        medlem1.cprOmregning();

                                        controller.redigerMedlem(medlem1, valgAfRedigering, ny);

                                        System.out.println("Opdateret informationer: ");
                                        System.out.println(medlem1);

                                    } else if (valgAfRedigering == 1 || valgAfRedigering == 3 || valgAfRedigering == 4 || valgAfRedigering == 5) {
                                        System.out.println("Indtast ny information:");
                                        String newValue = scanner.nextLine();

                                        controller.redigerMedlem(controller.findSpecifiktMedlem(findMedlem), valgAfRedigering, newValue);

                                        System.out.println("\nOpdateret informationer: ");
                                        System.out.println(controller.findSpecifiktMedlem(findMedlem));
                                    } else {
                                        System.out.println("ugyldigt");
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
                case "2":
                    System.out.println("Kasserer menu kommer her");
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

