

public class Main {

    public static void main(String[] args) {
        Formand formand = new Formand();
        Kasserer kasserer = new Kasserer();

   // formand.tilføjMedlem("Kasper","011275", MedlemsStatus.AKTIV,"motionist", true);
    //formand.tilføjMedlem("Lær","121156",MedlemsStatus.PASSIV,"konkurrence", false);
      // formand.tilføjMedlem("Camilla", "061026", MedlemsStatus.AKTIV, "konkurrence", true);
     //formand.tilføjMedlem("isa", "020202", MedlemsStatus.AKTIV,"motionist", true);
        //formand.tilføjMedlem("isa", "020202", MedlemsStatus.AKTIV,"motionist", false);

       formand.visMedlemmer();


        Medlem medlem1 = new Medlem("Camilla", "061026", MedlemsStatus.AKTIV, "konkurrence", false);
        Medlem medlem2 = new Medlem("Lærke", "231119", MedlemsStatus.PASSIV, "motionist", false);
        Medlem medlem3 = new Medlem("Christian", "100894", MedlemsStatus.AKTIV, "konkurrence", true);

        System.out.println("\n");
        System.out.println("Svømmeklubbens samlede forventede betalte kontigent: " + kasserer.forventetKontigentIndkomst() + " kr.");
        System.out.println("Svømmeklubbens samlede restance kontigent: " + kasserer.restanceKontingent() + " kr.");
        System.out.println("\n");

        System.out.println("\n");
        System.out.println("Svømmeklubbens samlede restance af kontigent: " + kasserer.restanceKontingent() + " kr.");
        System.out.println("\n");

        medlem1.cprOmregning();
        System.out.println(medlem1);
        medlem2.cprOmregning();
        System.out.println(medlem2);
        medlem3.cprOmregning();
        System.out.println(medlem3);
    }
}
