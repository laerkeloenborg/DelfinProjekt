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
                    formandMenu();
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

    private void formandMenu() {
    boolean formandMenuKører = true;
    while (formandMenuKører) {
        System.out.println("Formand Menu");
        System.out.println("1 for at oprette nyt medlem");
        System.out.println("2 for at slette et medlem");
        System.out.println("3 for at redigere et medlem");
        System.out.println("4 for at se medlemsliste");
        System.out.println("5 for at gå tilbage");
        System.out.println("Vælg en mulighed");

        String valg = scanner.nextLine();

        switch (valg) {
            case "1":
                opretMedlem();
                break;
            case "2":
                sletMedlem();
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
    }

    private void opretMedlem() {
        System.out.println("Opret nyt medlem");

        System.out.print("Indtast navn: ");
        String navn = scanner.nextLine();

        System.out.print("Indtast CPR (6 cifre): ");
        String cpr = scanner.nextLine();

        System.out.print("Vælg medlemsstatus (aktiv/passiv): ");
        String statusInput = scanner.nextLine().toLowerCase();
        MedlemsStatus status = statusInput.equals("aktiv") ? MedlemsStatus.AKTIV : MedlemsStatus.PASSIV;

        System.out.print("Vælg aktivitetsform (motionist/konkurrence): ");
        String aktivitetsForm = scanner.nextLine().toLowerCase();

        controller.opretMedlem(navn, cpr, status, aktivitetsForm);

        System.out.println("Medlemmet er blevet oprettet!");
    }

    private void sletMedlem() {
        System.out.print("Indtast CPR-nummer på det medlem der skal slettes: ");
        String cpr = scanner.nextLine();
        controller.sletMedlem(cpr);
        System.out.println("Medlem er blevet slettet!");
    }



    }






