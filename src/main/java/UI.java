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
                                if (harBetalt.equalsIgnoreCase("ja")){
                                    brugerBetalt = true;
                                } else{
                                brugerBetalt = false;
                                }

                                controller.opretMedlem(navn, cpr, status, aktivitetsForm,brugerBetalt);

                                System.out.println("Medlemmet er blevet oprettet!");
                                break;
                            case "2":
                               // sletMedlem();
                                break;
                            case "3":
                                System.out.println("her kommer redigerMedlem");
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


    /*
    private void opretMedlem() {

    }

    private void sletMedlem() {
        System.out.print("Indtast CPR-nummer på det medlem der skal slettes: ");
        String cpr = scanner.nextLine();
        controller.sletMedlem(cpr);
        System.out.println("Medlem er blevet slettet!");
    }
*/


    }






