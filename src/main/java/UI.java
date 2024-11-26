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
                                System.out.println("Du kan nu redigere i " + controller.findSpecifiktMedlemsNavn(findMedlem) + "'s oplysninger.");

                                System.out.println(controller.findSpecifiktMedlemsNavn(findMedlem) + "'s nuværende informationer");
                                System.out.println(controller.findSpecifiktMedlem(findMedlem));


                                boolean redigering = true;
                                while (redigering){
                                System.out.println("\n\nHvad vil du gerne redigere: " +
                                        "\n1. Navn" +
                                        "\n2. CPR" +
                                        "\n3. Medlemsstatus" +
                                        "\n4. Aktivitetsform" +
                                        "\n5. Betalingsstatus");


                                int valgAfRedigering = scanner.nextInt();
                                scanner.nextLine();


                                if(valgAfRedigering == 5){
                                redigering = false;
                                continue;
                                }

                                    if (valgAfRedigering >= 1 && valgAfRedigering <= 5) {
                                        System.out.println("Indtast ny information:");
                                        String newValue = scanner.nextLine();

                                        controller.redigerMedlem2(controller.findSpecifiktMedlem(findMedlem), valgAfRedigering, newValue);

                                        System.out.println("\nUpdateret informationer: ");
                                        System.out.println(controller.findSpecifiktMedlem(findMedlem));
                                    } else {
                                        System.out.println("ugyldigt");
                                    }
                                }

                                break;
                            case "4":
                                System.out.println("Her kommer medlemssortering");
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
                    System.out.println("Programmet afsluttes");
                    kører = false;
                    break;
                default:
                    System.out.println("Ugyldigt valgt. Indtast 1,2,3");
                    break;
            }
        }
    }


}


/*

                                switch (valgAfRedigering){
                                    case 1:
                                        System.out.println("Indtast nyt navn: ");
                                        String nytNavn = scanner.nextLine();
                                        controller.opretMedlem(nytNavn, controller.getMedlemCpr(), controller.getMedlemMedlemsStatus(), controller.getMedlemAktivitetsForm(), controller.getMedlemBetalingsstatus());
                                        break;
                                    case 2:
                                        System.out.print("Indtast nyt CPR (6 cifre): ");
                                        String nytCpr = scanner.nextLine();
                                        break;
                                    case 3:
                                        System.out.print("Vælg ny medlemsstatus (aktiv/passiv): ");
                                        String nyStatusInput = scanner.nextLine().toLowerCase();
                                        MedlemsStatus nyStatus = nyStatusInput.equals("aktiv") ? MedlemsStatus.AKTIV : MedlemsStatus.PASSIV;
                                        break;
                                    case 4:
                                        System.out.print("Vælg ny aktivitetsform (motionist/konkurrence): ");
                                        String nyAktivitetsForm = scanner.nextLine().toLowerCase();
                                        break;
                                    case 5:
                                        System.out.println("Har medlemmet betalt? (ja/nej):  ");
                                        String nyHarBetalt = scanner.nextLine().toLowerCase();
                                        boolean brugerBetaltNu;
                                        if (nyHarBetalt.equalsIgnoreCase("ja")) {
                                            brugerBetaltNu = true;
                                        } else {
                                            brugerBetaltNu = false;
                                        }
                                        break;
                                    default:
                                        System.out.println("Ugyldig indtastning");

 */



